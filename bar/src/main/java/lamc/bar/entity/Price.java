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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 08/12/2021
 * 
 * @author junior.solo - Coveiro
 *
 */
@Entity
@Table(name = "price")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Price implements Serializable{

	private static final long serialVersionUID = 4790543868929035279L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	private Integer id;
	
	@JsonProperty("priceUnity")
	@Column(nullable = false)
	private BigDecimal priceUnity;
	
	@JsonProperty("promotionQuantity")
	private Integer  promotionQuantity;
	
	@JsonProperty("promotionPrice")
	private BigDecimal promotionPrice;	
	
	@JsonProperty("dateCreate")
	private Date dateCreate;
	
	@JsonProperty("dateEnd")
	private Date dateEnd;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	private Product product;
	
	public String toString() {
		String productId = this.product == null || this.product.getId() == null ? "" : this.product.getId().toString();
		return "id:" + this.id +"\n" +
	    "priceUnity:" + this.priceUnity + "\n" +
        "promotionQuantity:" + this.promotionQuantity + "\n" + 
        "dateCreate:" + this.dateCreate + "\n" +
	    "dateEnd:" + this.dateEnd +
	    "ProductId:" + productId;

	}

}
