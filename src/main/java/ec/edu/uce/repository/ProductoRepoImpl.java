package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarProducto(Producto poducto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(poducto);
	}

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
		 TypedQuery<Producto> miTypedQuery = (TypedQuery<Producto>) this.entityManager
				.createQuery("select p from Producto p where p.codigoBarras=: codigoBarra", Producto.class);
		miTypedQuery.setParameter("codigoBarra", codigoBarra);
		return miTypedQuery.getSingleResult();
	}

}
