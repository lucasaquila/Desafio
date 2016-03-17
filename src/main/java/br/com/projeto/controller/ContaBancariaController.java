package br.com.projeto.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.entity.Banco;
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
		List<ContaBancaria> contasBancarias = contaBancariaService.findAll();
		return contasBancarias;
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ContaBancaria getContaBancaria(@PathVariable("id") long id) {
        ContaBancaria contaBancaria = contaBancariaService.findById(id);
        return contaBancaria;
    }
	
	@RequestMapping("/getBancos")
	public List<Banco> getBancos()
	{
		List<Banco> banco = Arrays.asList(Banco.values());
		return banco;
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
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ContaBancaria save(@RequestBody ContaBancaria contaBancaria){
        System.out.println("Entrou no método");
        return contaBancariaService.save(contaBancaria);
	}
	
	@RequestMapping(value = "/saldoInicial", method = RequestMethod.GET)
	public ModelAndView alterar(){
		ModelAndView modelAndView =	new ModelAndView("contaBancaria/saldoInicial");
		return modelAndView;
	}
	
	
	
}
