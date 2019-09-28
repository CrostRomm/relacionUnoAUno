package Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Cristian Romero
 * @version 1.0
 */
@NamedQueries({
    @NamedQuery(name = "listadoInversor",query = "SELECT inv FROM Inversor inv")
})
@Entity
@Table(name="inversor")
public class Inversor implements Serializable{
    /**
     * Campo identificadot de la tabla
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    /**
     * Campo nombre del inversor
     */
    private String nombre;
    /**
     * Declaracion del objeto
     */
    @OneToOne(mappedBy = "inversor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cuenta cuenta;
    /**
     * Constructor
     */
    public Inversor() {
    }
    /**
     * Constructor
     * @param nombre 
     */
    public Inversor(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Get del identificador
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * Set del identificador
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Get del nombre del inversor
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Set nombre del inversor
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Get del objeto cuenta
     * @return Cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }
    /**
     * Set del objeto cuenta
     * @param cuenta 
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
}
