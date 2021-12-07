package lamc.bar.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lamc.bar.entity.Inventory;
import lamc.bar.repository.InventoryRepository;
import lamc.bar.service.InventoryService;

/**
 * 02/12/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService{
	
	Logger log = LoggerFactory.getLogger(InventoryServiceImpl.class);
	
	@Autowired
	private InventoryRepository inventoryRepo;
	
	@Override
	public List<Inventory> findAllActiveByIdProduto(Integer idProduto) {
		try {
			return inventoryRepo.findByActiveAndIdProduto(Boolean.TRUE, idProduto);
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public Optional<Inventory> findById(Integer id) {
		try {
			return inventoryRepo.findById(id);
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public Inventory save(Inventory inventory) {
		try {
			return inventoryRepo.save(inventory);
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	@Override
	public void delete(Inventory inventory) {
		try {
			inventoryRepo.delete(inventory);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
