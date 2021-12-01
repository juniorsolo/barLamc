package lamc.bar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lamc.bar.enums.ProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 30/11/2021
 * 
 * @author junior solo - Coveiro
 *
 */
@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "id")
	private Integer id;
	
	@Column(name= "userName", unique = true)
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private ProfileEnum profile;
 
}
