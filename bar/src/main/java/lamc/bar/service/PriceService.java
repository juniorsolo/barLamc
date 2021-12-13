package lamc.bar.service;

import java.util.Optional;

import lamc.bar.entity.Inventory;
import lamc.bar.entity.Price;

/**
 * 09/12/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
public interface PriceService {
	public Optional<Price> findById(Integer id );
	public Inventory save(Price price);
	//public void delete(Price price);
}
