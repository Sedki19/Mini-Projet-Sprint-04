package com.sedki.pcs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sedki.pcs.entities.Marque;
import com.sedki.pcs.entities.Pc;
import com.sedki.pcs.service.PcService;

import jakarta.validation.Valid;

@Controller
public class PcController {
	@Autowired
	PcService PcService;
	
	@GetMapping(value = "/")
	public String welcome() {
	    return "index";
	}
	
	
		   @RequestMapping("/listePcs")
			public String listePcs(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
										@RequestParam (name="size", defaultValue = "2") int size)
			{
			Page<Pc> prods = PcService.getAllPcsParPage(page, size);
				modelMap.addAttribute("Pcs", prods);
		         modelMap.addAttribute("pages", new int[prods.getTotalPages()]);	
				modelMap.addAttribute("currentPage", page);			
				return "listePcs";	
			}


		   @RequestMapping("/showCreate")
			public String showCreate(ModelMap modelMap)
			{
				modelMap.addAttribute("Pc", new Pc());
				List<Marque> cats = PcService.getAllMarques();
				modelMap.addAttribute("mode", "new");
				modelMap.addAttribute("Marques", cats);
				return "formPc";
			}
		   
		   
			


		   @RequestMapping("/savePc")
			public String savePc(@Valid Pc Pc, BindingResult bindingResult,
					@RequestParam (name="page",defaultValue = "0") int page,
					@RequestParam (name="size", defaultValue = "2") int size)
			{
				int currentPage;
				boolean isNew = false;
			   if (bindingResult.hasErrors()) return "formPc";				  
				
			   if(Pc.getIdPc()==null) //ajout
				    isNew=true;
			  			   
			  	PcService.savePc(Pc);
			  	if (isNew) //ajout
			  	{
			  		Page<Pc> prods = PcService.getAllPcsParPage(page, size);
			  		currentPage = prods.getTotalPages()-1;
			  	}
			  	else //modif
			  		currentPage=page;
			  	
			  	
				//return "formPc";
				return ("redirect:/listePcs?page="+currentPage+"&size="+size);
			}


	  @RequestMapping("/supprimerPc")
		public String supprimerPc(@RequestParam("id") Long id,
				ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{

			PcService.deletePcById(id);
			Page<Pc> prods = PcService.getAllPcsParPage(page, size);
			modelMap.addAttribute("Pcs", prods);		
			modelMap.addAttribute("pages", new int[prods.getTotalPages()]);	
			modelMap.addAttribute("currentPage", page);	
			modelMap.addAttribute("size", size);	
			return "listePcs";	
		}


	@RequestMapping("/modifierPc")
	public String editerPc(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Pc p = PcService.getPc(id);
		List<Marque> cats = PcService.getAllMarques();
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("Pc", p);
		modelMap.addAttribute("Marques", cats);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		
		return "formPc";
	}
	  
	

	@RequestMapping("/updatePc")
	public String updatePc(@ModelAttribute("Pc") Pc Pc, 
			ModelMap modelMap) throws ParseException {
		// conversion de la date
	

		PcService.updatePc(Pc);
		List<Pc> prods = PcService.getAllPcs();
		modelMap.addAttribute("Pcs", prods);
		return "listePcs";
	}
}
