package lamc.bar.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lamc.bar.entity.Inventory;
import lamc.bar.response.Response;
import lamc.bar.service.InventoryService;

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

	@GetMapping(value = "{idProduto}")
	public ResponseEntity<Response<List<Inventory>>> inventoryByProduto(@PathVariable Integer idProduto) {

		Response<List<Inventory>> response = new Response<>();

		try {
			if (idProduto == null || idProduto == 0) {
				response.getErrors().add("Id of product invalid for inventory.");
				return ResponseEntity.badRequest().body(response);
			}

			List<Inventory> listInventory = inventoryService.findAllActiveByIdProduto(idProduto);

//			if (listInventory == null || listInventory.isEmpty()) {
//				response.getErrors().add("Inventory not found.");
//				return ResponseEntity.badRequest().body(response);
//			}

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
			//this.validateCreate(productReq, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			inventoryReq.setDataLancamento(new Date());
			Inventory inventorySave =  inventoryService.save(inventoryReq);
			response.setData(inventorySave);
			return ResponseEntity.ok(response);			
		}catch (Exception e) {
			response.getErrors().add("Inventory can't be created." + e.getMessage());
			log.error("Error Inventory can't be created." + e.getMessage());
			return ResponseEntity.badRequest().body(response);
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
