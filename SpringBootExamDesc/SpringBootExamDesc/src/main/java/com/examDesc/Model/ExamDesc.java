package com.examDesc.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExamDesc {
	@Id
	private String traineeId;
	@NotBlank
	private String subId;
	@NotBlank
	private Date doe;
	@NotNull
	private int score;

}
