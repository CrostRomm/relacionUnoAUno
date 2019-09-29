package Controller;

import Entity.Cuenta;
import Entity.Inversor;
import Intefaces.CuentaFacadeLocal;
import Intefaces.InversorFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
/**
 * @author Cristian Romero
 * @version 1.0
 */
@ManagedBean(name="bean")
@ViewScoped
public class inicioController implements Serializable{
    /**
     constructor vacio
     */
    public inicioController() {
    }
    /**
     * Instancia de inversor
     */
    private Inversor inversorDelete;
    /**
     * Instancia de Cuenta
     */
    private Cuenta cuentaDelete;
    /**
     * codigo temporal
     */
    private int idTemporal;
    /**
     * nombre temporal
     */
    private String nombreTemporal;
    /**
     * Id cuenta
     */
    private int idCuenta;
    /**
     * Numero de cuenta
     */
    private String numero;
    /**
     * Id del dueño de cuenta
     */
    private int idForaneo;
    /**
     * Lista temporal de inversores
     */
    private  static List<Inversor> listaInversor = new ArrayList<>();
    /**
     * Lista temporal de cuentas
     */
    private static List<Cuenta> listaCuenta = new ArrayList<>();
    /**
     * Cadena de conexion ejb - web para inversor
     */
    @EJB
    InversorFacadeLocal ejbInversor;
    /**
     * Cade de conexion ejb-web para cuenta
     */
    @EJB
    CuentaFacadeLocal ejbCuenta;
    /**
     * Get de la lista de inversores
     * @return lista de inversores
     */
    public List<Inversor> getListaInversor(){
        return listaInversor;
    }
    /**
     * Set de la lista de inversores
     * @param listaInversor 
     */
    public void setListaInversor(List<Inversor> listaInversor) {
        this.listaInversor = listaInversor;
    }
    /**
     * Get del codigo temporal
     * @return int
     */
    public int getIdTemporal() {
        return idTemporal;
    }
    /**
     * Set del codigo temporal
     * @param idTemporal 
     */
    public void setIdTemporal(int idTemporal) {
        this.idTemporal = idTemporal;
    }
    /**
     * Get del nombre temporal
     * @return String
     */
    public String getNombreTemporal() {
        return nombreTemporal;
    }
    /**
     * Set del nombre temporal
     * @param nombreTemporal 
     */
    public void setNombreTemporal(String nombreTemporal) {
        this.nombreTemporal = nombreTemporal;
    }
    /**
     * Get de la lista temporal de cuentas
     * @return Lista de cuentas
     */
    public List<Cuenta> getListaCuenta() {
        return listaCuenta;
    }
    /**
     * Set de la lista temporal de cuentas
     * @param listaCuenta 
     */
    public void setListaCuenta(List<Cuenta> listaCuenta) {
        this.listaCuenta = listaCuenta;
    }
    /**
     * Get Id tempral de la cuenta
     * @return int
     */
    public int getIdCuenta() {
        return idCuenta;
    }
    /**
     * Set id temporal de la cuenta
     * @param idCuenta 
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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
     * Get del id foraneo de inversor
     * @return int 
     */
    public int getIdForaneo() {
        return idForaneo;
    }
    /**
     * Set del id foraneo de inversor
     * @param idForaneo 
     */
    public void setIdForaneo(int idForaneo) {
        this.idForaneo = idForaneo;
    }
    /**
     * Metodo que lista los inversores
     * @return Lista de inversores
     */
    public List<Inversor> listaInversor() {
        listaInversor = ejbInversor.listarInversor();
        
        for(Inversor i:listaInversor){
            setIdTemporal(i.getId());
            setNombreTemporal(i.getNombre());
        }
        this.nombreTemporal=null;
        return listaInversor;
    }
    /**
     * Get de inversor
     * @return Inversor
     */
    public Inversor getInversorDelete() {
        return inversorDelete;
    }
    /**
     * Set de Inversor
     * @param inversorDelete 
     */
    public void setInversorDelete(Inversor inversorDelete) {
        this.inversorDelete = inversorDelete;
    }
    /**
     * get de Cuenta
     * @return Cuenta
     */
    public Cuenta getCuentaDelete() {
        return cuentaDelete;
    }
    /**
     * Set de cuenta
     * @param cuentaDelete 
     */
    public void setCuentaDelete(Cuenta cuentaDelete) {
        this.cuentaDelete = cuentaDelete;
    }
    /**
     * Metodo que edita una fila 
     * @param event 
     */
    public void editarFilaInversor(RowEditEvent event) {
        Inversor i = (Inversor)event.getObject();
        ejbInversor.edit(i);
        this.nombreTemporal=null;
        FacesMessage msg = new FacesMessage("Se ha editado un inversor",((Inversor) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * Metodo que notifica cuando se cancela una edicion
     * @param event 
     */
    public void cancelarEdicionInversor(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion cancelada para ", ((Inversor) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * Metodo que notifica que celda se ha cambiado
     * @param event 
     */
    public void CeldaEditadaInversor(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha cambiado", ": " + oldValue + ", Por:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    /**
     * Metodo que lista las cuentas existentes
     * @return Lista de cuentas 
     */
    public List<Cuenta> listarCuentas(){
        listaCuenta = ejbCuenta.listaCuentas();
        for(Cuenta c:listaCuenta){
            setIdCuenta(c.getId());
            setNumero(c.getNumero());
            setIdForaneo(c.getInversor().getId());
        }
        this.nombreTemporal=null;
        return listaCuenta;
    }
    /**
     * Metodo que edita una fila
     * @param event 
     */
    public void editarFilaCuenta(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se ha editado un inversor", ((Inversor) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * Metodo que notifica cuando se cancela una edicion
     * @param event 
     */
    public void cancelarEdicionCuenta(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion cancelada para ", ((Inversor) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * Metodo que notifica que celda se ha cambiado
     * @param event 
     */
    public void CeldaEditadaCuenta(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha cambiado", ": " + oldValue + ", Por:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    public void agregarInversor(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String nombre = request.getParameter("formulario:ipt_nombre");
        String numer = request.getParameter("formulario:ipt_numeroCuenta");
        if(numer.equals("")){
            Inversor inv = new Inversor();
            inv.setNombre(nombre);
            ejbInversor.create(inv);
        }else{
            Inversor inv = new Inversor();
            inv.setNombre(nombre);
            ejbInversor.create(inv);
            Cuenta puenteCuenta = new Cuenta();
            puenteCuenta.setNumero(numer);
            puenteCuenta.setInversor(inv);
            ejbCuenta.create(puenteCuenta);
        }
    }
    public void eliminarInversor(Inversor i){
        ejbInversor.remove(i);
    }
    public void eliminarCuenta(Cuenta c){
        int i = 0;
        int a = 1;
        ejbCuenta.remove(c);
    }
}
