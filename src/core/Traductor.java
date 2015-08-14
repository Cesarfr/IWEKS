
package core;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

/**
 *
 * @author CesarH
 */
public class Traductor {

    String traducida = "";

    public String traduce(String palabra, String inicio, String destino) {

        try {
            // Aplicamos las llaves de seguridad para acceder al servicio de Microsoft
            Translate.setClientId(ApiKeys.ID_CLIENT);
            Translate.setClientSecret(ApiKeys.API_SECRET);
            //System.err.println(inicio+" -> "+destino);
            // Validacion del sentido de traduccion
            if(inicio.equals("es") && destino.equals("en")){
                traducida = Translate.execute(palabra, Language.SPANISH, Language.ENGLISH);
            }else if(inicio.equals("en") && destino.equals("es")){
                traducida = Translate.execute(palabra, Language.ENGLISH, Language.SPANISH);
            }
            
            return traducida;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al traducir de tipo: " + e.getMessage());
            return null;
        }
    }
}
