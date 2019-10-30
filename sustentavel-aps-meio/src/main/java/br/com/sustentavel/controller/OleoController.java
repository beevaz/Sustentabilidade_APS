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

import br.com.sustentavel.entity.OleoModel;
import br.com.sustentavel.repository.OleoRepository;

@CrossOrigin
@RestController
public class OleoController {
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        	.allowedMethods("*")
            .allowedOrigins("http://localhost:4200");
	}

	
    @Autowired
    private OleoRepository _oleoRepository;

    @CrossOrigin
    @RequestMapping(value = "/oleo", method = RequestMethod.GET)
    public List<OleoModel> Get() {
        return _oleoRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/oleo/{id_oleo}", method = RequestMethod.GET)
    public ResponseEntity<OleoModel> GetById(@PathVariable(value = "id_oleo") long id_oleo)
    {
        Optional<OleoModel> oleo = _oleoRepository.findById(id_oleo);
        if(oleo.isPresent())
            return new ResponseEntity<OleoModel>(oleo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/oleo", method =  RequestMethod.POST)
    public OleoModel Post(@Valid @RequestBody OleoModel oleo)
    {
        return _oleoRepository.save(oleo);
    }

    @CrossOrigin
    @RequestMapping(value = "/oleo/{id_oleo}", method =  RequestMethod.PUT)
    public ResponseEntity<OleoModel> Put(@PathVariable(value = "id_oleo") long id_oleo, @Valid @RequestBody OleoModel newOleo)
    {
        Optional<OleoModel> oldOleo = _oleoRepository.findById(id_oleo);
        if(oldOleo.isPresent()){
            OleoModel oleo = oldOleo.get();
            oleo.setRegiao(newOleo.getRegiao());
            oleo.setEndereco(newOleo.getEndereco());
            _oleoRepository.save(oleo);
            return new ResponseEntity<OleoModel>(oleo, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/oleo/{id_oleo}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id_oleo") long id_oleo)
    {
        Optional<OleoModel> oleo = _oleoRepository.findById(id_oleo);
        if(oleo.isPresent()){
        	_oleoRepository.delete(oleo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}