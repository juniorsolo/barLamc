package lamc.bar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lamc.bar.entity.Inventory;

/**
 * 02/12/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
	List<Inventory> findByActiveAndProduct_id (Boolean active, Integer id);
}
