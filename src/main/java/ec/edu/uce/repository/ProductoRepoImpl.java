package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {

	private static final Logger LOG = LoggerFactory.getLogger(ProductoRepoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarProducto(Producto poducto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(poducto);
	}
	
	@Transactional(value=TxType.MANDATORY)
	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public Producto buscarProducto(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void borrarProducto(Integer id) {
		// TODO Auto-generated method stub
		Producto borrarProducto= this.buscarProducto(id);
		this.entityManager.remove(borrarProducto);
		
	}

	@Override
	public Producto buscarProductoBarra(String codigoBarra) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Producto> miTypedQuery = (TypedQuery<Producto>) this.entityManager
					.createQuery("select p from Producto p,DetalleVenta h WHERE h=p and p.codigoBarras=: codigoBarra", Producto.class);
			miTypedQuery.setParameter("codigoBarra", codigoBarra);
			return miTypedQuery.getSingleResult();
		}catch(NoResultException e) {
			LOG.warn("No existe el producto");
			return null;
		}
		
		 
	}

	@Override
	public Producto buscarProductoStock(Integer stock) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> miTypedQuery = (TypedQuery<Producto>) this.entityManager
				.createQuery("select p from Producto p,DetalleVenta h WHERE h=p and p.stock=: stock", Producto.class);
		miTypedQuery.setParameter("stock", stock);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public List<Producto> traerProductos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery =(TypedQuery<Producto>) this.entityManager
				.createQuery("select p from Producto p,DetalleVenta h WHERE h=p ", Producto.class);

 
		return   myQuery.getResultList();
	}

	@Override
	public Producto buscarProductoPorTresParametros(String barra, String nombre, Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> miTypedQuery = (TypedQuery<Producto>) this.entityManager
				.createQuery("select p from Producto p,DetalleVenta h WHERE h=p and p.codigoBarras=: barra and p.nombre=: nombre and p.stock=: cantidad", Producto.class);
		miTypedQuery.setParameter("barra",barra );
		miTypedQuery.setParameter("nombre", nombre);
		miTypedQuery.setParameter("cantidad", cantidad);
		return miTypedQuery.getSingleResult();
	}

	

}
