package lamc.bar.service;

import java.util.Optional;

import lamc.bar.entity.Price;

/**
 * 09/12/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
public interface PriceService {
	public Optional<Price> findById(Integer id );
	public Price save(Price price);
	public void delete(Price price);
}
