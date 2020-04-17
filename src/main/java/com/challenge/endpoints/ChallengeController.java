package com.challenge.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/challenge")
public class ChallengeController {

	private ChallengeService challenge;
	
	@GetMapping
	public List<Challenge> findAll(@RequestParam(value = "accelerationId", required = false) Long accelerationId,
			@RequestParam(value = "userId", required = false) Long userId){
		return this.challenge.findByAccelerationIdAndUserId(accelerationId, userId);
	}
	
	@GetMapping("/acceleration/{accelerationId}/user/{userId}")
	public List<Challenge> findById(@PathVariable Long accelerationId, @PathVariable Long userId) {
		return this.challenge.findByAccelerationIdAndUserId(accelerationId, userId);
	}
}
