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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nhat.naschool.entity.GiaoVien;
import com.nhat.naschool.repository.GiaoVienRepository;
import com.nhat.naschool.service.GiaoVienService;


//@CrossOrigin("*")

@Controller
public class GiaoVienController {
//	@Autowired
//	private StudentService svService;
	@Autowired
	private GiaoVienService gvService;

	@Autowired
	GiaoVienRepository gvRepo;

	@RequestMapping("/list-gv")
	public String listGV(HttpServletRequest request, Model model) {

		int page = 0;
		int size = 5;

		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
		}

		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
			size = Integer.parseInt(request.getParameter("size"));
		}

		model.addAttribute("listgv", gvRepo.findAll(PageRequest.of(page, size)));

//        List<GiaoVien> listGv = gvService.listAllGiaoVien();
//        model.addAttribute("listgv", listGv);
		return "listgv";
	}

	@RequestMapping("/add-gv")
	public String AddGV(Model model) {
		try {
			GiaoVien gv = new GiaoVien();

			model.addAttribute("addGV", gv);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "addGiaoVien";
	}

	@PostMapping("/save-gv")
	public String saveGV(@ModelAttribute GiaoVien giaoVien) {
		try {
			gvService.saveGiaoVien(giaoVien);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "redirect:/list-gv";
	}

//    @RequestParam(value = "name",defaultValue = "") String name
	@RequestMapping("/delete-gv/{id}")
	public String deleteGV(@PathVariable int id, RedirectAttributes redirectAttributes) {
		try {
			if (gvService.findName(id) == null) {
				gvService.deleteGV(id);

				return "redirect:/list-gv";
			} else {
//    	GiaoVien gv = gvService.findById(id);

				return "redirect:/list-gv";
			}
		} catch (Exception e) {
			e.printStackTrace();

			return "redirect:/list-gv";
		}
//      

	}

	@RequestMapping("/edit-gv/{id}")
	public String editGV(@PathVariable int id, Model model) {
		try {
			GiaoVien giaoVien = gvService.getGiaoVien(id);
			model.addAttribute("giaovien", giaoVien);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "editgv";
	}

	@RequestMapping("/update-gv/{id}")
	public String updateGV(@PathVariable int id, @ModelAttribute GiaoVien giaoVien, Model model) {
		try {
			GiaoVien gv = gvService.getGiaoVien(id);
			gv.setName(giaoVien.getName());
			gv.setBirth(giaoVien.getBirth());
			gv.setSdt(giaoVien.getSdt());
			gv.setEmail(giaoVien.getEmail());
			gv.setAddress(giaoVien.getAddress());
			gv.setGender(giaoVien.getGender());
			gv.setDetail(giaoVien.getDetail());
			gvService.saveGiaoVien(gv);
			model.addAttribute("giaovien", gv);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
//       
		return "redirect:/list-gv";
	}

//    @RequestMapping("/search1")
//    public String findGV(@PathVariable String diaChi, @PathVariable String email){
//        gvService.findByDiaChiAndEmail(diaChi, email);
//        return "listgv";
//    }

	@RequestMapping("/search-gv")
	public String findbyMGV(@RequestParam("name") String name, Model model) {
		try {
			model.addAttribute("listgv", gvService.findByName(name));
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "searchGv";
	}
}
