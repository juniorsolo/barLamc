package lamc.bar.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 24/11/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(nullable = false)
	@JsonProperty("id")
	private Integer id;
	
	@Column(nullable = false)
	@JsonProperty("name")
	private  String name;
	
	@JsonProperty("active")
	private Boolean active = Boolean.TRUE;
	
	@JsonIgnore
	@OneToMany(
	        mappedBy = "product",
	        orphanRemoval = true,
	        fetch = FetchType.LAZY
	    )
	private List<Inventory> inventoryList;
}
