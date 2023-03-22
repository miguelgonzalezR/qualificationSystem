package com.notas.ufg.contoller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.notas.ufg.correos.Recucon;
import com.notas.ufg.models.Grados;
import com.notas.ufg.cruds.AdminService;
import com.notas.ufg.cruds.GradoService;
import com.notas.ufg.cruds.IAlumSer;
import com.notas.ufg.cruds.IFechasSer;
import com.notas.ufg.cruds.Iadmincon;
import com.notas.ufg.cruds.IgradoService;
import com.notas.ufg.models.Administradores;
import com.notas.ufg.models.Materia;
import com.notas.ufg.models.Notas;
import com.notas.ufg.cruds.IMateSer;
import com.notas.ufg.models.Fechaed;

import com.notas.ufg.cruds.IPeriodoSer;

import com.notas.ufg.cruds.INotasSer;

import com.notas.ufg.models.Alumnos;
import com.notas.ufg.models.Authority;
import com.notas.ufg.models.Periodo;

import com.notas.ufg.repocitorios.IPeriodo;

import com.notas.ufg.repocitorios.IMateriasRepo;

import com.notas.ufg.repocitorios.IGradoR;

import com.notas.ufg.repocitorios.IAlumnosRepo;

import com.notas.ufg.repocitorios.Iadmin;

import com.notas.ufg.repocitorios.IFechasE;

import com.notas.ufg.repocitorios.ValiAd;

import com.notas.ufg.repocitorios.INotas;

import com.notas.ufg.cruds.IPeriodoSer;


@Controller

public class adminController {
	
	@Autowired
    private INotas graf;
	
	@Autowired
    private IPeriodoSer valipe;
	
	@Autowired
    private ValiAd recoul;
	
	@Autowired
    private Recucon mailService;

	@Autowired
	private Iadmin usu;
	
	@Autowired
	private IFechasSer fechamo;

	@Autowired
	private IMateriasRepo matb;
	
	@Autowired
	private IAlumnosRepo alid;
	
	@Autowired
	private IGradoR gra;
	
	@Autowired
	private IgradoService gradosc;
	
	@Autowired
	private IPeriodo pe;
	
	@Autowired
	private Iadmincon admins;
	
	@Autowired
	private AdminService adminss;
	
	@Autowired
	private GradoService add;
	
	@Autowired
	private IMateSer mater;
	
	@Autowired
	private IAlumSer alumn;
	
	@Autowired
	private INotasSer notasm;
	
	@Autowired IPeriodoSer peri;
	private 
	
	int a = 1;
	
	int b = 2;
	
	@GetMapping("/indexA")
	public String indexA(Model model) {
		
		int app1 = graf.aproP1().size();
		int app2 = graf.aproP2().size();
		int app3 =graf.aproP3().size();
		int app4 = graf.aproP4().size();
		int rep1 = graf.rproP1().size();
		int rep2 = graf.rproP2().size();
		int rep3 = graf.rproP3().size();
		int rep4 = graf.rproP4().size();
		
		int pe1 = app1;
		model.addAttribute("pe1", pe1);
		
		int pe2 = app2;
		model.addAttribute("pe2", pe2);
		
		int pe3 = app3;
		model.addAttribute("pe3", pe3);
		
		int pe4 = app4;
		model.addAttribute("pe4", pe4);
		
		int rpe1 = rep1;
		model.addAttribute("rpe1", rpe1);
		
		int rpe2 = rep2;
		model.addAttribute("rpe2", rpe2);
		
		int rpe3 = rep3;
		model.addAttribute("rpe3", rpe3);
		
		int rpe4 = rep4;
		model.addAttribute("rpe4", rpe4);
		
		
		return "Administrador/index";
	}
	
