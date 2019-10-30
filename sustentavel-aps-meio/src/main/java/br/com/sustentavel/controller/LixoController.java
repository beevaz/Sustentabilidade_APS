package br.com.sustentavel.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import br.com.sustentavel.entity.LixoModel;
import br.com.sustentavel.repository.LixoRepository;

@CrossOrigin
@RestController
public class LixoController {
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        	.allowedMethods("*")
            .allowedOrigins("http://localhost:4200");
	}

	
    @Autowired
    private LixoRepository _lixoRepository;

    @CrossOrigin
    @RequestMapping(value = "/lixo", method = RequestMethod.GET)
    public List<LixoModel> Get() {
        return _lixoRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/lixo/{id_lixo}", method = RequestMethod.GET)
    public ResponseEntity<LixoModel> GetById(@PathVariable(value = "id_lixo") long id_lixo)
    {
        Optional<LixoModel> lixo = _lixoRepository.findById(id_lixo);
        if(lixo.isPresent())
            return new ResponseEntity<LixoModel>(lixo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/lixo", method =  RequestMethod.POST)
    public LixoModel Post(@Valid @RequestBody LixoModel lixo)
    {
        return _lixoRepository.save(lixo);
    }

    @CrossOrigin
    @RequestMapping(value = "/lixo/{id_lixo}", method =  RequestMethod.PUT)
    public ResponseEntity<LixoModel> Put(@PathVariable(value = "id_lixo") long id_lixo, @Valid @RequestBody LixoModel newLixo)
    {
        Optional<LixoModel> oldLixo = _lixoRepository.findById(id_lixo);
        if(oldLixo.isPresent()){
        	LixoModel lixo = oldLixo.get();
            lixo.setRegiao(newLixo.getRegiao());
            lixo.setEndereco(newLixo.getEndereco());
            _lixoRepository.save(lixo);
            return new ResponseEntity<LixoModel>(lixo, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/lixo/{id_lixo}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id_lixo") long id_lixo)
    {
        Optional<LixoModel> lixo = _lixoRepository.findById(id_lixo);
        if(lixo.isPresent()){
        	_lixoRepository.delete(lixo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}