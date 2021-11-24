package lamc.bar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name="member")
@Data
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(nullable = false)
	@JsonProperty("id")
	private Integer id;
	
	@Column(nullable = false)
	@JsonProperty("name")
	private String name;
	
	public Member() {}
}
