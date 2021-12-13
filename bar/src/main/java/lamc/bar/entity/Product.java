package lamc.bar.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Product implements Serializable{
	
	private static final long serialVersionUID = -3986506577528940655L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(nullable = false)
	@JsonProperty("id")
	private Integer id;
	
	@Column(nullable = false, length = 30)
	@JsonProperty("name")
	private  String name;
	
	@JsonProperty("active")
	private Boolean active = Boolean.TRUE;
	
	@OneToOne(mappedBy = "product", cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY, optional = true)
	private Price price;
	
	@JsonIgnore
	@OneToMany(
	        mappedBy = "product",
	        orphanRemoval = true,
	        fetch = FetchType.LAZY
	    )
	private List<Inventory> inventoryList;
	
}
