package com.zee.zee5app.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zee.zee5app.dto.User;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {

	private Long id;

	  private String username;

	  private String email;

	  @JsonIgnore
	  private String password;

	  private Collection<? extends GrantedAuthority> authorities;
	  //Roles
	  private UserDetailsImpl(Long id, String username, String email, String password,
		      Collection<? extends GrantedAuthority> authorities) {
		    this.id = id;
		    this.username = username;
		    this.email = email;
		    this.password = password;
		    this.authorities = authorities;
		  }
	  
	  //we have used builder design pattern
	
	  public static UserDetailsImpl build(User user) {
		  //it should build the userdetailimpl object
		  
		  List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(
				  role.getRoleName().toString())).collect(Collectors.toList());
		  
		  return new UserDetailsImpl(user.getId(), 
				  user.getUsername(),
				  user.getEmail(),
				  user.getPassword(),
				  authorities);
	  }
	  
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	 public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    UserDetailsImpl user = (UserDetailsImpl) o;
	    return Objects.equals(id, user.id);
	  }
	
}
