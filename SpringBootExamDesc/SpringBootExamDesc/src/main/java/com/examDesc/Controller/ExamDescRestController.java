package com.examDesc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examDesc.Model.ExamDesc;
import com.examDesc.Service.ExamDescService;
import com.examDesc.Vo.ResponseTemplateVo;

@RestController
@RequestMapping("/ExamDesc")
public class ExamDescRestController {
@Autowired 
ExamDescService examDescService;
@PostMapping("/addExamDesc")
public ResponseEntity<ExamDesc> addExamDesc(@RequestBody ExamDesc examDesc){
	ExamDesc examDescObj=examDescService.addExamDesc(examDesc);
	return new ResponseEntity<ExamDesc>(examDescObj,HttpStatus.OK);
}
@GetMapping("/getExamDetails")
public ResponseEntity<ResponseTemplateVo> getExamDetails(String subId){
	ResponseTemplateVo vo=examDescService.getExamDetails(subId);
	return new ResponseEntity<>(vo,HttpStatus.OK);
}
}
