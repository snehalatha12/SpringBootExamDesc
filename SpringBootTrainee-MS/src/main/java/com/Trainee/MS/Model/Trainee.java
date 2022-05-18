package com.Trainee.MS.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public @Data class Trainee {
	@Id
	private String traineeId;
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "userID")
	private Users user;
	@Column(unique = true)
	@NotEmpty(message = "704")
	@Size(min = 2, message = "MIN 2 char required.")
	private String traineeName;
	@NotEmpty(message = "705")
	@Size(min = 2, message = "MIN 2 char required.")
	private String technology;
    @NotBlank
	private String trainerId;
    @NotEmpty(message = "706")
	@Size(min = 2, message = "MIN 2 char required.")
	private String location;
    @NotEmpty(message = "707")
	@Size(min = 2, message = "MIN 2 char required.")
	private String contact;
    @NotBlank
	private String domain;
    @NotNull
	private int passoutyear;
    @NotBlank
	private String education;
	

}
