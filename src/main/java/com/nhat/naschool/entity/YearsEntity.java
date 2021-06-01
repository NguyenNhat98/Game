package com.nhat.naschool.entity;

//import java.util.Date;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;




@Entity
@Table(name = "years")
public class YearsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@DateTimeFormat(pattern = "YYYY-mm-dd")
//	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date year_s;
	
    private Date year_e;
     
    @OneToMany(mappedBy = "y")
    private List<ClassEntity> c;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getYear_s() {
		return year_s;
	}

	public void setYear_s(Date year_s) {
		this.year_s = year_s;
	}

	public Date getYear_e() {
		return year_e;
	}

	public void setYear_e(Date year_e) {
		this.year_e = year_e;
	}


	public List<ClassEntity> getC() {
		return c;
	}

	public void setC(List<ClassEntity> c) {
		this.c = c;
	}

	public YearsEntity( Date year_s, Date year_e, List<ClassEntity> c) {
		
		this.year_s = year_s;
		this.year_e = year_e;
		this.c = c;
	}
	
	public YearsEntity(int id, Date year_s, Date year_e) {
		
		this.year_s = year_s;
		this.year_e = year_e;
		
	}
	
	public YearsEntity(int id, Date year_s, Date year_e, List<ClassEntity> c) {
		super();
		this.id = id;
		this.year_s = year_s;
		this.year_e = year_e;
		this.c = c;
	}

	public YearsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
