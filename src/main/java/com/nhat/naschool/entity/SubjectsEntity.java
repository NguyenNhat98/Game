package com.nhat.naschool.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class SubjectsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String note;
	
	@OneToMany(mappedBy = "sub")
	private List<StudentEntity> listStudent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	public SubjectsEntity(int id, String name, String note) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
	}
	public SubjectsEntity( String name, String note) {
		
		this.name = name;
		this.note = note;
	}
	public SubjectsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<StudentEntity> getListStudent() {
		return listStudent;
	}
	public void setListStudent(List<StudentEntity> listStudent) {
		this.listStudent = listStudent;
	}
	
	
	

}
