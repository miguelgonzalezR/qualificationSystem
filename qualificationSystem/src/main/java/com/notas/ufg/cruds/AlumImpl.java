package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.notas.ufg.models.Alumnos;
import com.notas.ufg.models.Grados;
import com.notas.ufg.repocitorios.IAlumnosRepo;
import com.notas.ufg.repocitorios.IvalcA;


@Service
public class AlumImpl implements IAlumSer{
	
	@Autowired
	private IAlumnosRepo data;
	
	@Autowired
	private IvalcA val;

	
	@Override
	public List<Alumnos> listar() {
		return (List<Alumnos>)data.findAll();
	}


	@Override
	public Optional<Alumnos> listarId(int id) {
		return data.findById(id);
	}


	@Override
	public int guardar(Alumnos a) {
		int res = 0;
		
		Alumnos alf = new Alumnos();
		
		alf.setCarnet(a.getCarnet());
		alf.setNombre(a.getNombre());
		alf.setApellido(a.getApellido());
		alf.setUsuario(a.getUsuario());
		alf.setCorreo(a.getCorreo());
		
		String coen = TestCrypt(a.getClave());
		alf.setClave(coen);
		alf.setIdgrado(a.getIdgrado());
		
		List<Alumnos> care = val.getByCarnet(a.getCarnet());
		
		List<Alumnos> corr = val.getByCorreo(a.getCorreo());
		
		List<Alumnos> usu = val.getByUsuario(a.getUsuario());
		
		if(care.isEmpty()) {
			
			if(corr.isEmpty()) {
				
				if(usu.isEmpty()) {
					Alumnos al = data.save(alf);
					if (al.equals(null)) {
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
		

		
		
		

		
		return res;

	}


	@Override
	public void eliminar(int id) {
		data.deleteById(id);
		
	}
	
	
	public String TestCrypt(String contr)
	{
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	 
	    String encode1 = bCryptPasswordEncoder.encode(contr);
	    
	    return encode1;

	}


	@Override
	public int EditarAl(Alumnos a, int id) {
		Alumnos alf = new Alumnos();

		alf.setIdal(a.getIdal());
		alf.setCarnet(a.getCarnet());
		alf.setNombre(a.getNombre());
		alf.setApellido(a.getApellido());
		alf.setUsuario(a.getUsuario());
		alf.setCorreo(a.getCorreo());
		alf.setIdgrado(a.getIdgrado());
		
		Optional<Alumnos> alm = data.findById(id);
		
		
		alf.setClave(alm.get().getClave());
		
		int res = 0;
		Alumnos al = data.save(alf);
		if (al.equals(null)) {
			res = 1;
		}

		return 0;
		
		
	}


	@Override
	public List<Alumnos> buscar(String bus) {
		return (List<Alumnos>)data.FindByUsuarioAndCarnetAndNombre(bus);
	}

	
}
