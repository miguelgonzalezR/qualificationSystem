package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.ufg.models.Administradores;
import com.notas.ufg.models.Alumnos;
import com.notas.ufg.models.Materia;
import com.notas.ufg.repocitorios.IMateriasRepo;

@Service
public class MateriasImpl implements IMateSer{
	
	@Autowired
	private IMateriasRepo data;

	@Override
	public List<Materia> listar() {
		return (List<Materia>)data.findAll();
	}

	@Override
	public Optional<Materia> listarId(int id) {
		return data.findById(id);
	} 

	@Override
	public int guardar(Materia a) {
		int res = 0;
		
		System.out.println(a.getIdmaes().getUsuario());
		
		Materia ma = new Materia();
		
		ma.setNombre(a.getNombre());
		ma.setIdgr(a.getIdgr());
		ma.setIdmaes(a.getIdmaes());
		
		Materia mate = data.save(ma);
		if(mate.equals(null)) {
			res=1;
		}
		
		return res;
	}

	@Override
	public int EditarAl(Materia a, int id) {
		
		Materia m = new Materia();
		
		Optional<Materia> idm = data.findById(id);
		
		m.setIdma(id);
		m.setNombre(a.getNombre());
		m.setIdmaes(a.getIdmaes());
		m.setIdgr(idm.get().getIdgr());
		
		
		int res = 0;
		Materia mag = data.save(m);
		if (mag.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
		
	}

	@Override
	public List<Materia> Buscar(String bus) {
		return (List<Materia>)data.FindByNombre(bus);
	}


}
