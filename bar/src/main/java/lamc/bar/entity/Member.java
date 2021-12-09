package lamc.bar.entity;

import java.io.Serializable;

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
 * 23/11/2021
 * 
 * @author Coveiro
 *
 */
@Entity
@Table(name="member")
@Data
@NoArgsConstructor
public class Member implements Serializable{
	
	private static final long serialVersionUID = -660075122938619464L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(nullable = false)
	@JsonProperty("id")
	private Integer id;
	
	@Column(nullable = false)
	@JsonProperty("name")
	private String name;
	
}
