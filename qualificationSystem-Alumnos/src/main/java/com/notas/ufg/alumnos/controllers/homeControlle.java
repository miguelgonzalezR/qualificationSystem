package com.notas.ufg.alumnos.controllers;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.notas.ufg.alumnos.models.Alumno;
import com.notas.ufg.alumnos.repocitorio.login.AlumRepocitorio;

import com.notas.ufg.alumnos.models.Notas;

import com.notas.ufg.crud.INotasSer;

import com.notas.ufg.repocitorios.IAlum;

import com.notas.ufg.crud.IAlumSer;

import com.notas.ufg.correos.Recucon;

@Controller
public class homeControlle {
	
	@Autowired
	private Recucon recon;
	
	@Autowired
	private INotasSer notasa;
	
	@Autowired
	private IAlum alm;
	
	@Autowired
	private IAlumSer alper;
	
	
	@GetMapping({"/","/login"})
	public String index() {
		return "login";
	}
	
	@GetMapping("/recuperar")
	public String recuf() {
		return "recuperarCo";
	}
	
	@GetMapping("/enviarcon")
	public String enviarc() {
		return ("recuperarf");
	}
	
	@GetMapping("/index")
	public String indexA(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		Optional<Alumno> als = alm.getByUsuario(userName);
		
		int ida = als.get().getIdal();
		
		
		List<Notas> notas = notasa.listar(ida);
		
		model.addAttribute("notas", notas);
		
		
		
		model.addAttribute("userName", userName);
		
		
		
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfill(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		Optional<Alumno> usua = alm.getByUsuario(userName);
		
		
		model.addAttribute("usua", usua);
		
		
		
		
		return "EditarPer";
	}
	
	@GetMapping("/perfil/{error}")
	public String perfilE(@PathVariable String error, Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		Optional<Alumno> usua = alm.getByUsuario(userName);
		
		model.addAttribute("usua", usua);
		
		String men;
		
		String clnc = "ClaveNC";
		
		String cor = "CorreoE";
		
		String eusu = "UsuaE";
		
		if(error.equals(clnc)) {
			men = "Las contraseñas no considen";
		} else if(error.equals(cor)){
			men = "Ya existe un usuario con este correo";
		}else if(error.equals(eusu)){
			men = "Ya existe un usuario con este nombre de usuario";
		}
		else {
			men ="Error";
		}
		
		model.addAttribute("men", men);
		
		return "EditarPer";
	}
	
	@PostMapping("/guardarPer")
	public String guardarPer(@Validated Alumno a, Model model) {
		
		int res = alper.EditarAl(a, a.getIdal());
		
		String men;
		
		if(res == 2) {
			men = "ClaveNC";
			model.addAttribute("men", men);
			return "redirect:/perfil/"+ men;
		} else if(res == 3) {
			men = "CorreoE";
			model.addAttribute("men", men);
			return "redirect:/perfil/"+ men;
		}
		else if(res == 4) {
			men = "UsuaE";
			model.addAttribute("men", men);
			return "redirect:/perfil/"+ men;
		}
		
		
		return "redirect:/login?logout";
	}
	
	@PostMapping("/Recucon")
    public String Recucon( @RequestParam("mail") String mail){
		
		Optional<Alumno> recoadl = alm.getByCorreo(mail);
		
		String men = null;
		
		if(recoadl.isEmpty()) {
			
			men = "error";
			
			return "redirect:/recuperar/"+men;
		} else {

			Alumno gua = recoadl.get();

			String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

			String cla = "";

			for (int x = 0; x < 8; x++) {
				int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
				char caracterAleatorio = banco.charAt(indiceAleatorio);
				cla += caracterAleatorio;
			}

			alper.recu(gua, recoadl.get().getIdal(), cla);

			System.out.println(gua.getApellido());

			System.out.println(recoadl.get().getIdal());

			System.out.println(cla);

			String message = "Su nueva contraseña es: " + cla;
			recon.sendMail("qualificationsystemufg@gmail.com", mail, recoadl.get().getUsuario(), message);

			return "redirect:/enviarcon";

		}
		
		
    }
	
	@GetMapping("/recuperar/{error}")
	public String recufE(@PathVariable String error, Model model) {
		String men = "No existe ningún usuario con este correo electrónico";
		
		model.addAttribute("men", men);
		
		return "recuperarCo";
	}
	
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
	    // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
	    return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}

}
