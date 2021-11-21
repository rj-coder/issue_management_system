package com.issuemgmtsystem.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.ToString;

@ToString
public class UserPrincipal implements UserDetails{

	private static final long serialVersionUID = 4568781417041608374L;
	 
	private User user;
	
	public UserPrincipal(User user) {
		super();
		this.user = user;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getRoles();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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


	public User getUser() {
		return user;
	}

	
	
}
