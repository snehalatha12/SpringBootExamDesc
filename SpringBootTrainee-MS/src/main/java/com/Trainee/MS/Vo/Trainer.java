package com.Trainee.MS.Vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Trainer {
	private String userId;
	private String trainername;
	private String technology;
	private String location;
	private String contact;
	private String email;
}
