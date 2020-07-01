package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class RoleEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleid;
	
	@Column
	private String rolename;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy = "role")
    private List<UserEntity> users = new ArrayList<>();
    
	
	public Long getRoleID() {
		return roleid;
	}

	public void setRoleID(Long roleID) {
		this.roleid = roleID;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public String getRoleName() {
		return rolename;
	}

	public void setRoleName(String roleName) {
		this.rolename = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
