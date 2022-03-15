package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Producto;

public interface IProductoService {

	void insertarProducto(Producto poducto);
	void actualizarProducto(Producto producto);
	Producto buscarProducto(Integer id);
	void borrarProducto(Integer id);
	Producto buscarProductoBarra(String codigoBarra);
	Producto buscarProductoStock(Integer stock);
	List<Producto> traerProductos();
	Producto buscarProductoPorTresParametros(String barra, String nombre, Integer cantidad);
}
