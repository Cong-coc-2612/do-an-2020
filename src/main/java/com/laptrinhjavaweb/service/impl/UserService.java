package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	@Transactional
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		if (userDTO.getUserID() != null) {
			UserEntity oldUserEntity = userRepository.findOne(userDTO.getUserID());
			userEntity = userConverter.toEntity(userDTO, oldUserEntity);
		} else {
			userEntity = userConverter.toEntity(userDTO);
		}
		RoleEntity roleEntity = roleRepository.findOneByRolename(userDTO.getRoleName());
		if(roleEntity != null)
		userEntity.setRole(roleEntity);
		userEntity = userRepository.save(userEntity);
		return userConverter.toDTO(userEntity);
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long item: ids) {
			userRepository.delete(item);
		}
	}

	@Override
	@Transactional
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item: entities) {
			UserDTO UserDTO = userConverter.toDTO(item);
			results.add(UserDTO);
		}
		return results;
	}

	@Override
	@Transactional
	public int totalItem() {
		return (int) userRepository.count();
	}
}
