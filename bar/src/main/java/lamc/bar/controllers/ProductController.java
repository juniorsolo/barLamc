package lamc.bar.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		try {
			List<Product> lista =  productService.findAllActive();
			response.setData(lista);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			response.getErrors().add("Can't be get all products. " + e.getMessage());
			log.error("Error in get all products. " + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Response<Product>> productById(@PathVariable Integer id){
		
		Response<Product> response = new Response<>();
		
		try {
			if(id == null || id == 0) {
				response.getErrors().add("Id of product invalid.");
				return ResponseEntity.badRequest().body(response);
			}
			
			Optional<Product> product =  productService.findById(id);
			
			if(!product.isPresent()) {
				response.getErrors().add("Produto não encontrado.");
				return ResponseEntity.badRequest().body(response);
			}		
			
			response.setData(product.get());		
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			response.getErrors().add("Can't be get product by id. " + e.getMessage());
			log.error("Error in get product by id. " + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	
	@PostMapping
	//@PreAuthorize("hasAnyRole('STOCKHOLDER', 'ADMIN')")
	public ResponseEntity<Response<Product>> createProduct(@RequestBody Product productReq, BindingResult result){
		
		Response<Product> response = new Response<>();
		try {
			this.validateCreate(productReq, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			Product product =  productService.save(productReq);
			response.setData(product);
			return ResponseEntity.ok(response);			
		}catch (Exception e) {
			response.getErrors().add("Product can't be created." + e.getMessage());
			log.error("Error product can't be created." + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	private void validateCreate(Product productReq, BindingResult result) {
		if(productReq == null) {
			result.addError(new ObjectError("Product", "Object Product can't be null."));
			return;
		}
		if(StringUtils.isBlank(productReq.getName())) {
			result.addError(new ObjectError("Product", "Name object cannot be null."));
		}

	}
	
	@PutMapping
	//@PreAuthorize("hasAnyRole('STOCKHOLDER', 'ADMIN')")
	public ResponseEntity<Response<Product>> updateProduct(@RequestBody Product productReq, BindingResult result){
		Response<Product> response = new Response<>();
		try {
			this.validateUpdate(productReq, result);
			
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			
			Product product =  productService.save(productReq);
			response.setData(product);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			response.getErrors().add("Product can't be updated." + e.getMessage());
			log.error("Error product can't be updated." + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	private void validateUpdate(Product productReq, BindingResult result) {
		if(productReq == null) {
			result.addError(new ObjectError("Product", "Object Product can't be null."));
			return;
		}
		if(productReq.getId() == null || productReq.getId() == 0) {
			result.addError(new ObjectError("Product", "ID object cannot be null or zero."));
		}
		if(StringUtils.isBlank(productReq.getName())) {
			result.addError(new ObjectError("Product", "Name object cannot be null."));
		}

	}
	
	@DeleteMapping
	@PreAuthorize("hasAnyRole('STOCKHOLDER', 'ADMIN')")
	public ResponseEntity<Response<Product>> deleteProduct(@RequestBody Integer id, BindingResult result){
		Response<Product> response = new Response<>();
		try {
			Optional<Product> productFinded =  productService.findById(id);
			if(!productFinded.isPresent() ) {
				response.getErrors().add("Não é um produto válido");
				return ResponseEntity.badRequest().body(response);
			}
			productFinded.get().setActive(false);
			productService.save(productFinded.get());
			return ResponseEntity.ok(response);			
		}catch (Exception e) {
			response.getErrors().add("Product can't be deleted." + e.getMessage());
			log.error("Error product can't be deleted." + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

}
