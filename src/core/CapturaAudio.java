
package core;

import gui.Principal;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.*;

/**
 *
 * @author CesarH
 */
public class CapturaAudio extends ResultAdapter implements Runnable {

    static Recognizer recognizer;
    String palabra;
    Principal prin;
    public CapturaAudio(Principal prin) {
        this.prin = prin;
    }

    @Override
    public void resultAccepted(ResultEvent re) {
        try {

            Result res = (Result) (re.getSource());
            ResultToken tokens[] = res.getBestTokens();
            
            // Representacion de un grupo de palabras dictadas
            for (int i = 0; i < tokens.length; i++) {
                palabra = tokens[i].getSpokenText();
                //System.out.print(palabra + " ");
                this.prin.llenaOrigen(palabra + " ");
            }
            
            // Si hay una pausa se hace un salto de linea
            this.prin.llenaOrigen("\n");
            
            // Condicion para finalizar la captura de voz
            if (palabra.equals("Fintrad")) {
                // Cerrar conexion de espera de audio
                recognizer.forceFinalize(true);
                recognizer.deallocate();
                System.exit(0);
            }
        } catch (Exception ex) {
            System.err.println("Ha ocurrido un error en resultAccepted() de tipo " + ex.getMessage());
        }
    }

    public void iniciaAudio() {
        try {
            
            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            recognizer.allocate();
            
            // Lectura del archivo de gramatica
            File fl = new File("grammar.txt");
            FileReader grammar1 = new FileReader(fl.getAbsolutePath());
            
            // Carga del archivo de gramatica al reconocedor de voz
            RuleGrammar rg = recognizer.loadJSGF(grammar1);
            rg.setEnabled(true);
            
            recognizer.addResultListener(new CapturaAudio(prin));
            
            System.out.println("Start engine");
            recognizer.commitChanges();
            recognizer.requestFocus();
            
            //recognizer.resume();
        } catch (Exception e) {
            System.out.println("Ocurrio un error en CapturaAudio de tipo: " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void run() {
        this.iniciaAudio();
    }
}
