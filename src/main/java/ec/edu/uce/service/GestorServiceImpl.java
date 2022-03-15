package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.DetalleVenta;
import ec.edu.uce.modelo.Producto;
import ec.edu.uce.modelo.Venta;

@Service
public class GestorServiceImpl implements IGestorService {

	private static final Logger LOG = LoggerFactory.getLogger(GestorServiceImpl.class);
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IDetalleVentaService detalleService;
	
	@Override
	@Transactional
	public void insertarProductoStock(Integer stock) {
		// TODO Auto-generated method stub
		
		Producto producto= this.productoService.buscarProductoStock(stock);
		
		if (producto== null) {
			this.productoService.insertarProducto(producto);
		}
		
		else {
			producto.setStock(producto.getStock()+stock);
			this.productoService.actualizarProducto(producto);
		}
	}

	@Override
	@Transactional
	public void realizarVenta(String codigoBarras, Integer stock, String cedulaCliente, Integer numeroVenta) {
		// TODO Auto-generated method stub
		Venta venta= new Venta();
		try {
			Producto producto=this.productoService.buscarProductoBarra(codigoBarras);
			
			if (producto.getStock() !=null) {
				
				if(numeroVenta<=producto.getStock()) {
					producto.setStock(producto.getStock()-numeroVenta);
					this.productoService.actualizarProducto(producto);
				}
				else {
					LOG.info("Stock insuficiente");
				}
			}
			else {
				try {
					
					LOG.info("Operacion permitida");
				}catch(NullPointerException e) {
					LOG.warn("No hay suficiente stock");
				}
				
			}
			
			
		}catch(NullPointerException e) {
			LOG.warn("No hay producto");
		}
		
	
		
		venta.setCedulaCliente(cedulaCliente);
		venta.setNumero(numeroVenta);
		
		this.ventaService.insertarVenta(venta);
	}

	@Override
	
	public void consultarStock(String codigoBarras, String nombre, Integer stock) {
		// TODO Auto-generated method stub
		Producto producto2= new Producto();
		Producto producto= this.productoService.buscarProductoBarra(codigoBarras);
		if (producto!=null) {
			producto2=this.productoService.buscarProductoPorTresParametros(codigoBarras, nombre, stock); 
		}
		
		LOG.info(producto2.toString());
	}

	@Override
	@Transactional
	public void ReporteVentas(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		List<Venta>listaVenta=this.ventaService.buscarPorFecha(fecha);
		List<Producto>listaProducto=this.productoService.traerProductos();
		List<DetalleVenta>listaDetalle=this.detalleService.traerTodo();
		
		Stream<Producto>listaFiltrada=listaProducto.stream().filter(producto-> producto.getNombre().equals(categoria));
		Stream<DetalleVenta>listaFiltrada2=listaDetalle.stream().filter(detalle->detalle.getCantidad()>cantidad);
		
		
		
	}

}
