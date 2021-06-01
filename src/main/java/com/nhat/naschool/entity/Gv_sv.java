package com.nhat.naschool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "gv_sv")
public class Gv_sv {

	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)

	    @Column(name="id", insertable=false, updatable=false)
	    private int id;

	    @ManyToOne(optional = false)
	    @JoinColumn(name = "id_gv")
	    
	    private GiaoVien giaoVien;
	   
	    	
	    @ManyToOne(optional = false)
	    @JoinColumn(name = "id_sv")
	   
	    private StudentEntity sinhVien;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public GiaoVien getGiaoVien() {
			return giaoVien;
		}

		public void setGiaoVien(GiaoVien giaoVien) {
			this.giaoVien = giaoVien;
		}

		public StudentEntity getSinhVien() {
			return sinhVien;
		}

		public void setSinhVien(StudentEntity sinhVien) {
			this.sinhVien = sinhVien;
		}

		public Gv_sv(int id, GiaoVien giaoVien, StudentEntity sinhVien) {
			super();
			this.id = id;
			this.giaoVien = giaoVien;
			this.sinhVien = sinhVien;
		}

		public Gv_sv() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
