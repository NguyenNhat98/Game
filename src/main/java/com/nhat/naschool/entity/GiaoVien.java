package com.nhat.naschool.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class GiaoVien {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String birth;
	private int sdt;
	private String email;
	private String address;
	private String gender;
	private String detail;

	@OneToMany(mappedBy = "giaoVien")
	private List<Gv_sv> gv_sv = new ArrayList<>();

//	@OneToMany(mappedBy = "teacher")
//    private List<StudentEntity> student;
//	
	@OneToMany(mappedBy = "gv")
	private List<StudentEntity> student;

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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public GiaoVien(int id, String name, String birth, int sdt, String email, String address, String gender,
			String detail) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.sdt = sdt;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.detail = detail;
	}

	public GiaoVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Gv_sv> getGv_sv() {
		return gv_sv;
	}

	public void setGv_sv(List<Gv_sv> gv_sv) {
		this.gv_sv = gv_sv;
	}

	public List<StudentEntity> getStudent() {
		return student;
	}

	public void setStudent(List<StudentEntity> student) {
		this.student = student;
	}

}
