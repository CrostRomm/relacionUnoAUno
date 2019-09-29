package Validation;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 * @author Cristian Romero
 * @author NATHALY
 * @version 1.0
 */
@FacesValidator(value = "vTexto")
public class ValidacionTexto implements Validator{
    /**
     * Sobreescritura de un metodo para validar caracteres alfabeticos
     * @param context
     * @param component
     * @param value
     * @throws ValidatorException 
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        boolean alfa = Pattern.matches("^[a-zA-Z]*$", texto);
        if(alfa!=true){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Ojo", "solo digite letras");
            throw new ValidatorException(msg);
        }
    }
    
}
