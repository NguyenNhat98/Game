package com.nhat.naschool.entity;

import java.util.ArrayList;
import java.util.List;
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
@Table(name = "students")
public class StudentEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy = "sinhVien")
	private List<Gv_sv> gv_sv = new ArrayList<>();

//	 @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name = "id_class")
	public ClassEntity lop;

//   @ManyToOne(optional = false)

	@ManyToOne
	@JoinColumn(name = "id_gv")
	public GiaoVien gv;

//    @ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "id_s")
	private SubjectsEntity sub;

	private String name;
	private String birth;
	private int sdt;
	private String email;
	private String address;
	private String gender;
	private float score;
	private String detail;

	public GiaoVien getGv() {
		return gv;
	}

	public void setGv(GiaoVien gv) {
		this.gv = gv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Gv_sv> getGv_sv() {
		return gv_sv;
	}

	public void setGv_sv(List<Gv_sv> gv_sv) {
		this.gv_sv = gv_sv;
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

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public StudentEntity(int id, String name, String birth, int sdt, String email, String address, String gender,
			float score, String detail) {
		super();
		this.id = id;

		this.name = name;
		this.birth = birth;
		this.sdt = sdt;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.score = score;
		this.detail = detail;
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassEntity getLop() {
		return lop;
	}

	public void setLop(ClassEntity lop) {
		this.lop = lop;
	}

	public SubjectsEntity getSub() {
		return sub;
	}

	public void setSub(SubjectsEntity sub) {
		this.sub = sub;
	}

}
