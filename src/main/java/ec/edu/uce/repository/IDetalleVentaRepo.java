package ec.edu.uce.repository;

import ec.edu.uce.modelo.DetalleVenta;

public interface IDetalleVentaRepo {

	void insertarDetalle(DetalleVenta detalle);
	void actualizarDetalle(DetalleVenta detalle);
	DetalleVenta buscarDetalle(Integer id);
	void borrarDetalle(Integer id);
	
}
