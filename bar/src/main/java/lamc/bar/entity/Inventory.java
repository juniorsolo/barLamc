package lamc.bar.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "idproduto")
	private Integer idProduto;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "precocusto")
	private BigDecimal precoCusto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datalancamento")
	private Date dataLancamento;
	
	@Column(name = "active")
	private Boolean active;
}
