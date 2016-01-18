package inetbanking.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
@Entity
public class User extends BaseEntity implements UserDetails {

	@Column(unique=true)
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private UserType type;
	
	public User() {
		super();
	}
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
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
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
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		UserType type = this.getType();

		if (type == null) {
			return Collections.emptyList();
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(type.toString()));
		return authorities;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
