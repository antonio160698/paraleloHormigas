
package ColoniaHormigasTSP;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ColoniaHormigasTSP {
    
    //------ INICIO CONFIGURACION DEL ALGORITMO -----
    public static int CANT_GENERACIONES=100; 
    public static int CANT_HORMIGAS=10;
    public static Double TASA_EVAPORACION=0.01;
    public static int ALFA=1;    
    public static int BETA=1;        
    //alfa, beta=1-alfa
    //delta tau=1
    
    //------ FIN CONFIGURACION DEL ALGORITMO -----    
    
    //--- INICIALIZACION DE FEROMONAS ---
    public static Circuito circuito; //=new Circuito();
    public static Feromonas feromonas; //=new Feromonas(circuito.getNumeroNodos(),circuito.getNumeroNodos());    
    public static Visibilidad visibilidad;
    //-------------------------------
    
    
    
    
    public static void main(String[] args) {

    //--- CONFIGURACION DE PARAMETROS -----------------------------------------
    circuito=new Circuito();   
    feromonas=new Feromonas(circuito.getNumeroNodos(),circuito.getNumeroNodos());
    visibilidad=new Visibilidad(circuito.matrizDistanciasCiudades);   

    circuito.mostrarCiudadesLista();
    circuito.mostrarMatrizDistancias();

    //--------------------------------------
    int [] recorrido=new int [circuito.CANTIDADCIUDADES];
    Double longitud=0.0;
    //------se guardan las mejores soluciones
    int [] mejorRecorrido=new int [circuito.CANTIDADCIUDADES];
    Double mejorLongitud=0.0;
    int mejorGeneracion=0;
    int mejorHormiga=0;
    guardar g = new guardar();
    int gen = calificar();
    long a=System.currentTimeMillis();
        //programa principal
        ExecutorService executors = Executors.newFixedThreadPool(4);
        //for(int generacion=0;generacion<CANT_GENERACIONES;generacion++){
            //for(int hormigaK=0;hormigaK<CANT_HORMIGAS;hormigaK++){

                //---------- LAMADO A LA HORMIGAS
                Pool ob1 = new Pool(recorrido, longitud, gen*(0/4), gen*(1/4), mejorRecorrido, mejorLongitud, mejorGeneracion, mejorHormiga);
                Pool ob2 = new Pool(recorrido, longitud, gen*(1/4), gen*(2/4), mejorRecorrido, mejorLongitud, mejorGeneracion, mejorHormiga);
                Pool ob3 = new Pool(recorrido, longitud, gen*(2/4), gen*(3/4), mejorRecorrido, mejorLongitud, mejorGeneracion, mejorHormiga);
                Pool ob4 = new Pool(recorrido, longitud, gen*(3/4), gen*(4/4), mejorRecorrido, mejorLongitud, mejorGeneracion, mejorHormiga);
                Thread t1 = new Thread(ob1);
                Thread t2 = new Thread(ob2);
                Thread t3 = new Thread(ob3);
                Thread t4 = new Thread(ob4);
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                //Hormiga hormiga=new Hormiga(circuito,feromonas,visibilidad);
                //CONTRUIR SOLUCION
                //recorrido=hormiga.construirSolucion();
                //recorrido=g.getRunn();
                //obtener longitud
                //longitud= g.getLo();
                
/*
            System.out.printf("Generacion=%3d Hormiga=%3d R-> Longitud=%5.14f -->",generacion,hormigaK,longitud);
            for(int i=0; i<recorrido.length;i++){
                System.out.printf(" %3d",recorrido[i]);                
            }
            System.out.println();

                //ACTUALIZAR FEROMONAS
                feromonas.actualizarFeromonasCamino(recorrido, longitud);
//                feromonas.mostrarFeromonas();
                //EVAPORAR FEROMONAS
                feromonas.evaporarFeromonas(TASA_EVAPORACION);
                //----------------------------------------------------------
                //EVALUAR SOLUCION
                //----------------------------------------------------------.
                if(generacion==0 && hormigaK==0){
                    mejorLongitud=longitud;
                    mejorRecorrido=recorrido;
                    mejorGeneracion=0;
                    mejorHormiga=0;
                }                
                if(longitud<mejorLongitud){
                    mejorLongitud=longitud;
                    mejorRecorrido=recorrido;
                    mejorGeneracion=generacion;
                    mejorHormiga=hormigaK;                    
                }
                //----------------------------------------------------------                
                //----------- FIN LLAMADO HORMIGAS
*/
                //ob.proceso(recorrido, longitud, generacion, hormigaK);
                //mejorLongitud = g.getMlo();
                //mejorRecorrido = g.getMejrecor();
                //mejorGeneracion = g.getMgen();
                //mejorHormiga = g.getMh();
                
            //}//fin hormigasK
            

            /*System.out.println(" ");                
            System.out.println("------------------------");    
            System.out.println("RESULTADOS");     
            System.out.println("------------------------");                 
            
            System.out.println("MEJOR TOUR HASTA EL MOMENTO --> Logitud="+mejorLongitud);            
            
            for(int i=0; i<mejorRecorrido.length;i++){
                System.out.print(mejorRecorrido[i]+" "); 
            }
            System.out.println();
            */
            //otro_proceso(mejorLongitud, mejorRecorrido);
            
        //}//fin for principal
executors.shutdown();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            long b = System.currentTimeMillis();
            /*System.out.println("TOUR FINAL --> Logitud="+mejorLongitud+" generacion="+mejorGeneracion+" hormiga="+mejorHormiga);
            
            for(int i=0; i<mejorRecorrido.length;i++){
            System.out.print(mejorRecorrido[i]+" ");                
            }
            System.out.println(" ");

            //---IMPRESION DE PARAMETROS----------------------------------------
            System.out.println("------------------------");
            System.out.println("PARAMETROS DEL ALGORITMO");
            System.out.println("------------------------");
            System.out.println("CANT_GENERACIONES="+CANT_GENERACIONES); 
            System.out.println("CANT_HORMIGAS="+CANT_HORMIGAS);
            System.out.println("TASA_EVAPORACION="+TASA_EVAPORACION);
            System.out.println("ALFA="+ALFA);
            System.out.println("BETA="+BETA);*/
            //mejorLongitud = g.getMlo();
            //mejorRecorrido = g.getMejrecor();
            //mejorGeneracion = g.getMgen();
            //mejorHormiga = g.getMh();
            //el_regreso_del_proceso(mejorLongitud, mejorRecorrido, mejorGeneracion, mejorHormiga);
            //-------------------------------------------  
        } catch (InterruptedException ex) {
            Logger.getLogger(ColoniaHormigasTSP.class.getName()).log(Level.SEVERE, null, ex);
        }
        long b = System.currentTimeMillis();
        long c = b-a;
        System.out.println("El Tiempo es de "+c);
        el_regreso_del_proceso(gen);
        

    }//main
    public static void el_regreso_del_proceso(int gen){
        guardar g = null;
        stream st = new stream();
        g = (guardar)st.lector_objetos("datos.dat");
        /*if(g.getMejrecor()==null){
            System.out.println("TOUR FINAL --> Logitud="+g.getMlo()+" generacion="+g.getMgen()+" hormiga="+g.getMh()); 
            System.out.println(g.getMejrecor());
        }else{*/
        System.out.println("TOUR FINAL --> Logitud="+g.getMlo()+" generacion="+g.getMgen()+" hormiga="+g.getMh()); 
            for(int i=0; i<g.getMejrecor().length;i++){
                System.out.print(g.getMejrecor()[i]+" ");                
            }
            System.out.println(" ");

            //---IMPRESION DE PARAMETROS----------------------------------------
            System.out.println("------------------------");    
            System.out.println("PARAMETROS DEL ALGORITMO");     
            System.out.println("------------------------");     
            System.out.println("CANT_GENERACIONES="+gen); 
            System.out.println("CANT_HORMIGAS="+CANT_HORMIGAS);
            System.out.println("TASA_EVAPORACION="+TASA_EVAPORACION);
            System.out.println("ALFA="+ALFA);
            System.out.println("BETA="+BETA);
    //}
    
    
    }
    public static int calificar(){
        int gen;
        do{
            Scanner s = new Scanner(System.in);
            System.out.println("Dame el numero de generaciones que sea divicible entre 4");
            gen = s.nextInt();
        }while(gen%4!=0);
        return gen;
    }
}//fin de clase

