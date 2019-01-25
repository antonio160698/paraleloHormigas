/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColoniaHormigasTSP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anton_000
 */
public class stream {
    public ObjectInputStream lector;
    public ObjectOutputStream escritor;
    public void escritor_objectos(Object Objeto){
        try {
            escritor = new ObjectOutputStream(new FileOutputStream("datos.dat"));
            escritor.writeObject(Objeto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(stream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(stream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Object lector_objetos(String nombre_de_archivo){
        Object retornar = null;
        try {
            lector = new ObjectInputStream(new FileInputStream(nombre_de_archivo));
            retornar=lector.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(stream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(stream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(stream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retornar;
    }
}

