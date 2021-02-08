package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * @author Mayank Mahesh
 */


///The controller class is used for performing all the action in the application 
@Controller
public class AppController {

	@Autowired
	private UserService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Person> listPersons = service.listAll();
		model.addAttribute("listPersons", listPersons);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePerson(@ModelAttribute("person") Person person) {
		service.save(person);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditPerson(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Person person = service.get(id);
		mav.addObject("person", person);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePerson(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
