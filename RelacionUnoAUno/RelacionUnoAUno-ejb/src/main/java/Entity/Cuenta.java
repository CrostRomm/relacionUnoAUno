package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Cristian Romero
 * @version 1.0
 */
@NamedQueries({
    @NamedQuery(name = "listadoCuenta",query = "SELECT c FROM Cuenta c")
})
@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable{
    /**
     * Identificador de la cuenta
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    /**
     * Numero de la cuenta
     */
    private String numero;
    /**
     * Llave foranea del inversor
     */
    @OneToOne
    @JoinColumn(name="id_inversor")
    private Inversor inversor;
    /**
     * Constructor
     */
    public Cuenta() {
    }
    /**
     * Constructor
     * @param numero
     */
    public Cuenta(String numero) {
        this.numero = numero;
    }
    /**
     * Get del identificador
     * @return int
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
     * Get del numero de cuenta
     * @return String
     */
    public String getNumero() {
        return numero;
    }
    /**
     * Set del numero de cuenta
     * @param numero 
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    /**
     * Get de llave foranea
     * @return Inversor 
     */
    public Inversor getInversor() {
        return inversor;
    }
    /**
     * Set de llave foranea
     * @param inversor 
     */
    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }
    
}
