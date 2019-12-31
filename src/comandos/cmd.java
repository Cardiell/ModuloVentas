package comandos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Cardiell
 */
public class cmd {
    
    public String User()
    {
        String comando = "cmd /c echo %username%";
        String salida="denegado";
         try{
            // Ejecucion Basica del Comando
            Process proceso = Runtime.getRuntime().exec(comando);
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);
             
            //Si el comando tiene una salida la mostramos
            if((salida=stdInput.readLine()) != null)
                return salida;
        }catch (IOException e) {
                System.out.println("Excepción: "+e);
                e.printStackTrace();
        }
         return salida;
    }
    
    public String Ip()
    {
        String salida = null;
        String aux;
         String comando = "cmd /c ipconfig";
 
        try{
 
            // Ejecucion Basica del Comando
            Process proceso = Runtime.getRuntime().exec(comando);
 
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);
 
            //Si el comando tiene una salida la mostramos
            if((salida=stdInput.readLine()) != null){
                salida=stdInput.readLine().trim();
               
                for(int i=0; i<salida.length(); i++)
                {
                    if(salida.charAt(i)==':')
                    {
                        aux = salida.substring(i+2,salida.length());
                                        salida=aux;

                    }
                }    
                   return salida;
            }else{
                System.out.println("No se a producido ninguna salida");
            }
        }catch (IOException e) {
                System.out.println("Excepción: ");
                e.printStackTrace();
        }
        return"nada";
    }
}
