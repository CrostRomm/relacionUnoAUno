package Intefaces;

import Entity.Inversor;
import java.util.List;
import javax.ejb.Local;
/**
 * @author Cristian Romero
 * @version 1.0
 */
@Local
public interface InversorFacadeLocal {
    /**
     * Metodo crear inversor
     * @param inversor 
     */
    void create(Inversor inversor);
    /**
     * Metodo editar inversor
     * @param inversor 
     */
    void edit(Inversor inversor);
    /**
     * Metodo eliminar inversor
     * @param inversor 
     */
    void remove(Inversor inversor);
    /**
     * Metodo buscar inversor 
     * @param id
     * @return Inversor
     */
    Inversor find(Object id);
    /**
     * Metodo buscar todos los inversores
     * @return Lista de inversores
     */
    List<Inversor> findAll();
    /**
     * Metodo busqueda en un rango
     * @param range
     * @return Lista de inversores
     */
    List<Inversor> findRange(int[] range);
    /**
     * Metodo contar
     * @return entero
     */
    int count();
    /**
     * Metodo que lista todos los inversores
     * @return Inversores
     */
    List<Inversor> listarInversor();
}
