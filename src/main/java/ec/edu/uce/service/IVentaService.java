package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Venta;

public interface IVentaService {

	void insertarVenta(Venta venta);
	void actualizarVenta(Venta venta);
	Venta buscarVenta(Integer id);
	void borrarVenta(Integer id);
	List<Venta> buscarPorFecha(LocalDateTime fecha);
}
