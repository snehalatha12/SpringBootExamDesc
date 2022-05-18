package com.examDesc.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examDesc.Model.ExamDesc;

@Repository
public interface ExamDescRepository extends JpaRepository<ExamDesc,String>{
@Query(value="SELECT e.SCORE FROM EXAMDESC e WHERE SUBID=?",nativeQuery=true)
 ExamDesc getBySubId(String subId);
}
