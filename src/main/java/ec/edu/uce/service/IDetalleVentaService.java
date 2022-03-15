package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.DetalleVenta;

public interface IDetalleVentaService {

	void insertarDetalle(DetalleVenta detalle);
	void actualizarDetalle(DetalleVenta detalle);
	DetalleVenta buscarDetalle(Integer id);
	void borrarDetalle(Integer id);
	List<DetalleVenta> traerTodo();
}
