package br.com.projeto.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
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
import br.com.projeto.entity.UsuarioLogado;
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
	public List<ContaBancaria> getContasBancarias(SecurityContextHolderAwareRequestWrapper request){
		List<ContaBancaria> contasBancarias = contaBancariaService.findAll(request);
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
	
	@PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(){
		ModelAndView modelAndView =	new ModelAndView("contaBancaria/form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/detalhes", method = RequestMethod.GET)
	public ModelAndView detalhes(){
		ModelAndView modelAndView =	new ModelAndView("contaBancaria/detalhes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ContaBancaria save(@RequestBody ContaBancaria contaBancaria){
        System.out.println("Entrou no método");
        return contaBancariaService.save(contaBancaria);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
	@RequestMapping(value = "/saldoInicial", method = RequestMethod.GET)
	public ModelAndView alterar(){
		ModelAndView modelAndView =	new ModelAndView("contaBancaria/saldoInicial");
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @RequestMapping(value = "/saldoInicial/{id}", method = RequestMethod.PUT)
    public BigDecimal inserirSaldoInicial(@PathVariable("id") long id, @RequestBody BigDecimal saldo) {
        contaBancariaService.inserirSaldoInicial(id, saldo);
        return saldo;
    }
    
	@PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT)
    public ContaBancaria editar(@PathVariable("id") long id, @RequestBody ContaBancaria contaBancaria) {
    	
        UsuarioLogado user = (UsuarioLogado)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String tipo = user.getTipoUsuario().toString();
    	
        contaBancariaService.updateContaBancaria(contaBancaria);
        return contaBancaria;
    }
	
	@PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
	public String excluirContaBancaria(@PathVariable("id") long id){
		contaBancariaService.deleteContaBancaria(id);
		return "";
	}
	
}
