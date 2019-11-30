/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Grades")
public class StudentGrades implements Serializable {
	
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "GPA")
	private String gpa;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGpa() {
		return gpa;
	}
	
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return "StudentGrades{" + "id=" + id + ", name=" + name + ", gpa=" + gpa + '}';
	}
}
