package com.challenge.endpoints;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController {

	private CompanyService company;
	
	@GetMapping("/{id}")
	public Company findById(@PathVariable("id") Long id) {
		return this.company.findById(id).get();
	}
	
	@GetMapping
	public List<Company> findByAccelerationIdAndUserId(@RequestParam(value = "accelerationId", required = false) Long accelerationId, 
			@RequestParam(value = "userId", required = false) Long userId){
		if(accelerationId != null) {
			return company.findByAccelerationId(accelerationId);
		} else if(userId != null) {
			return company.findByUserId(userId);
		}
		
		return Collections.emptyList();
	}
	
	@GetMapping("/user/{id}")
	public List<Company> findByUserId(@PathVariable("id") Long id){
		return this.company.findByUserId(id);
	}
}
