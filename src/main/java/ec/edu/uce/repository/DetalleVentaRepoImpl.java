package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.DetalleVenta;
import ec.edu.uce.modelo.Producto;
@Repository
@Transactional
public class DetalleVentaRepoImpl implements IDetalleVentaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarDetalle(DetalleVenta detalle) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalle);
	}

	@Override
	public void actualizarDetalle(DetalleVenta detalle) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalle);
	}

	@Override
	public DetalleVenta buscarDetalle(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(DetalleVenta.class, id);
	}

	@Override
	public void borrarDetalle(Integer id) {
		// TODO Auto-generated method stub
		DetalleVenta borrarDetalle=this.buscarDetalle(id);
		this.entityManager.remove(borrarDetalle);
	}

	@Override
	public List<DetalleVenta> traerTodo() {
		// TODO Auto-generated method stub
		TypedQuery<DetalleVenta> myQuery =(TypedQuery<DetalleVenta>) this.entityManager
				.createQuery("select d from DetalleVenta d ", DetalleVenta.class);

 
		return   myQuery.getResultList();
	}

}
