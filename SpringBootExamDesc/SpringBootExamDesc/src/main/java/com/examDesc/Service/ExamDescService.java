package com.examDesc.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.examDesc.Model.ExamDesc;
import com.examDesc.Repo.ExamDescRepository;
import com.examDesc.Vo.ResponseTemplateVo;
import com.examDesc.Vo.Trainee;

@Service
@Transactional
public class ExamDescService {
	@Autowired
	ExamDescRepository repo;
	@Autowired
	private RestTemplate restTemplate;

	public ExamDesc addExamDesc(ExamDesc examDesc) {
		return repo.save(examDesc);
	}
	public ResponseTemplateVo getExamDetails(String subId) {
		ResponseTemplateVo vo=new ResponseTemplateVo();
		ExamDesc examDesc=repo.getBySubId(subId);
		Trainee trainee=restTemplate.getForObject("http://TRAINEE-MICROSERVICE/trainee/getTrainee/" + 
		examDesc.getTraineeId(),Trainee.class);
		vo.setExamdesc(examDesc);
		vo.setTrainee(trainee);
		return vo;
	}

}
