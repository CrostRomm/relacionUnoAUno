package Validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Cristian Romero
 * @author NATHALY
 */
@FacesValidator(value = "vNumero")
public class ValidacionNumero implements Validator{
    /**
    * Sobreescritura de un metodo de validacion para la edad
    * @param context
    * @param component
    * @param value
    * @throws ValidatorException 
    */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        try{
            int edad = Integer.parseInt(texto);
        }catch(NumberFormatException e){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Ojo", "Digite solo numeros");
            throw new ValidatorException(msg);
        }
    }
    
}
