package br.com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.entity.ContaBancaria;
import br.com.projeto.entity.TipoUsuario;
import br.com.projeto.entity.Usuario;
import br.com.projeto.service.ContaBancariaService;
import br.com.projeto.service.UsuarioService;

@Controller
@Transactional
@RestController
@RequestMapping("/contaBancaria")
public class ContaBancariaController {

	@Autowired
	private ContaBancariaService contaBancariaService;
	
	@RequestMapping("/getContasBancarias")
	public List<ContaBancaria> getContasBancarias(){
		List<ContaBancaria> contasBancarias =contaBancariaService.findAll();
		return contasBancarias;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("contaBancaria/list");
		return modelAndView;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(){
		ModelAndView modelAndView =	new ModelAndView("contaBancaria/form");
		return modelAndView;
	}
	
}
