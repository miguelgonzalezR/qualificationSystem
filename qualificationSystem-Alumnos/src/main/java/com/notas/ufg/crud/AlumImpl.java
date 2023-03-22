package com.notas.ufg.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.notas.ufg.alumnos.models.Alumno;
import com.notas.ufg.repocitorios.IAlum;

@Service
public class AlumImpl implements IAlumSer{
	
	@Autowired
	private IAlum per;

	@Override
	public int EditarAl(Alumno a, int id) {
		int res = 0;
		
		Alumno alper = new Alumno();
		
		alper.setIdal(a.getIdal());
		alper.setNombre(a.getNombre());
		alper.setApellido(a.getApellido());
		alper.setUsuario(a.getUsuario());
		alper.setCorreo(a.getCorreo());
		alper.setClave(a.getClave());
		
		
		alper.setClaveco(a.getClaveco());
		
		
		
		String pass1 = a.getClave();
		String pass2 = a.getClaveco();
		
		Optional<Alumno> ida = per.findById(id);
		
		alper.setCarnet(ida.get().getCarnet());
		
		alper.setIdgrado(ida.get().getIdgrado());
		
		Optional<Alumno> co = per.getByCorreo(a.getCorreo());
		
		Optional<Alumno> us = per.getByUsuario(a.getUsuario());
		
		
		alper.setAuthority(ida.get().getAuthority());
		
		if((pass1.length() > 0) || (pass2.length() > 0)) {
			
			String coen = TestCrypt(a.getClave());
			alper.setClave(coen);
			
			if(pass1.equals(pass2)) {
				if((co.isEmpty()) || (co.get().getIdal() == a.getIdal())) {
					if((us.isEmpty()) || (us.get().getIdal() == a.getIdal())) {
						Alumno gup = per.save(alper);
						if (gup.equals(null)) {
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
			
			alper.setClave(ida.get().getClave());
			
			if((co.isEmpty()) || (co.get().getIdal() == a.getIdal())) {
				if((us.isEmpty()) || (us.get().getIdal() == a.getIdal())) {
					Alumno gup = per.save(alper);
					if (gup.equals(null)) {
						System.out.println();
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
	public int recu(Alumno a, int id, String clave) {
		
		int res=0;
		
		String coen = TestCrypt(clave);
		
		Alumno reco = new Alumno();
		
		reco.setIdal(a.getIdal());
		reco.setCarnet(a.getCarnet());
		reco.setNombre(a.getNombre());
		reco.setApellido(a.getApellido());
		reco.setUsuario(a.getUsuario());
		reco.setCorreo(a.getCorreo());
		reco.setClave(coen);
		reco.setIdgrado(a.getIdgrado());
		reco.setAuthority(a.getAuthority());
		
		Alumno gc = per.save(reco);
		
		if (gc.equals(null)) {

			res = 1;
		}
		
		
		return 0;
	}

}
