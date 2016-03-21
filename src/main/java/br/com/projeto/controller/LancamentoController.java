package br.com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.entity.ContaBancaria;
import br.com.projeto.entity.Lancamento;
import br.com.projeto.service.ContaBancariaService;
import br.com.projeto.service.LancamentoService;

@Controller
@Transactional
@RestController
@RequestMapping("/lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("lancamento/list");
		return modelAndView;
	}
	
	@RequestMapping("/getLancamentos")
	public List<Lancamento> getContasBancarias(SecurityContextHolderAwareRequestWrapper request){
		List<Lancamento> lancamentos = lancamentoService.findAll(request);
		return lancamentos;
	}
	
	@RequestMapping(value = "/deposito", method = RequestMethod.GET)
	public ModelAndView form(){
		ModelAndView modelAndView =	new ModelAndView("lancamento/deposito");
		return modelAndView;
	}

}
