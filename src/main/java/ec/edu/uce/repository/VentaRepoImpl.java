package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Venta;


@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo {

	private static final Logger LOG = LoggerFactory.getLogger(VentaRepoImpl.class);
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

	@Override
	public List<Venta> buscarPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		TypedQuery<Venta> myQuery=this.entityManager.
				createQuery("select v from Venta v, DetalleVenta d WHERE d=v.factura AND v.fecha=:fecha",Venta.class);
		myQuery.setParameter("fecha", fecha);
		
		
		List<Venta> miLista=myQuery.getResultList();
		for(Venta detalle : miLista) {
			
			LOG.info(detalle.toString());
		}
		return miLista;
	}

}
