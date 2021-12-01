package lamc.bar.security;
import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -5758576829929227077L;
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}