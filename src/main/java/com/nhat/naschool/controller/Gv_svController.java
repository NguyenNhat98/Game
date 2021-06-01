package com.nhat.naschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nhat.naschool.entity.Gv_sv;
import com.nhat.naschool.service.Gv_svService;


@Controller
public class Gv_svController {
	 @Autowired
	    Gv_svService gv1Service;

	    @RequestMapping("/gv_sv")
	    public String getlistSV(Model model){
	        List<Gv_sv> list= gv1Service.getAllSV();
	        model.addAttribute("gv_sv", list);

	        return "gv_sv";
	    }
	    
	    
	    @RequestMapping("/sv-gv/{id_gv}")
	    public String editGV(@PathVariable int id_gv, Model model) {
	    	List<Gv_sv> list= gv1Service.findByidGv(id_gv);
	        model.addAttribute("gv_sv", list);

	        return "gv_sv";
	    }

}