	@GetMapping("/secciones")
	public String secciones() {
		return "Administrador/secciones";
	}
	
	
	@GetMapping("/notasm")
	public String notasm(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		Optional<Administradores> usua = usu.getByUsuario(userName);
		
		Administradores mama = new Administradores(); 
		
		
		if(usua.get().getTipo() == 1) {
			System.out.println("Eres Admin");
			
			List<Materia> mate = mater.listar();
			
			
			model.addAttribute("mate", mate);
			
			
		} else {
			System.out.println("Eres master");
			
			List<Materia> matm = matb.findByIdmaes(usua);
			
			System.out.println(matm.size());
			model.addAttribute("mate", matm);
			
			
		}
		
		
		
		return "Administrador/notas";
	}
	
	@PostMapping("/notasmBu")
	public String notasmB(Model model,@RequestParam("buscar") String buscar) {
		
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		Optional<Administradores> usua = usu.getByUsuario(userName);
		
		Administradores mama = new Administradores(); 
		
		
		if(usua.get().getTipo() == 1) {
			System.out.println("Eres Admin");
			
			List<Materia> mate = matb.buscarmA(buscar);
			
			
			model.addAttribute("mate", mate);
			
			
		} else {
			System.out.println("Eres master");
			
			List<Materia> matm = matb.findByIdmaes(usua);
			
			List<Materia> maf = new ArrayList<Materia>();
			
			List<Materia> matem = matb.buscarmA(buscar);
			
			System.out.println(matem.size());
			
			if(buscar != "") {
				
				
				for(int i = 0; i < matem.size(); i++ ) {
					
					
					if(matem.get(i).getIdmaes().getId() == usua.get().getId()) {
						
						
						maf.add(matem.get(i));
					}
				}
			} else {
				maf = matb.findByIdmaes(usua);
			}
			
			
			
			
			
			System.out.println(matm.size());
			model.addAttribute("mate", maf);
			
			
		}
		
		return "Administrador/notas";
	}
	
	@GetMapping("/seccionesa")
	public String seccionesa(Model model) {
		
		
		List<Grados> grados = gradosc.listar();
		
		model.addAttribute("grados", grados);
		
		return "Administrador/SeccionesA";
	}
	
	@PostMapping("/seccionesaB")
	public String seccionesaB(Model model,@RequestParam("buscar") String buscar) {
		
		
		List<Grados> grados = gradosc.buscar(buscar);
		
		model.addAttribute("grados", grados);
		
		return "Administrador/SeccionesA";
	}
	
	
	@GetMapping("/NuevaS")
	public String agregarS(Model model) {
		
		model.addAttribute("grado", new Grados());
		
		return "Administrador/Secciones/AddSecciones";
	}
	
	@PostMapping("/guardarS")
	public String guardarS(@Validated Grados g, Model model) {
		gradosc.guardar(g); 
		return "redirect:/seccionesa";
	}
	

	@GetMapping("/editars/{id}")
	public String editars(@PathVariable int id, Model model) {
		
		Optional<Grados> grados = gradosc.listarId(id);
		model.addAttribute("grado", grados);
		
		return "Administrador/Secciones/Editars";
	}
	
	@GetMapping("/eliminars/{id}")
	public String eliminars(Model model, @PathVariable int id) {
		
		gradosc.eliminar(id);
		return "redirect:/seccionesa";
		
	}
	
	/////////Rutas de adimnistradores////////
	
	@GetMapping("/administradores")
	public String admin(Model model) {
		
		List<Administradores> admin = adminss.adminsb(a);
		
		model.addAttribute("admin", admin);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		model.addAttribute("userName", userName);
		
		
		return "Administrador/admin/Admin";
		
		
	}
	
	
	@GetMapping("/NuevaA")
	public String agregarA(Model model) {
		
		model.addAttribute("admin", new Administradores());
		
		return "Administrador/Admin/FormAdmin";
	}
	
