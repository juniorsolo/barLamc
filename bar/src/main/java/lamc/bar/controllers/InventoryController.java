package lamc.bar.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lamc.bar.entity.Inventory;
import lamc.bar.entity.Product;
import lamc.bar.response.Response;
import lamc.bar.service.InventoryService;
import lamc.bar.service.ProductService;

/**
 * 03/12/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
@RestController
@RequestMapping("api/inventory")
@CrossOrigin(origins = "*")
public class InventoryController {

	Logger log = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private ProductService productService;

	@GetMapping(value = "{idProduto}")
	public ResponseEntity<Response<List<Inventory>>> inventoryByProduto(@PathVariable Integer idProduto) {

		Response<List<Inventory>> response = new Response<>();

		try {
			if (idProduto == null || idProduto <= 0) {
				response.getErrors().add("Id do produto inválido.");
				return ResponseEntity.badRequest().body(response);
			}
			
			Optional<Product> productFinded = productService.findById(idProduto);
			
			if(!productFinded.isPresent()) {
				response.getErrors().add("O produto informado esta incorreto.");
				return ResponseEntity.badRequest().body(response);
			}
			
			List<Inventory> listInventory = inventoryService.findAllActiveByIdProduto(idProduto);


			response.setData(listInventory);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add("Can't be get inventory by id of product. " + e.getMessage());
			log.error("Error in get inventory by id of product. " + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@PostMapping
	public ResponseEntity<Response<Inventory>> createInventory(@RequestBody Inventory inventoryReq, BindingResult result){
		Response<Inventory> response = new Response<>();
		try {
			this.validateCreate(inventoryReq, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			
			//Obtendo produto...
			Optional<Product> productFinded = productService.findById(inventoryReq.getProduct().getId());
			
			if(productFinded.isEmpty()) {
				response.getErrors().add("Produto informado é invalido.");
				return ResponseEntity.badRequest().body(response);
			}
			
			inventoryReq.setActive(true);
			inventoryReq.setRelaseDate(new Date());
			inventoryReq.setProduct(productFinded.get());
			Inventory inventorySave =  inventoryService.save(inventoryReq);
			response.setData(inventorySave);
			return ResponseEntity.ok(response);			
		}catch (Exception e) {
			response.getErrors().add("Inventory can't be created." + e.getMessage());
			log.error("Error Inventory can't be created." + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	private void validateCreate(Inventory inventoryReq, BindingResult result) {
		if(inventoryReq == null ) {
			result.addError(new ObjectError("Inventory", "inventório invalido."));
		}
		if(inventoryReq.getProduct() == null || inventoryReq.getProduct().getId() <= 0) {
			result.addError(new ObjectError("Inventory", "Produto inválido."));
		}
		if(inventoryReq.getQuantity() == null || inventoryReq.getQuantity() <= 0) {
			result.addError(new ObjectError("Inventory", "Quantidade inválida."));
		}
		if(inventoryReq.getCostPrice() == null || inventoryReq.getCostPrice() == BigDecimal.ZERO) {
			result.addError(new ObjectError("Inventory", "Preço de custo inválido."));
		}
	}
	
	@DeleteMapping(value = "{idInventory}")
	public ResponseEntity<Response<Inventory>> deleteInventory(@PathVariable Integer idInventory){
		Response<Inventory> response = new Response<>();
		try {
			if (idInventory == null || idInventory == 0) {
				response.getErrors().add("Parameter is invalid.");
				return ResponseEntity.badRequest().body(response);
			}
			
			Optional<Inventory> inventoryFinded = inventoryService.findById(idInventory);
			
			if (!inventoryFinded.isPresent()) {
				response.getErrors().add("inventory is not be finded, too not be deleted.");
				return ResponseEntity.badRequest().body(response);
			}
			
			 inventoryService.delete(inventoryFinded.get());;
			
			return ResponseEntity.ok(response);			
		}catch (Exception e) {
			response.getErrors().add("Inventory can't be deleted." + e.getMessage());
			log.error("Error Inventory can't be deleted." + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
}
