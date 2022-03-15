package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Venta;
@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(venta);
	}

	@Override
	public void actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(venta);
	}

	@Override
	public Venta buscarVenta(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Venta.class, id);
	}

	@Override
	public void borrarVenta(Integer id) {
		// TODO Auto-generated method stub
		Venta borrarVenta=this.buscarVenta(id);
		this.entityManager.remove(borrarVenta);
	}

}
