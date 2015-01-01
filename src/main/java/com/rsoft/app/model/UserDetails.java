package com.rsoft.app.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUser;

import com.rsoft.app.domain.SocialMediaService;
import com.rsoft.app.domain.SocialRole;
 

public class UserDetails extends SocialUser {

	public UserDetails(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	private Long id;

	private String firstName;

	private String lastName;

	private SocialRole role;

	private SocialMediaService socialSignInProvider;

	private String email; 
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Builder getBuilder(){
		return new Builder();
	}
	// Getters are omitted for the sake of clarity.

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public SocialRole getRole() {
		return role;
	}

	public void setRole(SocialRole role) {
		this.role = role;
	}

	public SocialMediaService getSocialSignInProvider() {
		return socialSignInProvider;
	}

	public void setSocialSignInProvider(SocialMediaService socialSignInProvider) {
		this.socialSignInProvider = socialSignInProvider;
	}

	public static class Builder {

		private Long id;

		private String username;

		private String firstName;

		private String lastName;

		private String password;

		private SocialRole role;

		private SocialMediaService socialSignInProvider;

		private Set<GrantedAuthority> authorities;

		private String email; 
		
		 

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder() {
			this.authorities = new HashSet<GrantedAuthority>();
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder password(String password) {
			if (password == null) {
				password = "SocialUser";
			}

			this.password = password;
			return this;
		}

		public Builder role(SocialRole role) {
			this.role = role;

			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
					role.toString());
			this.authorities.add(authority);

			return this;
		}

		public Builder socialSignInProvider(
				SocialMediaService socialSignInProvider) {
			this.socialSignInProvider = socialSignInProvider;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public UserDetails build() {
			UserDetails user = new UserDetails(username, password, authorities);

			user.id = id;
			user.firstName = firstName;
			user.lastName = lastName;
			user.role = role;
			user.socialSignInProvider = socialSignInProvider;

			return user;
		}
	}

}
