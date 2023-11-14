package com.greencicle.tcc.greencicle2h.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	//a th:href="@{/greencicle/usuario/home/{id}(id=${usuario.id})}" modelo de como colocar os links das páginas
	//só não coloque o "/{id}(id=${usuario.id})" em páginas onde o usuário não está logado ou quando o site precisa verificar
	//as credenciais, como em páginas de cadastro, login e verificação de credenciais, mas em todos os outros links 
	//tem que colocar assim no HTML
	
	@GetMapping("/home/{id}")
	 public ModelAndView usuariodetalhes(@PathVariable("id") Long id ){
        ModelAndView mv = new ModelAndView("greencicle/home");
        Usuario usuario = usuarioRepository.findById(id);
        mv.addObject("usuario",usuario);
        return mv;
    }
	
	@GetMapping("/noticia/{id}")
	public String showNoticia(Usuario usuario, Model model, @PathVariable("id") Long id ){
		model.addAttribute("usuario", usuario);
		usuario = usuarioRepository.findById(id);
		return "greencicle/noticia";
	}
	
	@GetMapping("/contato/{id}")
	public String showContato(Usuario usuario, Model model, @PathVariable("id") Long id) {
		model.addAttribute("usuario", usuario);
		usuario = usuarioRepository.findById(id);
		return "greencicle/contato";
	}
	
	
	@GetMapping("/login")
	public String showLogin(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/login";
	}
	//puxar o login ciriado no banco de dados 
	@PostMapping("/login")
	  public ModelAndView efetuarLogin(@ModelAttribute Usuario usuario){
        ModelAndView page = new ModelAndView();
        usuario = usuarioRepository.findByLogin(usuario.getEmail(), usuario.getSenha());
        if (usuario ==null) {
            page.setViewName("greencicle/login");
        }
        else{
            page.setViewName("greencicle/home");
        }
        page.addObject("usuario",usuario);
        return page;
    }
	
	@GetMapping("/oceno/{id}")
	public String showOceano(Usuario usuario, Model model, @PathVariable("id") Long id) {
		model.addAttribute("usuario", usuario);
		usuario = usuarioRepository.findById(id);
		return "greencicle/oceno";
	}
	
	@GetMapping("/energia/{id}")
	public String showEnergia(Usuario usuario, Model model, @PathVariable("id") Long id) {
		model.addAttribute("usuario", usuario);
		usuario = usuarioRepository.findById(id);
		return "greencicle/energia";
	}
	
	@GetMapping("/esq_senha")
	public String showEsqueceusenha(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/esq_senha";
	}
	
	@GetMapping("/Greentech/{id}")
	public String showGreentech(Usuario usuario, Model model, @PathVariable("id") Long id) {
		model.addAttribute("usuario", usuario);
		usuario = usuarioRepository.findById(id);
		return "greencicle/Greentech";
	}
	@GetMapping("/novo-produto")
	public String showProduto_new(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "greencicle/novo-produto";
	}
	
	
}
 

