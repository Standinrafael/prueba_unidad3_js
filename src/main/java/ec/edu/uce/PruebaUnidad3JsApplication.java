package ec.edu.uce;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Producto;
import ec.edu.uce.service.IDetalleVentaService;
import ec.edu.uce.service.IProductoService;
import ec.edu.uce.service.IVentaService;

@SpringBootApplication
public class PruebaUnidad3JsApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(PruebaUnidad3JsApplication.class);
	
	private IProductoService productoService;
	
	private IDetalleVentaService detalleService;
	
	private IVentaService ventaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3JsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Producto producto1= new Producto();
		producto1.setCategoria("lacteos");
		producto1.setNombre("queso");
		producto1.setPrecio(new BigDecimal("1.20"));
		producto1.setStock(10);
		producto1.setCodigoBarras("12345");
		
		Producto producto2= new Producto();
		producto2.setCategoria("vegetales");
		producto2.setNombre("lechuga");
		producto2.setPrecio(new BigDecimal("0.70"));
		producto2.setStock(5);
		producto2.setCodigoBarras("67890");
		
		Producto producto3= new Producto();
		producto3.setCategoria("frutas");
		producto3.setNombre("manzana");
		producto3.setPrecio(new BigDecimal("0.30"));
		producto3.setStock(10);
		producto3.setCodigoBarras("11111");
		
		this.productoService.insertarProducto(producto3);
		this.productoService.insertarProducto(producto2);
		this.productoService.insertarProducto(producto1);
		
		
		//Buscar producto por codigo de barra
		this.productoService.buscarProductoBarra("67890");
	}

}
