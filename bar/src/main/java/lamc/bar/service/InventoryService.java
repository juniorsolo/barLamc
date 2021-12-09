package lamc.bar.service;

import java.util.List;
import java.util.Optional;

import lamc.bar.entity.Inventory;
import lamc.bar.entity.Product;

/**
 * 02/12/2021
 * 
 * @author junior.solo
 *
 */
public interface InventoryService {
	
	public List<Inventory> findAllActiveByIdProduto(Integer id);
	public Optional<Inventory> findById(Integer id);
	public Inventory save(Inventory inventory);
	public void delete(Inventory inventory);
	
}
