package ec.edu.uce.service;

import ec.edu.uce.modelo.Venta;

public interface IVentaService {

	void insertarVenta(Venta venta);
	void actualizarVenta(Venta venta);
	Venta buscarVenta(Integer id);
	void borrarVenta(Integer id);
}
