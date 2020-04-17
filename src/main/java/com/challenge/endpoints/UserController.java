package com.challenge.endpoints;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id) {
		return this.userService.findById(id).get();
	}
	
	@GetMapping
	public List<User> findByAccelerationNameAndCompanyId(@RequestParam(value = "accelerationName", required = false) String name,
			@RequestParam(value = "companyId", required = false) Long id){
		
		if (name != null && name.length() != 0){
            return userService.findByAccelerationName(name);
        }
        else if (id != null){
            return userService.findByCompanyId(id);
        }
        return Collections.emptyList();
	}
	
}
