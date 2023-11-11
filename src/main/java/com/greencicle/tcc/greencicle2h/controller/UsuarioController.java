package com.greencicle.tcc.greencicle2h.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greencicle.tcc.greencicle2h.model.Usuario;
import com.greencicle.tcc.greencicle2h.repository.UsuarioRepository;

@Controller
@RequestMapping("/greencicle/usuario")
public class UsuarioController {
	
	@Autowired // injeção de dependencia ( o objeto será criado pelo spring automaticamente)
	private UsuarioRepository usuarioRepository;
	
	
		// carrega formulario de cadastro do usuario
	@GetMapping("/novo-usuario")
	public String novoUsuario( Usuario usuario, Model model) {
		
		model.addAttribute("ususario", usuario);
		
		
		return "greencicle/cadastro";
	}
	// inserir usuario no banco de dados
	@PostMapping("/add-usuario")
	public String addUsuario(Usuario usuario, Model model) {
		usuario.setCodStatusUsuario(true);
		
		Usuario usuarioDb = usuarioRepository.save(usuario);
		
		return "redirect:/greencicle/usuario/login";
	}
	
	
	@GetMapping("/home")
	public String showHome(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/home";
		
	}
	
	@GetMapping("/noticia")
	public String showNoticia(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/noticia";
	}
	
	@GetMapping("/contato")
	public String showContato(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/contato";
	}
	
	
	@GetMapping("/login")
	public String showLogin(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/login";
	}
	//puxar o login ciriado no banco de dados 
	@PostMapping("/login")
	public String logon(Usuario usuario, Model model) {
		Usuario usuarioDb = usuarioRepository.findByLogin(usuario.getEmail(), usuario.getSenha());
		if(usuarioDb !=null && usuario.getSenha().equals(usuarioDb.getSenha())&& usuario.getEmail().equals(usuarioDb.getEmail())) {
			return "redirect:/greencicle/usuario/home";
			
		}
		return "greencicle/login";
	}
	
	@GetMapping("/oceno")
	public String showOceano(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/oceno";
	}
	
	@GetMapping("/energia")
	public String showEnergia(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/energia";
	}
	
	@GetMapping("/esq_senha")
	public String showEsqueceusenha(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/esq_senha";
	}
	
	@GetMapping("/Greentech")
	public String showGreentech(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/Greentech";
	}
	@GetMapping("/novo-produto")
	public String showProduto_new(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/novo-produto";
	}
	
	
}
 

