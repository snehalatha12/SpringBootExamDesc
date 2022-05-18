package com.Trainer.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class Trainer {
	@Id
	private String trainerId;
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "userID")
	private Users user;
	@Column(unique = true)
	@NotEmpty(message = "704")
	@Size(min = 2, message = "MIN 2 char required.")
	private String name;
	@NotEmpty(message = "705")
	@Size(min = 2, message = "MIN 2 char required.")
	private String technology;
	@NotEmpty(message = "706")
	@Size(min = 2, message = "MIN 2 char required.")
	private String location;
	@NotEmpty(message = "707")
	@Size(min = 2, message = "MIN 2 char required.")
	private String contact;
	@Column(unique = true)
	@NotEmpty(message = "708")
	@Email(message = "553")
	private String email;
}
