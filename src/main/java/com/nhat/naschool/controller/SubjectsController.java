package com.nhat.naschool.controller;

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
import com.nhat.naschool.entity.SubjectsEntity;
import com.nhat.naschool.repository.SubjectsRepo;
import com.nhat.naschool.service.SubjectsService;

@Controller
public class SubjectsController {

	@Autowired
	private SubjectsService subService;

	@Autowired
	SubjectsRepo subRepo;

	@RequestMapping("/list-subject")
	public String list(HttpServletRequest request, Model model) {

		int page = 0;
		int size = 5;
		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
		}

		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
			size = Integer.parseInt(request.getParameter("size"));
		}

		model.addAttribute("listSubject", subRepo.findAll(PageRequest.of(page, size)));

//	        List<ClassEntity> listClass = ClassService.listAllClass();
//	        model.addAttribute("listclass", listClass);
		return "listSubject";
	}

	@RequestMapping("/add-subject")
	public String Add(Model model) {
		try {
			SubjectsEntity s = new SubjectsEntity();
			model.addAttribute("addSubject", s);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "addSubject";
	}

	@PostMapping("/save-subject")
	public String saveGV(@ModelAttribute SubjectsEntity subEntity) {
		try {
			subService.save(subEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "redirect:/list-subject";
	}

	@RequestMapping("/delete-subject/{id}")
	public String delete(@PathVariable int id) {

		try {
			if (subService.findName(id) == null) {
				subService.delete(id);
				return "redirect:/list-subject";
			} else {

				return "redirect:/list-subject";
			}
		} catch (Exception e) {
			e.printStackTrace();

			return "redirect:/list-subject";
		}

	}

	@RequestMapping("/edit-subject/{id}")
	public String edit(@PathVariable int id, Model model) {
		try {
			SubjectsEntity s = subService.findById(id);
			model.addAttribute("s", s);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "editSubject";
	}

	@RequestMapping("/update-subject/{id}")
	public String update(@PathVariable int id, @ModelAttribute SubjectsEntity subEntity, Model model) {
		try {
			SubjectsEntity s = subService.findById(id);
			s.setName(subEntity.getName());
			s.setNote(subEntity.getNote());
			subService.save(s);
			model.addAttribute("s", s);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "redirect:/list-subject";
	}

	@RequestMapping("/search-subject")
	public String findby(@RequestParam("name") String name, Model model) {
		try {
			model.addAttribute("listSubject", subService.findByName(name));
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "searchSubject";
	}
}
