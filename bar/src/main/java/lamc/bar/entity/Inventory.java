package lamc.bar.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 02/12/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
@Entity
@Table(name = "inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory implements Serializable{
	
	private static final long serialVersionUID = 4025923138833472521L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "id")
	private Integer id;

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "costPrice")
	private BigDecimal costPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "relaseDate")
	private Date relaseDate;
	
	@Column(name = "active")
	private Boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;
}