	@GetMapping("/NuevaAE/{error}")
	public String agregarAE(@PathVariable String error, Model model) {
		
		model.addAttribute("admin", new Administradores());
		
		String men;
		
		String cl = "ClaveE";
		
		String co = "CorreoE";
		
		String us = "UsuarioE";
		
		if(error.equals(co) ) {
			men = "Ya existe un usuario con este correo";
		} else if(error.equals(us)) {
			men = "Ya existe un usuario con este nombre de usuario";
		}else if(error.equals(cl)) {
			men = "Las contraseñas no coinciden";
		}else {
			men ="Error";
		}
		
		
		
		model.addAttribute("men", men);
		
		return "Administrador/Admin/FormAdmin";
	}
	
	@PostMapping("/guardarAd")
	public String guardarAd(@Validated Administradores a, Model model) {
		int res = adminss.guardar(a);
		
		String men;
		
		if(res == 2) {
			men = "ClaveE";
			model.addAttribute("men", men);
			return "redirect:/NuevaAE/"+ men;
		} else if(res == 3) {
			men = "CorreoE";
			model.addAttribute("men", men);
			return "redirect:/NuevaAE/"+ men;
		}else if(res == 4) {
			men = "UsuarioE";
			model.addAttribute("men", men);
			return "redirect:/NuevaAE/"+ men;
		}else{	
			return "redirect:/administradores";
		}

	}
	
	@GetMapping("/eliminaraad/{id}")
	public String eliminarad(Model model, @PathVariable int id) {
		
		adminss.eliminar(id);
		return "redirect:/administradores";
		
	}
	
	@PostMapping("/administradoresB")
	public String buscarAd(Model model, @RequestParam("buscar") String buscar) {
		
		List<Administradores> admin = adminss.buscador(buscar, 1);
		
		model.addAttribute("admin", admin);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		model.addAttribute("userName", userName);
		
		
		return "Administrador/admin/Admin";
		
	}
	
	
	
	/////////Rutas de maestros////////
	
	@GetMapping("/maestros")
	public String maes(Model model) {
		
		List<Administradores> maestros = adminss.adminsb(b);
		
		model.addAttribute("maestros", maestros);
		
		return "Administrador/Maestros/Maestros";
	}
	
	@PostMapping("/maestrosB")
	public String maesB(Model model, @RequestParam("buscar") String buscar) {
		
		List<Administradores> maestros = adminss.buscador(buscar, 2);
		
		model.addAttribute("maestros", maestros);
		
		
		return "Administrador/Maestros/Maestros";
		
	}

	
	@GetMapping("/Nuevama")
	public String agregarm(Model model) {
		
		model.addAttribute("master", new Administradores());
		
		return "Administrador/Maestros/FormMaestros";
	}
	
	@GetMapping("/NuevaMa/{error}")
	public String agregarMa(@PathVariable String error,Model model) {
		
		model.addAttribute("master", new Administradores());
		
		String men;
		
		String cl = "ClaveE";
		
		String co = "CorreoE";
		
		String us = "UsuarioE";
		
		if(error.equals(co) ) {
			men = "Ya existe un usuario con este correo";
		} else if(error.equals(us) ) {
			men = "Ya existe un usuario con este nombre de usuario";
		} else if(error.equals(cl) ) {
			men = "Las contraseñas no coinciden";
		}else {
			men ="Error";
		}
		
		
		
		model.addAttribute("men", men);
		
		return "Administrador/Maestros/FormMaestros";
	}
	
