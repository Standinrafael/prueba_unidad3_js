package ec.edu.uce.service;

import java.time.LocalDateTime;

public interface IGestorService {

	void insertarProductoStock(Integer stock);
	
	void realizarVenta(String codigoBarras,Integer stock, String cedulaCliente, Integer numeroVenta);
	
	void consultarStock(String codigoBarras, String nombre, Integer stock);
	
	void ReporteVentas(LocalDateTime fecha, String categoria, Integer cantidad);
}
