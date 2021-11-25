package lamc.bar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(nullable = false)
	@JsonProperty("id")
	private Integer id;
	
	@Column(insertable = false)
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("active")
	private Boolean active = Boolean.TRUE;
}
