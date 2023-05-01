package com.essam.employeecrudapi.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "name")
	@Pattern(regexp = "[\\u0621-\\u064A ]+", message = "Name should be in Arabic")
	private String name;
	
	@Column(name = "national_id", length = 14, unique = true)
    @Pattern(regexp = "^[0-9]+$", message = "National ID should contain only numbers")
	@Size(min = 14, max = 14, message = "National ID should contain only 14 numbers")
	private String nationalID;
	
	@Column(name = "age")
	private Integer age;
	
	
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;
	

}
