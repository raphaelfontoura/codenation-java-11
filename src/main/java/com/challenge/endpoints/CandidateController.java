package com.challenge.endpoints;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/candidate")
public class CandidateController {
	
	private CandidateService candidate;
	private CandidateMapper candidateMapper;
	
//	@GetMapping
//	public List<Candidate> findAll(){
//		return this.candidate.findAll();
//	}
	
	@GetMapping("/{userId}/{companyId}/{accelerationId}")
	public CandidateDTO findById(@PathVariable Long userId, @PathVariable Long companyId, @PathVariable Long accelerationId) {
		return candidateMapper.map(candidate.findById(userId, companyId, accelerationId).orElse(null));
	}
	
	@GetMapping
    public List<CandidateDTO> findAllByAccelerationIdAndCompanyId(@RequestParam(value = "accelerationId", required = false) Long accelerationId,
    		@RequestParam(value = "companyId", required = false) Long companyId){
        
		if(accelerationId != null){
            return candidateMapper.map(candidate.findByAccelerationId(accelerationId));
        }
        else if(companyId != null){
            return candidateMapper.map(candidate.findByCompanyId(companyId));
        }
        return Collections.emptyList();
    }

}
