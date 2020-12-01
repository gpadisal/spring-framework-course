package com.gopal.pma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_accounts")
public class UserAccount {
	
	
//	user_id BIGINT NOT NULL DEFAULT nextval('user_accounts_seq') PRIMARY KEY,
//	username varchar(255) NOT NULL,
//	email varchar(255) NOT NULL,
//	password varchar(255) NOT NULL,
//	role varchar(255),
//	enabled boolean NOT NULL
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_accounts_generator")// change to sequence
	@SequenceGenerator(name = "user_accounts_generator", sequenceName = "user_accounts_seq", allocationSize = 1)
	@Column(name = "user_id")
	private Long usedId;
	
	@Column(name = "username")
	private String userName;
	
	private String email;
	private String password;
	private boolean enabled = true;
	
	public UserAccount() {
	}

	public Long getUsedId() {
		return usedId;
	}

	public void setUsedId(Long usedId) {
		this.usedId = usedId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
