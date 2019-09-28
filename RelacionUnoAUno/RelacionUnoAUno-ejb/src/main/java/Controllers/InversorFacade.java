package Controllers;

import Default.AbstractFacade;
import Intefaces.InversorFacadeLocal;
import Entity.Inversor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * @author Cristian Romero
 * @version 1.0
 */
@Stateless
public class InversorFacade extends AbstractFacade<Inversor> implements InversorFacadeLocal {
    /**
     * Declaracion de la conexion Entity Manager
     */
    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;
    /**
     * Inicialización del Entity Manager
     * @return 
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    /**
     * Inicio
     */
    public InversorFacade() {
        super(Inversor.class);
    }

    @Override
    public List<Inversor> listarInversor() {
        TypedQuery<Inversor> consulta = em.createNamedQuery("listadoInversor", Inversor.class);
        return consulta.getResultList(); 
    }
    
}
