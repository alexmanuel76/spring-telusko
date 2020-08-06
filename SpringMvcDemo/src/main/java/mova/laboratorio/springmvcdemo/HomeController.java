package mova.laboratorio.springmvcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mova.laboratorio.springmvcdemo.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	private AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Alien");
	}
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("numero1") int numero1,@RequestParam("numero2") int numero2, Model modelo)
    {
		int resultado = numero1 + numero2;
		
		modelo.addAttribute("resultado", resultado);
		
		return "result";
	}
	
	//@RequestMapping("/addAlien")
	@PostMapping("/addAlien")
	public String addAlien(@ModelAttribute Alien alien, Model modelo) {
		
		modelo.addAttribute("alien", alien);
		return "result";
	}
	
	@GetMapping("/getAliens")
	public String getAliens(Model modelo) {
		
		modelo.addAttribute("resultado", repo.findAll());
		return "showAliens";
	}
	
	@GetMapping("/findAlienByName")
	public String getAliensByName(@RequestParam String aname, Model modelo) {
		
		modelo.addAttribute("resultado", repo.findByAname(aname));
		return "showAliens";
	}
	
	@GetMapping("/findAlienByNameQ")
	public String getAliensByNameQ(@RequestParam String aname, Model modelo) {
		
		modelo.addAttribute("resultado", repo.find(aname));
		return "showAliens";
	}

}
