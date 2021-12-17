package lamc.bar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lamc.bar.entity.Inventory;
import lamc.bar.entity.Price;
import lamc.bar.response.Response;
import lamc.bar.service.PriceService;

/**
 * 13/12/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
@RestController
@RequestMapping("api/price")
@CrossOrigin(origins = "*")
public class PriceController {
	Logger log = LoggerFactory.getLogger(PriceController.class);
	
	@Autowired
	private PriceService priceService;
	
	@PostMapping
	public ResponseEntity<Response<Price>> createInventory(@RequestBody Inventory inventoryReq, BindingResult result){
		return null;
	}
}
