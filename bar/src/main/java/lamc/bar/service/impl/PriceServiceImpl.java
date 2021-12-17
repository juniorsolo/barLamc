package lamc.bar.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lamc.bar.entity.Price;
import lamc.bar.repository.PriceRepository;
import lamc.bar.service.PriceService;

/**
 * 13/12/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
@Service
public class PriceServiceImpl implements PriceService{

	Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);
	
	@Autowired
	PriceRepository priceRepo;
	
	@Override
	public Optional<Price> findById(Integer id) {
		try {
			return priceRepo.findById(id);
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public Price save(Price price) {
		try {
			return priceRepo.save(price);
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public void delete(Price price) {
		try {
			priceRepo.save(price);
		}catch (Exception e) {
			log.error(e.getMessage());
			
		};
		
	}
	
	

}
