package mova.laboratorio.springmvcdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mova.laboratorio.springmvcdemo.model.Alien;

@RestController()
public class AlienController {
	
	@Autowired
	private AlienRepo repositorio;
	
	//@GetMapping("/aliens")
	@GetMapping(path = "/aliens", produces = {"application/xml"})
	public List<Alien> getAliens() {
		
		System.out.println("Ejecutando....");
		int i = 9/0;
		return repositorio.findAll();
	}
	
	@GetMapping("/alien/{id}")
	public Alien getAlien(@PathVariable("id") int aid) {
		/*Optional<Alien> resultado = repositorio.findById(aid);
		if (resultado.isPresent()) {
			return (Alien)resultado.get();
		}
		return null;
		*/
		
		return repositorio.findById(aid).orElse(new Alien(0,"not found"));
	}
	
	//@PostMapping("/alien")
	@PostMapping(path = "/alien", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Alien addAlien(@RequestBody Alien alien) {
		
		repositorio.save(alien);
		return alien;
	}

}
