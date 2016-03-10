package br.com.projeto.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projeto.entity.TipoUsuario;
import br.com.projeto.entity.Usuario;
import br.com.projeto.service.UsuarioService;


@Controller
@Transactional
@RequestMapping("/usuario")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(@ModelAttribute("usuario") Usuario usuario){
		ModelAndView modelAndView =	new ModelAndView("usuario/form");
		modelAndView.addObject("tipos", TipoUsuario.values());
		return modelAndView;
	}

	/*@RequestMapping(method=RequestMethod.POST, name="salvarUsuario")*/
	@RequestMapping(method=RequestMethod.POST, value ="save")
	public ModelAndView save(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors())
		{
			return form(usuario);
		}
		/*usuarioDAO.save(usuario);*/
		usuario.setSituacao(true);
		usuarioService.save(usuario);
		redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso");
		return new ModelAndView("redirect:/usuario");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("usuario/list");
		modelAndView.addObject("usuarios", usuarioService.findAll());
		return modelAndView;
	}
	
	@RequestMapping("/lista")
	public ModelAndView usuarios(){

		return new ModelAndView("usuario/usuarios");
	}
	
	@RequestMapping("/listagem")
	public List<Usuario> getUsuarios(){
		List<Usuario> usuarios =usuarioService.findAll();
		return usuarios;
	}


}
