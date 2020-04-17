package com.challenge.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/submission")
public class SubmissionController {
	
	private SubmissionService submission;
	
	@GetMapping
    public List<Submission> findAll(@RequestParam(value = "challengeId",required = false) Long challengeId,
    		@RequestParam(value = "accelerationId",required = false) Long accelerationId){
        return submission.findByChallengeIdAndAccelerationId(challengeId,accelerationId);
    }
}
