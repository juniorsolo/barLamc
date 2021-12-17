package lamc.bar.service;

import java.util.List;
import java.util.Optional;

import lamc.bar.entity.Price;
import lamc.bar.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	public List<Product> findAllActive();
	public Optional<Product> findById(Integer id);
	public Product save(Product product);
	public Product savePrice(Integer idProduct, Price price);
}
