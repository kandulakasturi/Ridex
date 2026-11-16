package com.ridex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ridex.dto.UserResponseDTO;
import com.ridex.entity.Role;
import com.ridex.entity.User;
import com.ridex.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registerUser(User user)
	{
		if(userRepository.findByEmail(user.getEmail()).isPresent())
		{
			throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already registered");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		user.setRole(Role.CUSTOMER);
		
		return userRepository.save(user);
	}
	

	public UserResponseDTO loginUser(String email, String password)
	{
    	User user = userRepository.findByEmail(email)
            	.orElseThrow(() -> new ResponseStatusException(
                    	HttpStatus.UNAUTHORIZED,
                    	"Invalid email or password"
            		));

    	if (!passwordEncoder.matches(password, user.getPassword()))
    	{
        	throw new ResponseStatusException(
                	HttpStatus.UNAUTHORIZED,
                	"Invalid email or password"
        		);
    	}

    	return new UserResponseDTO(
            	user.getUserId(),
            	user.getEmail(),
            	user.getRole().name()
    		);
	}

}
