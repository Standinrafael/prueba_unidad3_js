package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Producto;
import ec.edu.uce.repository.IProductoRepo;
@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo productoRepo;
	
	@Override
	public void insertarProducto(Producto poducto) {
		// TODO Auto-generated method stub
		this.productoRepo.insertarProducto(poducto);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.actualizarProducto(producto);
	}

	@Override
	public Producto buscarProducto(Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProducto(id);
	}

	@Override
	public void borrarProducto(Integer id) {
		// TODO Auto-generated method stub
		this.productoRepo.borrarProducto(id);
	}

	@Override
	public Producto buscarProductoBarra(String codigoBarra) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProductoBarra(codigoBarra);
	}

}
