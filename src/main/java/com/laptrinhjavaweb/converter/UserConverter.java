package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConverter {

	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		if (dto.getPassword() != null) {
			entity.setUserName(dto.getUserName());
		}
		if (dto.getUserName() != null) {
			entity.setUserName(dto.getUserName());
		}
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setDOB(dto.getDOB());
		entity.setGender(dto.getGender());
		if (dto.getPassword() != null) {
			entity.setPassword(dto.getPassword());
		}
		entity.setCreateDate(dto.getCreateDate());
		if (dto.isActive() != false || entity.getActive() == true) {
			entity.setActive(dto.isActive());
		}
		entity.setImageProfile(dto.getImageProfile());
		return entity;
	}

	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		if (entity.getUserID() != null) {
			dto.setUserID(entity.getUserID());
		}
		dto.setUserName(entity.getUserName());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		dto.setDOB(entity.getDOB());
		dto.setUserID(entity.getUserID());
		dto.setGender(entity.isGender());
		dto.setPassword(entity.getPassword());
		dto.setCreateDate(entity.getCreateDate());
		dto.setActive(entity.getActive());
		dto.setImageProfile(dto.getImageProfile());
		if(entity.getRole().getRoleName().isEmpty() == false) {
		dto.setRoleName(entity.getRole().getRoleName());
		}
		return dto;
	}

	public UserEntity toEntity(UserDTO dto, UserEntity entity) {
		if (dto.getUserName() != null) {
			entity.setUserName(dto.getUserName());
		}
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setDOB(dto.getDOB());
		entity.setGender(dto.getGender());
		if (dto.getPassword() != null) {
			entity.setPassword(dto.getPassword());
		}
		entity.setCreateDate(dto.getCreateDate());
		if ((dto.isActive() == true && entity.getActive() == false)) {
			entity.setActive(true);
		}
		entity.setImageProfile(dto.getImageProfile());
		return entity;
	}
}
