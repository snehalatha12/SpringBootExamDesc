package com.Trainee.MS.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Trainee.MS.Model.Trainee;
import com.Trainee.MS.Model.Users;
import com.Trainee.MS.Repo.TraineeRepository;
import com.Trainee.MS.Vo.Trainer;

@Service
public class TraineeService {
@Autowired
TraineeRepository traineeRepo;
@Autowired
private RestTemplate restTemplate;
public Trainee addTrainee(Trainee trainee) {
	trainee = generateUserId(trainee);
	trainee = setTrainer(trainee);
	return traineeRepo.save(trainee);
}
public ArrayList<Trainee> getTrainees(String technology,String location){
	return traineeRepo.getByLocAndTech(technology, location);
}
private Trainee setTrainer(Trainee trainee) {
	Trainer trainer = restTemplate.getForObject("http://TRAINER-MICROSERVICE/Trainer/getTrainerObj/"+trainee.getTraineeName(), Trainer.class );
	trainee.setTrainer(trainer);
	return trainee;
}

private Trainee generateUserId(Trainee trainee) {
	Users user = trainee.getUser();
	user.setUserID("TNE-" + trainee.getTechnology().substring(0, 3) + "-" + (traineeRepo.count() + 1));
	trainee.setUser(user);
	return trainee;
}

public Boolean registerTrainee(Trainee trainee) {
	if (traineeRepo.save(trainee).equals(trainee))
		return true;
	else
		return false;
}
}
