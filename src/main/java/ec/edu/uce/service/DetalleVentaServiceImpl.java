package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.DetalleVenta;
import ec.edu.uce.repository.IDetalleVentaRepo;
@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {
	
	@Autowired
	private IDetalleVentaRepo detalleRepo;
	
	@Override
	public void insertarDetalle(DetalleVenta detalle) {
		// TODO Auto-generated method stub
		this.detalleRepo.insertarDetalle(detalle);
	}

	@Override
	public void actualizarDetalle(DetalleVenta detalle) {
		// TODO Auto-generated method stub
		this.detalleRepo.actualizarDetalle(detalle);
	}

	@Override
	public DetalleVenta buscarDetalle(Integer id) {
		// TODO Auto-generated method stub
		return this.detalleRepo.buscarDetalle(id);
	}

	@Override
	public void borrarDetalle(Integer id) {
		// TODO Auto-generated method stub
		this.detalleRepo.borrarDetalle(id);
	}

}
