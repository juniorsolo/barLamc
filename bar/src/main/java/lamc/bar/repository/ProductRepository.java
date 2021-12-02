package lamc.bar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lamc.bar.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByActive(Boolean active);

}
