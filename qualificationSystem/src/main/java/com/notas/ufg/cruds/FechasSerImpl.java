package com.notas.ufg.cruds;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.ufg.models.Fechaed;
import com.notas.ufg.models.Periodo;
import com.notas.ufg.repocitorios.IFechasE;

@Service
public class FechasSerImpl implements IFechasSer{
	
	
	@Autowired
	private IFechasE data;

	@Override
	public int guardar(Fechaed p) {
		int res = 0;
		
		Fechaed per = new Fechaed();
		
		Optional<Fechaed> id = data.findById(p.getIdpr());
		
		per.setIdpr(p.getIdpr());
		per.setNombre(p.getNombre());
		per.setFechain(p.getFechain());
		per.setFechafi(p.getFechafi());
		
		System.out.println(per.getFechafi());
	
		
		if(per.getFechafi().isAfter(per.getFechain())) {
			Fechaed pe = data.save(per);
			if(pe.equals(null)) {
				res=1;
			}
			
		} else {
			res = 2;
		}
		
		
		
		
		return res;
	}

	@Override
	public List<Fechaed> listar() {
		return (List<Fechaed>)data.findAll();
	}

	@Override
	public Optional<Fechaed> listarId(int id) {
		return data.findById(id);
	}

}
