package com.nhat.naschool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhat.naschool.entity.ClassEntity;
import com.nhat.naschool.entity.GiaoVien;
import com.nhat.naschool.entity.StudentEntity;
import com.nhat.naschool.entity.SubjectsEntity;
import com.nhat.naschool.repository.StudentRepository;
import com.nhat.naschool.service.ClassService;
import com.nhat.naschool.service.GiaoVienService;
import com.nhat.naschool.service.StudentService;
import com.nhat.naschool.service.SubjectsService;

@Controller
public class StudentController {

	@Autowired
	private StudentService svService;

	@Autowired
	private ClassService ClassService;

	@Autowired
	private GiaoVienService gvService;

	@Autowired
	private SubjectsService subService;

	@Autowired
	StudentRepository studentRepo;

	@RequestMapping("/list-sv")
	public String listStudent(HttpServletRequest request, Model model) {

		int page = 0;
		int size = 5;

		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
		}

		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
			size = Integer.parseInt(request.getParameter("size"));
		}

		model.addAttribute("listsv", studentRepo.findAll(PageRequest.of(page, size)));

//          List<StudentEntity> listsv = studentRepo.findAll();
//	        model.addAttribute("listsv", listsv);
		return "listsv";
	}

	@RequestMapping("/add-sv")
	public String AddSV(Model model) {
		try {
			StudentEntity sv = new StudentEntity();
			List<ClassEntity> listClas = ClassService.listAllClass();
			List<GiaoVien> gv = gvService.listAllGiaoVien();

			List<SubjectsEntity> sub = subService.findAll();
			model.addAttribute("sub1", sub);
			model.addAttribute("gv", gv);
			model.addAttribute("listclas", listClas);
			model.addAttribute("addSV", sv);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "addSinhVien";
	}

	@PostMapping("/save-sv")
	public String saveSV(@ModelAttribute StudentEntity sinhVien, @ModelAttribute GiaoVien gVien) {
		try {
			svService.saveStudent(sinhVien);

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "redirect:/list-sv";
	}

	@RequestMapping("/delete-sv/{id}")
	public String deleteSV(@PathVariable int id) {

		try {
			svService.deleteStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "redirect:/list-sv";
	}

	@RequestMapping("/edit-sv/{id}")
	public String editSV(@PathVariable int id, Model model) {
		try {
			StudentEntity sinhVien = svService.getStudent(id);
			List<ClassEntity> c = ClassService.listAllClass();
			List<GiaoVien> gv = gvService.listAllGiaoVien();
			List<SubjectsEntity> s = subService.findAll();
			model.addAttribute("sinhvien", sinhVien);
			model.addAttribute("gv", gv);
			model.addAttribute("c", c);
			model.addAttribute("sub1", s);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "editsv";
	}

	@RequestMapping("/update-sv/{id}")
	public String updateGV(@PathVariable int id, @ModelAttribute StudentEntity sinhVien, Model model) {

		try {
			StudentEntity sv = svService.getStudent(id);

			sv.setName(sinhVien.getName());
			sv.setBirth(sinhVien.getBirth());
			sv.setSdt(sinhVien.getSdt());
			sv.setEmail(sinhVien.getEmail());
			sv.setAddress(sinhVien.getAddress());
			sv.setGender(sinhVien.getGender());
			sv.setScore(sinhVien.getScore());
			sv.setDetail(sinhVien.getDetail());

			svService.saveStudent(sinhVien);
			;

			model.addAttribute("sinhvien", sv);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "redirect:/list-sv";
	}

	@RequestMapping("/search-sv")
	public String findbySV(@RequestParam("name") String name, Model model) {
		try {
			model.addAttribute("listsv", svService.findByName(name));
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "searchSv";
	}
}
