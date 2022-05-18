package com.examDesc.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Trainee {
	private String userId;
	private String traineeName;
	private String technology;
	private String trainerId;
	private String location;
	private String contact;
	private String domain;
	private int passoutyear;
	private String education;

}
