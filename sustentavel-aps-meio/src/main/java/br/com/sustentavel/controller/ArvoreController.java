package br.com.sustentavel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import br.com.sustentavel.entity.ArvoreModel;
import br.com.sustentavel.repository.ArvoreRepository;

@CrossOrigin
@RestController
public class ArvoreController {
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        	.allowedMethods("*")
            .allowedOrigins("http://localhost:4200");
	}

	
    @Autowired
    private ArvoreRepository _arvoreRepository;

    @CrossOrigin
    @RequestMapping(value = "/arvore", method = RequestMethod.GET)
    public List<ArvoreModel> Get() {
        return _arvoreRepository.findAll();
    }
}