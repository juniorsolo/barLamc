package lamc.bar.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lamc.bar.entity.Product;
import lamc.bar.response.Response;
import lamc.bar.service.ProductService;

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = "*")
public class ProductController {
	
	Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<Response<List<Product>>> allProducts(){
		Response<List<Product>> response = new Response<>();
		List<Product> lista =  productService.findAll();
		response.setData(lista);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Response<Product>> productById(@PathVariable Integer id){
		Response<Product> response = new Response<>();
		Optional<Product> member =  productService.findById(id);
		response.setData(member.isPresent() ? member.get() : null);
		return ResponseEntity.ok(response);
	}
}
