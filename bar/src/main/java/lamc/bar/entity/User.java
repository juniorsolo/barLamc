package lamc.bar.entity;

import java.io.Serializable;

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
public class User implements Serializable{
	
	private static final long serialVersionUID = -351342155947862319L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "id")
	private Integer id;
	
	@Column(name= "userName", unique = true, length = 25, nullable = false)
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "profile", length = 25)
	@Enumerated(EnumType.STRING)
	private ProfileEnum profile;
 
}
