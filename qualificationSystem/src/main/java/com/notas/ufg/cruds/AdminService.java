package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notas.ufg.models.Administradores;
import com.notas.ufg.repocitorios.Iadmin;

import com.notas.ufg.repocitorios.ValiAd;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class AdminService implements Iadmincon{
	
	@Autowired
	private Iadmin data;
	
	@Autowired
	private ValiAd vali;
	

	@Override
	public List<Administradores> listar() {
		return (List<Administradores>)data.findAll();
	}
	

	@Override
	public Optional<Administradores> listarId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int guardar(Administradores a) {
		int res = 0;
		
		Administradores admin = new Administradores();
		
		admin.setNombre(a.getNombre());
		admin.setApellidos(a.getApellidos());
		admin.setCorreo(a.getCorreo());
		admin.setTipo(1);
		admin.setUsuario(a.getUsuario());
		admin.setClave(a.getClave());
		admin.setClaveco(a.getClaveco());
		
		String pass1 = admin.getClave();
		String pass2 = admin.getClaveco();
		
		List<Administradores> co = data.getByCorreo(admin.getCorreo());
		
		Optional<Administradores> us = data.getByUsuario(admin.getUsuario());
		
		if(pass1.equals(pass2)) {
			
			String coen = TestCrypt(a.getClave());
			admin.setClave(coen);
			
			if(co.isEmpty()) {
				if(us.isEmpty()) {
					
					Administradores ad = data.save(admin);
					System.out.println("guar ad");
					
					if (ad.equals(null)) {
						
						
						
						res = 1;
					}
					
				} else {
					res= 4;
				}
			} else {
				res = 3;
			}
			
			
			
			
			
			
		} else {
			res = 2;
		}
		
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	public List<Administradores> adminsb(int tipo) {
		return (List<Administradores>)data.getByTipo(tipo);
	}


	@Override
	public int editar(Administradores a, int id) {
		int res = 0;
		
		Administradores admin = new Administradores();
		
		admin.setId(a.getId());
		admin.setNombre(a.getNombre());
		admin.setApellidos(a.getApellidos());
		admin.setCorreo(a.getCorreo());
		admin.setUsuario(a.getUsuario());
		admin.setClave(a.getClave());
		admin.setClaveco(a.getClaveco());
		
		String pass1 = admin.getClave();
		String pass2 = admin.getClaveco();
		
		
		Optional<Administradores> co = vali.getByCorreo(admin.getCorreo());
		
		Optional<Administradores> us = data.getByUsuario(admin.getUsuario());
		
		Optional<Administradores> use = data.findById(a.getId());
		
		admin.setAuthority(use.get().getAuthority());
		
		String passb =use.get().getClave();
		
		System.out.println(admin.getClave());
		
		System.out.println(passb);
		
		System.out.println(use.get().getTipo());
		
		admin.setTipo(use.get().getTipo());
		
		
		if((pass1.length() > 0) || (pass2.length() > 0)) {
			String coen = TestCrypt(a.getClave());
			admin.setClave(coen);
			
			
			
			
			if(pass1.equals(pass2)) {
				if((co.isEmpty()) || (co.get().getId() == a.getId())) {
					if((us.isEmpty()) || (us.get().getId() == a.getId())) {
						
						Administradores ad = data.save(admin);
						System.out.println("guar ed");
						
						if (ad.equals(null)) {
							System.out.println();
							
							
							res = 1;
						}
						
					} else {
						res = 4;
					}
					
				} else {
					res = 3;
				}
			} else {
				res = 2;
			}
			
		} else {
			
			admin.setClave(use.get().getClave());
			
			if((co.isEmpty()) || (co.get().getId() == a.getId())) {
				if((us.isEmpty()) || (us.get().getId() == a.getId())) {
					
					Administradores ad = data.save(admin);
					System.out.println("guar ed");
					
					if (ad.equals(null)) {
						
						
						
						res = 1;
					}
					
				} else {
					res = 4;
				}
				
			} else {
				res = 3;
			}
		}
		
			
				

			

		
		
		return res;
	}
	
	public String TestCrypt(String contr)
	{
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	 
	    String encode1 = bCryptPasswordEncoder.encode(contr);
	    
	    return encode1;

	}


	@Override
	public int guardarm(Administradores a) {
		int res = 0;
		
		Administradores admin = new Administradores();
		
		admin.setNombre(a.getNombre());
		admin.setApellidos(a.getApellidos());
		admin.setCorreo(a.getCorreo());
		admin.setTipo(2);
		admin.setUsuario(a.getUsuario());
		admin.setClave(a.getClave());
		admin.setClaveco(a.getClaveco());
		
		String pass1 = admin.getClave();
		String pass2 = admin.getClaveco();
		
		List<Administradores> co = data.getByCorreo(admin.getCorreo());
		
		Optional<Administradores> us = data.getByUsuario(admin.getUsuario());
		
		if(pass1.equals(pass2)) {
			
			String coen = TestCrypt(a.getClave());
			admin.setClave(coen);
			
			if(co.isEmpty()) {
				if(us.isEmpty()) {
					
					Administradores ad = data.save(admin);
					System.out.println("guar ad");
					
					if (ad.equals(null)) {
						
						
						
						res = 1;
					}
					
				} else {
					res= 4;
				}
			} else {
				res = 3;
			}
			
			
			
			
			
			
		} else {
			res = 2;
		}
		
		
		return res;
	}


	@Override
	public int recuco(Administradores a, int id, String clave) {
		int res = 0;
		
		Administradores arc = new Administradores();
		
		String coen = TestCrypt(clave);
		
		arc.setId(a.getId());
		arc.setNombre(a.getNombre());
		arc.setApellidos(a.getApellidos());
		arc.setCorreo(a.getCorreo());
		arc.setUsuario(a.getUsuario());
		arc.setTipo(a.getTipo());
		arc.setClave(coen);
		arc.setAuthority(a.getAuthority());
		
		Administradores ad = data.save(arc);
		System.out.println("guar ed");
		
		if (ad.equals(null)) {
			
			res = 1;
		}
		
		return 0;
	}


	@Override
	public List<Administradores> buscador(String usu, int ti) {
		return (List<Administradores>)data.FindByUsuarioAndTipo(usu, ti);
	}

}
