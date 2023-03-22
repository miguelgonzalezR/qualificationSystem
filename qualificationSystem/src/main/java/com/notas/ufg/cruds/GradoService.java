package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.ufg.models.Grados;
import com.notas.ufg.repocitorios.IGradoR;

@Service
public class GradoService implements IgradoService{
	

	@Autowired
	private IGradoR data;
	
	@Override
	public List<Grados> listar() {
		return (List<Grados>)data.findAll();
	}
	

	@Override
	public Optional<Grados> listarId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int guardar(Grados g) {
		
		int res = 0;
		
		
		
		Grados gr = data.save(g);
		if(gr.equals(null)) {
			res=1;
		}
		
		return 0;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
		
	}


	@Override
	public List<Grados> buscar(String bus) {
		return (List<Grados>)data.FindByGradoAndSeccion(bus);
	}

}
