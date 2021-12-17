package lamc.bar.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lamc.bar.entity.Price;
import lamc.bar.entity.Product;
import lamc.bar.repository.PriceRepository;
import lamc.bar.repository.ProductRepository;
import lamc.bar.service.ProductService;

/**
 * 24/11/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private PriceRepository priceRepo;
	
	@Override
	public List<Product> findAll() {
		try {
			return productRepo.findAll();
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Product> findAllActive() {
		try {
			return productRepo.findByActive(true);
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public Optional<Product> findById(Integer id) {
		try {
			return productRepo.findById(id);
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	@Override
	public Product save(Product product) {
		try {
			return productRepo.save(product);
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public Product savePrice(Integer idProduct, Price price) {
		try {
			Optional<Product> productOptional = productRepo.findById(idProduct);
			Product productFinded = productOptional.get();
			
			
			if( productFinded.getPrice() != null) {
				productFinded.getPrice().setDateEnd(new Date());
				productFinded = productRepo.save(productFinded);
				productFinded.getPrice().setProduct(null);
				productFinded = productRepo.save(productFinded);
				
			}
			price.setDateEnd(null);
			price.setDateCreate(new Date());
			price.setId(null);
			Price priceFinded = priceRepo.save(price);
			productFinded.setPrice(priceFinded);
			priceFinded.setProduct(productFinded);
			productFinded = productRepo.save(productFinded);	
			
			return productFinded;
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	

}
