package com.Trainee.MS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Trainee.MS.Model.Trainee;
import com.Trainee.MS.Service.TraineeService;

@RestController
@RequestMapping("/trainee")
public class TraineeRestController {
	@Autowired
	TraineeService traineeService;
	@PostMapping("/inserttraineedetails")
	public ResponseEntity<Trainee> addTraineeDetails(@Validated @RequestBody Trainee trainee) {
		  //System.out.println(book);
			Trainee traineeResponse =traineeService.addTrainee(trainee);
			  return new ResponseEntity<Trainee>(traineeResponse,HttpStatus.OK);
		  }
	 
    @GetMapping("/getTrainees")
    public ResponseEntity<List<Trainee>>getTrainee(String technology,String location){
    	List<Trainee> traineeObj=traineeService.getTrainees(technology, location);
    	return new ResponseEntity<List<Trainee>>(traineeObj,HttpStatus.OK);
    }
    @PostMapping("/registertraineedetails")
	public ResponseEntity<Boolean> registerTraineeDetails( @RequestBody Trainee trainee) {
		  //System.out.println(book);
			Boolean bool=traineeService.registerTrainee(trainee);
			  return new ResponseEntity<Boolean>(bool,HttpStatus.OK);
		  }
}
