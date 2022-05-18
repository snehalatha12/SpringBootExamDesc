package com.Trainer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Trainer.Model.Trainer;
@Repository
public interface TrainerRepo extends JpaRepository<Trainer,Integer> {
	Trainer findByName(String name);
	Trainer findByTrainerId(String id);

}
