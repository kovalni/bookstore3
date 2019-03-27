package com.example.Osoitemuistio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

@Controller
public class YhteystietoController {
	
	
	@Autowired
	private YhteystietoRepository repository;
	@Autowired
	private HttpSession session;
	
	//Kirjaudu sisään
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	//Näytä kaikki yhteystiedot listana
	@RequestMapping(value="/osoitemuistio")
	   	public String yhteystietoLista(Model model) {
		model.addAttribute("yhteystiedot", repository.findAll());
	    return "YhteystietoLista";
	 }
	
	//RESTful finding all
	@RequestMapping(value="/yhteystiedot", method = RequestMethod.GET)
		public @ResponseBody List<Yhteystieto> YhteystietoListRest(){
		return(List<Yhteystieto>) repository.findAll();
	}
	
	//RESTful finding by ID
	@RequestMapping(value="/yhteystieto/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Yhteystieto> findYhteystietoRest(@PathVariable("id") Long id) {	
		return repository.findById(id);
	}
	
	//RESTful deleting from database
	  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		@PreAuthorize("hasAuthority('ADMIN')")
	    public String deleteYhtestieto(@PathVariable("id") Long id, Model model) {
	    	repository.deleteById(id);
	        return "redirect:../osoitemuistio";
	    } 
	  
	//Lisää uusi yhteystieto
	    @RequestMapping(value = "/uusi")
	    public String addYhteystieto(Model model){
	    	model.addAttribute("yhteystieto", new Yhteystieto());
	        return "addnewTemplate";
	    }  
	    
	//Tallenna uusi yhteystieto
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Yhteystieto yhteystieto){
	        repository.save(yhteystieto);
	        return "redirect:osoitemuistio";
	    }   
	    
	//Muokkaa yhteystietoa
	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String editYhteystieto(@PathVariable("id") Long id, Model model){
	    	model.addAttribute("yhteystieto", repository.findById(id));
	        return "editTemplate";
	    }
	    
	//Tallenna muutokset
	    @RequestMapping(value = "/edit/save", method = RequestMethod.POST)
	    public String change(Yhteystieto yhteystieto) {
	        repository.save(yhteystieto);
	        return "redirect:../osoitemuistio";
	        
	    }
	    

}	
