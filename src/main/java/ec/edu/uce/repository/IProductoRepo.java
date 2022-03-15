package ec.edu.uce.repository;

import ec.edu.uce.modelo.Producto;

public interface IProductoRepo {

	void insertarProducto(Producto poducto);
	void actualizarProducto(Producto producto);
	Producto buscarProducto(Integer id);
	void borrarProducto(Integer id);
	
	Producto buscarProductoBarra(String codigoBarra);

}
