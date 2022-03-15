package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Venta;
import ec.edu.uce.repository.IVentaRepo;
@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepo ventaRepo;
	
	@Override
	public void insertarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepo.insertarVenta(venta);
	}

	@Override
	public void actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepo.actualizarVenta(venta);
	}

	@Override
	public Venta buscarVenta(Integer id) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscarVenta(id);
	}

	@Override
	public void borrarVenta(Integer id) {
		// TODO Auto-generated method stub
		this.ventaRepo.borrarVenta(id);
	}

}
