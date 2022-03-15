package ec.edu.uce.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="detalle_venta")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_detalle_venta")
	@SequenceGenerator(name="seq_detalle_venta",sequenceName="seq_detalle_venta",allocationSize=1)
	@Column(name="deva_id")
	private Integer id;
	
	@Column(name="deva_cantidad")
	private Integer cantidad;
	
	@Column(name="deva_precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name="deva_subtotal")
	private BigDecimal Subtotal;
	
	@ManyToOne
	@JoinColumn(name="vent_id")
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name="prod_id")
	private Producto producto;

	
	//Metodos Get y Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		Subtotal = subtotal;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetalleVenta [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", Subtotal=" + Subtotal + ", venta=" + venta + ", producto=" + producto + "]";
	}
	
	
}	
