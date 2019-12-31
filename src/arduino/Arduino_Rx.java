/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduino;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author Cardiell
 */
public class Arduino_Rx{

    String g;
SerialPortEventListener   listener = new SerialPortEventListener(){
    @Override
    public void serialEvent(SerialPortEvent spe) {
        try {
            if(ino.isMessageAvailable())
            {
                g=ino.printMessage();
                System.out.println(g);
            }
        } catch (SerialPortException ex) {
            Logger.getLogger(Arduino_Rx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArduinoException ex) {
            Logger.getLogger(Arduino_Rx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
};
PanamaHitek_Arduino ino = new PanamaHitek_Arduino();



 public Arduino_Rx()
 {                 
   Thread hilo = new Thread();
   hilo.start();
        try {
            ino.arduinoRX("COM3",9600,listener);
        } catch (ArduinoException ex) {
            Logger.getLogger(Arduino_Rx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(Arduino_Rx.class.getName()).log(Level.SEVERE, null, ex);
        }
      
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            new Arduino_Rx();
    }


}
