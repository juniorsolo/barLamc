package lamc.bar.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lamc.bar.entity.Product;
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
	


}
