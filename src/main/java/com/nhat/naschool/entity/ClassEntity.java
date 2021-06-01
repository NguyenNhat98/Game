package com.nhat.naschool.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class ClassEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;

	private String detail;

//	@OneToMany(mappedBy = "lop", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@OneToMany(mappedBy = "lop")
	public List<StudentEntity> student = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_y")
	private YearsEntity y;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public YearsEntity getY() {
		return y;
	}

	public void setY(YearsEntity y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassEntity(int id, String name, String detail, List<StudentEntity> student, YearsEntity y) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.student = student;
		this.y = y;
	}

	public ClassEntity(int id, String name, String detail, List<StudentEntity> student) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.student = student;

	}

	public ClassEntity(int id, String name, String detail, YearsEntity y) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.y = y;
	}

	public ClassEntity(String name, String detail) {
		super();

		this.name = name;
		this.detail = detail;

	}

	public ClassEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<StudentEntity> getStudent() {
		return student;
	}

	public void setStudent(List<StudentEntity> student) {
		this.student = student;
	}

}