	@GetMapping("/Nuevam/{error}")
	public String agregarmME(@PathVariable String error,Model model) {
		
		model.addAttribute("master", new Administradores());
		
		String men;
		
		String cl = "ClaveE";
		
		String co = "CorreoE";
		
		String us = "UsuarioE";
		
		if(error.equals(co) ) {
			men = "Ya existe un usuario con este correo";
		} else if(error.equals(us) ) {
			men = "Ya existe un usuario con este nombre de usuario";
		} else if(error.equals(cl) ) {
			men = "Las contraseñas no coinciden";
		}else {
			men ="Error";
		}
		
		
		
		model.addAttribute("men", men);
		
		return "Administrador/Maestros/FormMaestros";
	}
	
	
	@PostMapping("/guardarMa")
	public String guardarMa(@Validated Administradores a, Model model) {
		int res = adminss.guardarm(a);
		
		String men;
		
		if(res == 2) {
			men = "ClaveE";
			model.addAttribute("men", men);
			return "redirect:/Nuevam/"+ men;
		} else if(res == 3) {
			men = "CorreoE";
			model.addAttribute("men", men);
			return "redirect:/Nuevam/"+ men;
		}else if(res == 4) {
			men = "UsuarioE";
			model.addAttribute("men", men);
			return "redirect:/Nuevam/"+ men;
		}else{	
			return "redirect:/maestros";
		}

	}
	
	
	
	//////////////////////////
	
	
	@GetMapping("/Nuevaal")
	public String agregaral() {
		
		
		return "Administrador/Alumnos/FormAl";
	}

	
	
