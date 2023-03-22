package com.notas.ufg.cruds;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.ufg.models.Grados;
import com.notas.ufg.models.Periodo;
import com.notas.ufg.repocitorios.IPeriodo;

@Service
public class PeriodoImpl implements IPeriodoSer{
	
	@Autowired
	private IPeriodo data;

	@Override
	public List<Periodo> listar() {
		return (List<Periodo>)data.findAll();
	}

	@Override
	public Optional<Periodo> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int guardar(Periodo p) {
		int res = 0;
		
		Periodo per = new Periodo();
		
		Optional<Periodo> id = data.findById(p.getIdpr());
		
		per.setIdpr(p.getIdpr());
		per.setNombre(p.getNombre());
		per.setFechain(id.get().getFechain());
		per.setFechafi(id.get().getFechafi());
		
		System.out.println(per.getFechafi());
		
		Date fi = per.getFechain();
		Date ff = per.getFechafi();
		
		if(ff.after(fi)) {
			
			Periodo pe = data.save(per);
			if(pe.equals(null)) {
				res=1;
			}
			
		} else {
			res = 0;
		}
		
		
		
		
		return res;
	}

}
