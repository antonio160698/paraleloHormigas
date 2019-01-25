/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColoniaHormigasTSP;



/**
 *
 * @author anton_000
 */
public class Pool implements Runnable{
    public static Circuito circuito; //=new Circuito();
    public static Feromonas feromonas; //=new Feromonas(circuito.getNumeroNodos(),circuito.getNumeroNodos());    
    public static Visibilidad visibilidad;
    public static Hormiga hormiga;
    public static ColoniaHormigasTSP tsp;
    public static double TASA_EVAPORACION=0.01;
    private int [] runn;
    private double lo;
    private int gen;  
    private int nhormiga;
    private int [] mejrecor;
    private double mlo;
    private int mgen;  
    private int mh;
    private int gen1;
    private int gen2;
    public Pool (int[] runn, double lo, int gen1, int gen2, int[] mejrecor, double mlo, int mgen, int mh){
        this.lo=lo;
        this.runn=runn;
        this.mejrecor=mejrecor;
        this.mgen=mgen;
        this.mh=mh;
        this.mlo=mlo;
        this.gen1=gen1;
        this.gen2=gen2;
}
    guardar g = new guardar();
    stream s = new stream();

    @Override
    public void run() {
        circuito=new Circuito();   
        feromonas=new Feromonas(circuito.getNumeroNodos(),circuito.getNumeroNodos());
        visibilidad=new Visibilidad(circuito.matrizDistanciasCiudades);  
        hormiga=new Hormiga(circuito,feromonas,visibilidad);
        tsp = new ColoniaHormigasTSP();
        for( gen=gen1;gen<gen2;gen++){
            for(nhormiga=0;nhormiga<ColoniaHormigasTSP.CANT_HORMIGAS;nhormiga++){
        //g.setRunn(hormiga.construirSolucion());
        //longitud();
                proceso();
            }
            proceso2();
        }
        s.escritor_objectos(g);
        }
    
    public synchronized void longitud(){
        g.setLo(circuito.getLongitudRecorrido(runn));
        //System.out.println(this.getLo());
    }
    public synchronized void proceso(){
        int[] recorrido;
        double longitud;

                //---------- LAMADO A LA HORMIGAS
                //Hormiga hormiga=new Hormiga(circuito,feromonas,visibilidad);
                //CONTRUIR SOLUCION
                //recorrido=hormiga.construirSolucion();
                recorrido=hormiga.construirSolucion();
                //obtener longitud
                
                longitud= circuito.getLongitudRecorrido(recorrido);
                
            System.out.printf("Generacion=%3d Hormiga=%3d R-> Longitud=%5.14f -->",gen,nhormiga,longitud);
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
                if(gen==0 && nhormiga==0){
                    g.setMejrecor(recorrido);
                    g.setMlo(longitud);
                    g.setMgen(0);
                    g.setMh(0);
                }                
                if(longitud<g.getMlo()){
                    g.setMejrecor(recorrido);
                    g.setMlo(longitud);
                    g.setMgen(gen);
                    g.setMh(nhormiga);               
                }
                //----------------------------------------------------------                
                //----------- FIN LLAMADO HORMIGAS
                //ob.proceso(recorrido, longitud, generacion, hormigaK);
                
            
        
    }
    public synchronized void proceso2(){
        System.out.println(" ");                
            System.out.println("------------------------");    
            System.out.println("RESULTADOS");     
            System.out.println("------------------------");                 
            
            System.out.println("MEJOR TOUR HASTA EL MOMENTO --> Logitud="+g.getMlo());            
            
            for(int i=0; i<g.getMejrecor().length;i++){
                System.out.print(g.getMejrecor()[i]+" "); 
            }
            System.out.println();
            //otro_proceso(mejorLongitud, mejorRecorrido);
    }
    /*public static void el_regreso_del_proceso_lavenganza(double mejorlo, int[] mejorreco, int mgen, int mhor){
        System.out.println("TOUR FINAL --> Logitud="+mejorlo+" generacion="+mgen+" hormiga="+mhor);            
            
            for(int i=0; i<mejorreco.length;i++){
                System.out.print(mejorreco[i]+" ");                
            }
            System.out.println(" ");

            //---IMPRESION DE PARAMETROS----------------------------------------
            System.out.println("------------------------");    
            System.out.println("PARAMETROS DEL ALGORITMO");     
            System.out.println("------------------------");     
            System.out.println("CANT_GENERACIONES="+ColoniaHormigasTSP.CANT_GENERACIONES); 
            System.out.println("CANT_HORMIGAS="+ColoniaHormigasTSP.CANT_HORMIGAS);
            System.out.println("TASA_EVAPORACION="+TASA_EVAPORACION);
            System.out.println("ALFA="+ColoniaHormigasTSP.ALFA);
            System.out.println("BETA="+ColoniaHormigasTSP.BETA);
        
    }*/
    
}
