package com.Trainee.MS.Repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Trainee.MS.Model.Trainee;
@Repository
public interface TraineeRepository extends JpaRepository<Trainee,String>{
@Query(value="SELECT t.TRAINEENAME,t.TECHNOLOGY FROM TRAINEE t WHERE t.TECHNOLOGY=? AND t.LOCATION=? ",nativeQuery=true)
ArrayList<Trainee> getByLocAndTech(String technology,String location);
}