	@GetMapping("/perfil/{error}")
	public String perfilE(@PathVariable String error, Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		Optional<Administradores> usua = usu.getByUsuario(userName);
		
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
		
		return "Administrador/EditarPer";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		Optional<Administradores> usua = usu.getByUsuario(userName);
		
		model.addAttribute("usua", usua);
		
		
		
		
		return "Administrador/EditarPer";
	}
	
	
	@PostMapping("/guardarPer")
	public String guardarPer(@Validated Administradores a, Model model) {
		
		int res = adminss.editar(a, a.getId());
		
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
	
	
	/////////Rutas de alumnos////////
	
	@GetMapping("/alumnos")
	public String alumnos(Model model) {
		
		
		List<Alumnos> alum = alumn.listar();
		List<Grados> grados = gradosc.listar();
		
		
		model.addAttribute("alum", alum);
		model.addAttribute("grados", grados);
		
		return "Administrador/alumnos";
	}
	
	@PostMapping("/alumnosB")
	public String alumnosB(Model model, @RequestParam("buscar") String buscar) {
		
		
		List<Alumnos> alum = alumn.buscar(buscar);
		List<Grados> grados = gradosc.listar();
		
		
		model.addAttribute("alum", alum);
		model.addAttribute("grados", grados);
		
		return "Administrador/alumnos";
	}
	
	@GetMapping("/NuevaAlm")
	public String agregarAlm(Model model) {
		
		model.addAttribute("Alumnos", new Alumnos());
		
		List<Grados> grados = gradosc.listar();

		model.addAttribute("grados", grados);
		
		return "Administrador/Alumnos/FormuAlum";
	}
	
	@GetMapping("/NuevaAlmE/{error}")
	public String agregarAlmE(@PathVariable String error, Model model) {
		
		model.addAttribute("Alumnos", new Alumnos());
		
		List<Grados> grados = gradosc.listar();

		model.addAttribute("grados", grados);
		
		String men;
		
		System.out.println(error);
		
		String c = "CarnetE";
		
		String co = "CorreoE";
		
		String us = "UsuarioE";
		
		if(error.equals(c) ) {
			men = "Ya existe un alumno con este carnet";
		} else if(error.equals(co)) {
			men = "Ya existe un alumno con este correo";
		} else if(error.equals(us)) {
			men = "Ya existe un alumno con este nombre de usuario";
		}
		else {
			men ="Error";
		}
		
		
		
		model.addAttribute("men", men);
		
		return "Administrador/Alumnos/FormuAlum";
	}
	
	
	
	
	@PostMapping("/guardarAl")
	public String guardarAl(@Validated Alumnos a, Model model) {
		int res = alumn.guardar(a);
		String men;
		
		int ida = a.getIdal();
		
		int gr = a.getIdgrado().getIdgr();
		
		Optional<Grados> grad = gra.findById(gr);
		
		List<Materia> mate = matb.findByIdgr(grad);
		
		Optional<Alumnos> uld = alid.findTopByOrderByIdalDesc();
		
		int idua = uld.get().getIdal();
		
		String carn = uld.get().getCarnet();
		
		if(res == 2) {
			men = "CarnetE";
			model.addAttribute("men", men);
			return "redirect:/NuevaAlmE/"+ men;
		} else if(res == 3) {
			men = "CorreoE";
			model.addAttribute("men", men);
			return "redirect:/NuevaAlmE/"+ men;
		}else if(res == 4) {
			men = "UsuarioE";
			model.addAttribute("men", men);
			return "redirect:/NuevaAlmE/"+ men;
		}else{
			
			for(int i = 0; i < mate.size(); i++) {
				int idm = mate.get(i).getIdma();
				notasm.guardart(idm,idua, carn);
				//System.out.println(idua);
				//System.out.println(idm);
			}
			
			return "redirect:/alumnos";
		}
		
	}
	
	@PostMapping("/Editarfi")
	public String Editarfi(@Validated Alumnos a, Model model) {
		alumn.EditarAl(a, a.getIdal()); 
		return "redirect:/alumnos";
	}
	
	
	@GetMapping("/editarAl/{id}")
	public String editarAL(@PathVariable int id, Model model) {
		
		List<Grados> grados = gradosc.listar();
		
		model.addAttribute("grados", grados);
		
		Optional<Alumnos> alm = alumn.listarId(id);
		
		model.addAttribute("alm", alm);
		
		return "Administrador/Alumnos/EdiAlum";
	}
	
	@GetMapping("/eliminarAL/{id}")
	public String eliminarsAL(Model model, @PathVariable int id) {
		
		alumn.eliminar(id);
		System.out.println(id);
		return "redirect:/alumnos";
		
	}
	
	
	
	
	////////// Rutas de materias //////////
	
	@GetMapping("/materias")
	public String materias(Model model) {
		
		
		List<Materia> mate = mater.listar();
		List<Grados> grados = gradosc.listar();
		
		
		model.addAttribute("mate", mate);
		model.addAttribute("grados", grados);
		
		return "Administrador/Materias";
	}
	
	@PostMapping("/materiasB")
	public String materiasB(Model model,@RequestParam("buscar") String buscar) {
		
		
		List<Materia> mate = mater.Buscar(buscar);
		List<Grados> grados = gradosc.listar();
		
		
		model.addAttribute("mate", mate);
		model.addAttribute("grados", grados);
		
		return "Administrador/Materias";
	}
	
	
	@GetMapping("/NuevaMate")
	public String agregarMate(Model model) {
		
		model.addAttribute("Materia", new Materia());
		
		List<Grados> grados = gradosc.listar();
		
		List<Administradores> maes = usu.getByTipo(2);
		

		model.addAttribute("grados", grados);
		
		model.addAttribute("maes", maes);
		
		return "Administrador/Materias/formMate";
	}
	
	@PostMapping("/guardarMat")
	public String guardarMat(@Validated Materia m, Model model) {
		System.out.println(m.getIdmaes().getId());
		
		int res = mater.guardar(m);
		
		int idm = m.getIdma();
		
		int ida = m.getIdgr().getIdgr();
		
		Optional<Grados> grad = gra.findById(ida);
		
		List<Alumnos> algr = alid.findByIdgrado(grad);
		
		Optional<Materia> uid = matb.findTopByOrderByIdmaDesc();
		
		int idum = uid.get().getIdma();
		
		for(int i = 0; i < algr.size(); i++) {
			int idal = algr.get(i).getIdal();
			String carn = algr.get(i).getCarnet();
			notasm.guardart(idum,idal, carn);
			//System.out.println(idua);
			//System.out.println(idm);
		}
		
		
		return "redirect:/materias";
	}
	
	@GetMapping("/editarMate/{id}")
	public String editarMate(@PathVariable int id, Model model) {
		
		List<Administradores> maest = usu.getByTipo(2);
		
		model.addAttribute("maest", maest);
		
		List<Grados> gradosma = gradosc.listar();
		
		System.out.println(gradosma);
		
		model.addAttribute("gradosma", gradosma);
		
		Optional<Materia> mate = mater.listarId(id);
		
		model.addAttribute("mate", mate);
		
		return "Administrador/Materias/EditarMate";
	}
	
	@PostMapping("/EditarMateF")
	public String EditarMateF(@Validated Materia a, Model model) {
		mater.EditarAl(a, a.getIdma());
		return "redirect:/materias";
	}
	
	@GetMapping("/eliminarMat/{id}")
	public String eliminarMat(Model model, @PathVariable int id) {
		
		mater.eliminar(id);
		return "redirect:/materias";
		
	}
	
	
	
	//////////Rutas de notas //////////
	
	@GetMapping("/notasm/{id}")
	public String notasm(Model model, @PathVariable int id) {
		
		Optional<Periodo> perio = peri.listarId(1);
		model.addAttribute("perio", perio);
		
		Optional<Periodo> perio2 = peri.listarId(2);
		model.addAttribute("perio2", perio2);
		
		Optional<Periodo> perio3 = peri.listarId(3);
		model.addAttribute("perio3", perio3);
		
		Optional<Periodo> perio4 = peri.listarId(4);
		model.addAttribute("perio4", perio4);
		
		Optional<Materia> mats = mater.listarId(id);
		
		Date fa = new Date();
		
		int fe;
		
		if(fa.after(perio.get().getFechafi())){
		    fe = 1;
		}else{
		    fe = 2;
		}
		
		int fe2;
		int fe3;
		int fe4;
		
		if(fa.after(perio.get().getFechafi())){
		    fe = 1;
		}else{
		    fe = 2;
		}
		
		if(fa.after(perio2.get().getFechafi())){
			fe2 = 1;
		}else{
			fe2 = 2;
		}
		
		if(fa.after(perio3.get().getFechafi())){
			fe3 = 1;
		}else{
			fe3 = 2;
		}
		
		if(fa.after(perio4.get().getFechafi())){
			fe4 = 1;
		}else{
			fe4 = 2;
		}
		
		
		model.addAttribute("fe", fe);
		
		model.addAttribute("fe2", fe2);
		
		model.addAttribute("fe3", fe3);
		
		model.addAttribute("fe4", fe4);
		
		Optional<Periodo> upe = pe.findTopByOrderByIdprDesc();
		
		int idpf = upe.get().getIdpr();
		
		System.out.println(idpf);
		
		
		model.addAttribute("fe", fe);
		
		model.addAttribute("idpf", idpf);
		
		
		List<Notas> notapm = notasm.verPorMaterias(id);
		
		model.addAttribute("notapm", notapm);
		model.addAttribute("mats", mats);
		
		
		
		
		return "Administrador/Notasm";
		
		
		
	}
	
	
	@PostMapping("/notasmb")
	public String notasmb(Model model, @RequestParam("buscar") String buscar, @RequestParam("id") String ids) {
		
		int id = Integer.parseInt(ids);
		
		Optional<Periodo> perio = peri.listarId(1);
		model.addAttribute("perio", perio);
		
		Optional<Periodo> perio2 = peri.listarId(2);
		model.addAttribute("perio2", perio2);
		
		Optional<Periodo> perio3 = peri.listarId(3);
		model.addAttribute("perio3", perio3);
		
		Optional<Periodo> perio4 = peri.listarId(4);
		model.addAttribute("perio4", perio4);
		
		
		
		Optional<Materia> mats = mater.listarId(id);
		
		Date fa = new Date();
		
		int fe;
		int fe2;
		int fe3;
		int fe4;
		
		if(fa.after(perio.get().getFechafi())){
		    fe = 1;
		}else{
		    fe = 2;
		}
		
		if(fa.after(perio2.get().getFechafi())){
			fe2 = 1;
		}else{
			fe2 = 2;
		}
		
		if(fa.after(perio3.get().getFechafi())){
			fe3 = 1;
		}else{
			fe3 = 2;
		}
		
		if(fa.after(perio4.get().getFechafi())){
			fe4 = 1;
		}else{
			fe4 = 2;
		}
		
		
		model.addAttribute("fe", fe);
		
		model.addAttribute("fe2", fe2);
		
		model.addAttribute("fe3", fe3);
		
		model.addAttribute("fe4", fe4);
		
		
		Optional<Periodo> upe = pe.findTopByOrderByIdprDesc();
		
		int idpf = upe.get().getIdpr();
		
		System.out.println(idpf);
		
		
		model.addAttribute("fe", fe);
		
		model.addAttribute("idpf", idpf);
		
		
		List<Notas> notapm = notasm.buscar(id, buscar, id);
		
		model.addAttribute("notapm", notapm);
		model.addAttribute("mats", mats);
		
		
		
		
		return "Administrador/Notasm";
		
		
		
	}
	
	
	@GetMapping("/editarNo1/{id}")
	public String editarNo(@PathVariable int id, Model model) {
		
		System.out.println(id);
		
		Optional<Notas> nof = notasm.listarId(id);
		
		model.addAttribute("nof", nof);
		
		Materia idc = nof.get().getIdma();
		
		int idcf = idc.getIdma();
		
		model.addAttribute("idcf", idcf);
		
		
		return "Administrador/Notas/FormP1";
	}
	
	@PostMapping("/Editarnop1")
	public String Editarnop1(@Validated Notas n, Model model) {
	
		Optional<Notas> nof = notasm.listarId(n.getIdno());
		
		notasm.EditarNo(n, n.getIdno(), nof.get().getAlcar());

		Materia idc = nof.get().getIdma();

		int idcf = idc.getIdma();

		
		return "redirect:/notasm/"+idcf;
	}
	
	
	@GetMapping("/editarNo2/{id}")
	public String editarNo2(@PathVariable int id, Model model) {
		System.out.println(id);
		
		Optional<Notas> nof = notasm.listarId(id);
		
		model.addAttribute("nof", nof);
		
		Materia idc = nof.get().getIdma();
		
		int idcf = idc.getIdma();
		
		model.addAttribute("idcf", idcf);
		
		
		return "Administrador/Notas/FormP2";
	}
	
	@PostMapping("/Editarnop2")
	public String Editarnop2(@Validated Notas n, Model model) {
		
		Optional<Notas> nof = notasm.listarId(n.getIdno());
		
		notasm.EditarNo2(n, n.getIdno(), nof.get().getAlcar());

		Materia idc = nof.get().getIdma();

		int idcf = idc.getIdma();

		
		return "redirect:/notasm/"+idcf;
	}
	
	@GetMapping("/editarNo3/{id}")
	public String editarNo3(@PathVariable int id, Model model) {
		
		Optional<Notas> nof = notasm.listarId(id);
		
		model.addAttribute("nof", nof);
		
		Materia idc = nof.get().getIdma();
		
		int idcf = idc.getIdma();
		
		model.addAttribute("idcf", idcf);
		
		
		return "Administrador/Notas/FormP3";
	}
	
	@PostMapping("/Editarnop3")
	public String Editarnop3(@Validated Notas n, Model model) {
		
		Optional<Notas> nof = notasm.listarId(n.getIdno());
		
		notasm.EditarNo3(n, n.getIdno(), nof.get().getAlcar());

		Materia idc = nof.get().getIdma();

		int idcf = idc.getIdma();
	

		
		return "redirect:/notasm/"+idcf;
	}
	
	
	@GetMapping("/editarNo4/{id}")
	public String editarNo4(@PathVariable int id, Model model) {
		
		Optional<Notas> nof = notasm.listarId(id);
		
		model.addAttribute("nof", nof);
		
		Materia idc = nof.get().getIdma();
		
		int idcf = idc.getIdma();
		
		model.addAttribute("idcf", idcf);
		
		
		return "Administrador/Notas/FormP4";
	}
	
	@PostMapping("/Editarnop4")
	public String Editarnop4(@Validated Notas n, Model model) {
		
		Optional<Notas> nof = notasm.listarId(n.getIdno());
		
		notasm.EditarNo4(n, n.getIdno(), nof.get().getAlcar());

		Materia idc = nof.get().getIdma();

		int idcf = idc.getIdma();

		
		return "redirect:/notasm/"+idcf;
	}
	
	//////////Rutas de notas //////////
	
	
	@GetMapping("/periodos")
	public String periodos(Model model) {
		
		
		List<Periodo> per = peri.listar();
		
		model.addAttribute("per", per);
		
		return "Administrador/Periodo";
	}
	
	
	@GetMapping("/editarsPeri/{id}")
	public String editarsPeri(@PathVariable int id, Model model) {
		
		Optional<Fechaed> periodo = fechamo.listarId(id);
		model.addAttribute("periodo", periodo);
		
		return "Administrador/EdiPeriodo";
	}
	
	@GetMapping("/editarsPeriError/{id}/{error}")
	public String editarsPeriError(@PathVariable int id, @PathVariable String error, Model model) {
		
		Optional<Fechaed> periodo = fechamo.listarId(id);
		model.addAttribute("periodo", periodo);
		
		String men = null;
		
		String fem = "Fechai";
		
		
		if(error.equals(fem) ) {
			men = "La fecha de inicio no puede ser mayor que la fecha de cierre";
		} 
		
		
		
		model.addAttribute("men", men);
		
		return "Administrador/EdiPeriodo";
	}
	
	
	@PostMapping("/EditarPeri")
	public String EditarPeri(@Validated Fechaed p, Model model) {
		int res = fechamo.guardar(p);
		
		if(res == 2) {
			System.out.println(res);
			return "redirect:/editarsPeriError/" + p.getIdpr() + "/Fechai";
		} else {
			System.out.println(res);
			return "redirect:/periodos";
		}
		
		
	}
	
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
	    // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
	    return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}
	
