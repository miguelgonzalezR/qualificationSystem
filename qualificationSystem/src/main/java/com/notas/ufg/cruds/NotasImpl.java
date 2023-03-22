package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.ufg.models.Notas;
import com.notas.ufg.models.Alumnos;
import com.notas.ufg.models.Materia;

import com.notas.ufg.repocitorios.INotas;
import com.notas.ufg.repocitorios.IMateriasRepo;
import com.notas.ufg.repocitorios.IAlumnosRepo;


@Service
public class NotasImpl implements INotasSer{
	
	@Autowired
	private INotas notas;
	
	@Autowired
	private IMateriasRepo mate;
	
	@Autowired
	private IAlumnosRepo alm;

	@Override
	public List<Notas> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notas> verPorMaterias(int id) {
		
		Optional<Materia> maid = mate.findById(id);
		
		
		return (List<Notas>)notas.getByIdma(maid);
	}

	@Override
	public Optional<Notas> listarId(int id) {
		return notas.findById(id);
	}

	@Override
	public int guardar(Notas a, String ca) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int EditarNo(Notas n, int id, String ca) {
		
		Notas no = new Notas();
		
		no.setTareap1(n.getTareap1());
		no.setExap1(n.getExap1());
		
		Optional<Notas> noc = notas.findById(id);
		
		no.setTareap2(noc.get().getTareap2());
		no.setExap2(noc.get().getExap2());
		no.setTareap3(noc.get().getTareap3());
		no.setExap3(noc.get().getExap3());
		no.setTareap4(noc.get().getTareap4());
		no.setExap4(noc.get().getExap4());
		no.setAlcar(ca);
		
		no.setIdal(noc.get().getIdal());
		no.setIdma(noc.get().getIdma());
		no.setIdno(n.getIdno());
		
		double notasf = ((no.getTareap1()*0.1) + (no.getExap1()*0.15) + (no.getTareap2() * 0.1) + (no.getExap2() * 0.15) + (no.getTareap3() * 0.1)  + (no.getExap3() * 0.15) + (no.getTareap4() * 0.1 ) + (no.getExap4() * 0.15) );
		
		no.setNotaf(notasf);
		
		int res = 0;
		
		Notas ng = notas.save(no);
		if (ng.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int EditarNo2(Notas n, int id, String ca) {
		
		Notas no = new Notas();
		
		no.setTareap2(n.getTareap2());
		no.setExap2(n.getExap2());
		
		Optional<Notas> noc = notas.findById(id);
		
		no.setTareap1(noc.get().getTareap1());
		no.setExap1(noc.get().getExap1());
		
		no.setTareap3(noc.get().getTareap3());
		no.setExap3(noc.get().getExap3());
		no.setTareap4(noc.get().getTareap4());
		no.setExap4(noc.get().getExap4());
		
		no.setIdal(noc.get().getIdal());
		no.setIdma(noc.get().getIdma());
		no.setIdno(n.getIdno());
		no.setAlcar(ca);
		
		System.out.println(no.getExap2());
		
		
		double notasf = ((no.getTareap1()*0.1) + (no.getExap1()*0.15) + (no.getTareap2() * 0.1) + (no.getExap2() * 0.15) + (no.getTareap3() * 0.1)  + (no.getExap3() * 0.15) + (no.getTareap4() * 0.1 ) + (no.getExap4() * 0.15) );
		
		no.setNotaf(notasf);
		
		int res = 0;
		
		Notas ng = notas.save(no);
		if (ng.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public int EditarNo3(Notas n, int id, String ca) {
		Notas no = new Notas();
		
		no.setTareap3(n.getTareap3());
		no.setExap3(n.getExap3());
		
		Optional<Notas> noc = notas.findById(id);
		
		no.setTareap1(noc.get().getTareap1());
		no.setExap1(noc.get().getExap1());
		
		no.setTareap2(noc.get().getTareap2());
		no.setExap2(noc.get().getExap2());
		
		no.setTareap4(noc.get().getTareap4());
		no.setExap4(noc.get().getExap4());
		
		no.setIdal(noc.get().getIdal());
		no.setIdma(noc.get().getIdma());
		no.setIdno(n.getIdno());
		no.setAlcar(ca);
		
		double notasf = ((no.getTareap1()*0.1) + (no.getExap1()*0.15) + (no.getTareap2() * 0.1) + (no.getExap2() * 0.15) + (no.getTareap3() * 0.1)  + (no.getExap3() * 0.15) + (no.getTareap4() * 0.1 ) + (no.getExap4() * 0.15) );
		
		no.setNotaf(notasf);
		
		int res = 0;
		
		Notas ng = notas.save(no);
		if (ng.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public int EditarNo4(Notas n, int id, String ca) {
		
		Notas no = new Notas();
		
		no.setTareap4(n.getTareap4());
		no.setExap4(n.getExap4());
		
		Optional<Notas> noc = notas.findById(id);
		
		no.setTareap1(noc.get().getTareap1());
		no.setExap1(noc.get().getExap1());
		
		no.setTareap2(noc.get().getTareap2());
		no.setExap2(noc.get().getExap2());
		
		no.setTareap3(noc.get().getTareap3());
		no.setExap3(noc.get().getExap3());
		no.setAlcar(ca);
		
		
		
		no.setIdal(noc.get().getIdal());
		no.setIdma(noc.get().getIdma());
		no.setIdno(n.getIdno());
		
		double notasf = ((no.getTareap1()*0.1) + (no.getExap1()*0.15) + (no.getTareap2() * 0.1) + (no.getExap2() * 0.15) + (no.getTareap3() * 0.1)  + (no.getExap3() * 0.15) + (no.getTareap4() * 0.1 ) + (no.getExap4() * 0.15) );
		
		no.setNotaf(notasf);
		
		int res = 0;
		
		Notas ng = notas.save(no);
		if (ng.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public void guardart(int idm, int ida, String ca) {
		Notas no = new Notas();
		
		Optional<Materia> mater = mate.findById(idm);
		
		Optional<Alumnos> al = alm.findById(ida);
		
		Materia m = new Materia();
		
		Alumnos a = new Alumnos();
		
		m.setIdgr(mater.get().getIdgr());
		m.setIdma(mater.get().getIdma());
		m.setIdmaes(mater.get().getIdmaes());
		m.setNombre(mater.get().getNombre());
		
		a.setIdal(al.get().getIdal());
		a.setCarnet(al.get().getCarnet());
		a.setNombre(al.get().getNombre());
		a.setApellido(al.get().getApellido());
		a.setCorreo(al.get().getCorreo());
		a.setUsuario(al.get().getUsuario());
		a.setClave(al.get().getClave());
		a.setIdgrado(al.get().getIdgrado());
		
		no.setAlcar(ca);
		
		
		no.setTareap1(0);
		no.setExap1(0);
		no.setTareap2(0);
		no.setExap2(0);
		no.setTareap3(0);
		no.setExap3(0);
		no.setTareap4(0);
		no.setExap4(0);
		no.setIdma(m);
		no.setIdal(a);
		
		int res = 0;
		
		Notas ng = notas.save(no);
		if (ng.equals(null)) {
			res = 1;
		}
		
	}

	@Override
	public List<Notas> buscar(int ma,String car, int al) {
		
		Optional<Materia> maid = mate.findById(ma);
		
		Materia mat = maid.get();
		
		return (List<Notas>)notas.FindByAlcarAndIdma(car, mat);
	}

}
