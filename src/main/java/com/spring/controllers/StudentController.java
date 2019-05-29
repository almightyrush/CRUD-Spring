package com.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.beans.Student;
import com.spring.dao.StudentDao;

@Controller
public class StudentController {

	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/studentform")
	public String showForm(Model model) {
		model.addAttribute("command",new Student());
		return "studentform";
		}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("student") Student student){    
        studentDao.saveData(student);   
        return "redirect:/viewstudent";//will redirect to viewemp request mapping    
    }
	
	//Display Data
	@RequestMapping("/viewstudent")    
    public String viewStudent(Model model){    
        List<Student> list=studentDao.getStudent();    
        model.addAttribute("list",list);  
        return "viewstudent";    
    } 
	
	//displays data for specific id
	  @RequestMapping(value="/editform/{id}")    
	    public String edit(@PathVariable int id, Model model){    
	        Student student=studentDao.getById(id);    
	        model.addAttribute("command",student);  
	        return "editform";    
	    } 
	
	//Updates the Data
	@RequestMapping(value="/editsave",method = RequestMethod.POST )
	public String editsave(@ModelAttribute("student") Student student){   	 
        studentDao.updataData(student);    
        return "redirect:/viewstudent"; 
}
	
	//Delete Data
	@RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)
	public String deleteStudent(@PathVariable int id) { 
	        studentDao.deleteData(id);    
	        return "redirect:/viewstudent";
		
	}
}
