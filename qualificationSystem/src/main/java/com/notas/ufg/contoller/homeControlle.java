package com.notas.ufg.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class homeControlle {
	
	@GetMapping({"/","/login"})
	public String index() {
		return "loginAd/login";
	}
	
	@GetMapping("/recuperar")
	public String recuf() {
		return "loginAd/recuperarCo";
	}
	
	@GetMapping("/enviarcon")
	public String enviarc() {
		return "loginAd/recuperarf";
	}
	
	
	

}
