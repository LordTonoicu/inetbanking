package inetbanking.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@SuppressWarnings("serial")
public class User extends BaseEntity {

	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private UserType type;
	
	public User(String username, String password, String email, String firstName,
			String lastName, UserType type){
		this(null,false,username,password,email,firstName,lastName,type);
	}
	public User(Long id, String username, String password, String email, String firstName,
			String lastName, UserType type){
		this(id,false,username,password,email,firstName,lastName,type);
	}
	public User(Long id, boolean deleted, String username, String password, String email, String firstName,
			String lastName, UserType type) {
		super(id, deleted);
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	
	
}
