package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.DetalleVenta;

public interface IDetalleVentaRepo {

	void insertarDetalle(DetalleVenta detalle);
	void actualizarDetalle(DetalleVenta detalle);
	DetalleVenta buscarDetalle(Integer id);
	void borrarDetalle(Integer id);
	
	List<DetalleVenta> traerTodo();
	
}