	//////////Recuperar contraseña //////////
	
	@PostMapping("/Recucon")
    public String Recucon( @RequestParam("mail") String mail, Model model){
		
		Optional<Administradores> recoadl = recoul.getByCorreo(mail);
		
		String men = null;
		
		if (recoadl.isEmpty()) {

			men = "error";


			return "redirect:/recuperar/"+men;
			
			
			
		} else {
			Administradores gua = recoadl.get();
			
			 String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			 
			 String cla = "";
			 
			 for (int x = 0; x < 8; x++) {
			        int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
			        char caracterAleatorio = banco.charAt(indiceAleatorio);
			        cla += caracterAleatorio;
			    }
			 
			
			admins.recuco(gua, recoadl.get().getId(), cla);
			
			System.out.println(gua.getApellidos());
			
			System.out.println(recoadl.get().getId());
			
			System.out.println(cla);

	        String message =  "Su nueva contraseña es: " + cla;
	        mailService.sendMail("qualificationsystemufg@gmail.com",mail,recoadl.get().getUsuario(),message);
	        
	        men = null;
	        

	        return "redirect:/enviarcon";
			
		}
		
    }
	
	
	@GetMapping("/recuperar/{error}")
	public String recufE(@PathVariable String error, Model model) {
		String men = "No existe ningún usuario con este correo electrónico";
		
		model.addAttribute("men", men);
		
		return "loginAd/recuperarCo";
	}
	
	
}
