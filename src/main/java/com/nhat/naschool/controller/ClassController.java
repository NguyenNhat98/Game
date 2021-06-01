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
import com.nhat.naschool.entity.YearsEntity;
import com.nhat.naschool.repository.ClassRepo;
import com.nhat.naschool.service.ClassService;
import com.nhat.naschool.service.YearsService;

@Controller
public class ClassController {

	@Autowired
	private ClassService ClassService;

	@Autowired
	private YearsService yService;

	@Autowired
	ClassRepo classRepo;

	@RequestMapping("/list-class")
	public String listClass(HttpServletRequest request, Model model) {

		int page = 0;
		int size = 5;
		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
		}

		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
			size = Integer.parseInt(request.getParameter("size"));
		}

		model.addAttribute("listclass", classRepo.findAll(PageRequest.of(page, size)));

//	        List<ClassEntity> listClass = ClassService.listAllClass();
//	        model.addAttribute("listclass", listClass);
		return "listclass";
	}

	@RequestMapping("/add-class")
	public String AddClass(Model model) {
		try {
			ClassEntity c = new ClassEntity();
			List<YearsEntity> y = yService.findAll();
			model.addAttribute("addClass", c);
			model.addAttribute("y", y);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "addClass";
	}

	@PostMapping("/save-class")
	public String saveGV(@ModelAttribute ClassEntity classEntity) {
		try {
			ClassService.saveClass(classEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "redirect:/list-class";
	}

	@RequestMapping("/delete-class/{id}")
	public String deleteClass(@PathVariable int id) {

		try {
			if (ClassService.findName(id) == null) {
				ClassService.deleteClass(id);
				return "redirect:/list-class";
			} else {

				return "redirect:/list-class";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/list-class";

		}

	}

	@RequestMapping("/edit-class/{id}")
	public String editClass(@PathVariable int id, Model model) {
		try {
			ClassEntity classE = ClassService.getClass(id);
			List<YearsEntity> y = yService.findAll();
			model.addAttribute("y", y);
			model.addAttribute("class", classE);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "editclass";
	}

	@RequestMapping("/update-class/{id}")
	public String updateGV(@PathVariable int id, @ModelAttribute ClassEntity classEntity, Model model) {
		try {
			ClassEntity classE = ClassService.getClass(id);
			classE.setName(classEntity.getName());

			classE.setDetail(classEntity.getDetail());
			ClassService.saveClass(classE);
			model.addAttribute("class", classE);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "redirect:/list-class";
	}

	@RequestMapping("/search-class")
	public String findbyClass(@RequestParam("name") String name, Model model) {
		try {
			model.addAttribute("listclass", ClassService.findByName(name));
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "searchClass";
	}
}
