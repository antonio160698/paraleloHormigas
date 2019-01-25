/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColoniaHormigasTSP;

import java.io.Serializable;

/**
 *
 * @author anton_000
 */
public class guardar implements Serializable{

    public guardar(int[] runn, double lo, int gen, int nhormiga, int[] mejrecor, double mlo, int mgen, int mh) {
        this.runn = runn;
        this.lo = lo;
        this.gen = gen;
        this.nhormiga = nhormiga;
        this.mejrecor = mejrecor;
        this.mlo = mlo;
        this.mgen = mgen;
        this.mh = mh;
    }

    public int[] getRunn() {
        return runn;
    }

    public void setRunn(int[] runn) {
        this.runn = runn;
    }

    public double getLo() {
        return lo;
    }

    public void setLo(double lo) {
        this.lo = lo;
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public int getNhormiga() {
        return nhormiga;
    }

    public void setNhormiga(int nhormiga) {
        this.nhormiga = nhormiga;
    }

    public int[] getMejrecor() {
        return mejrecor;
    }

    public void setMejrecor(int[] mejrecor) {
        this.mejrecor = mejrecor;
    }

    public double getMlo() {
        return mlo;
    }

    public void setMlo(double mlo) {
        this.mlo = mlo;
    }

    public int getMgen() {
        return mgen;
    }

    public void setMgen(int mgen) {
        this.mgen = mgen;
    }

    public int getMh() {
        return mh;
    }

    public void setMh(int mh) {
        this.mh = mh;
    }

    public guardar() {
    }
    private int [] runn;
    private double lo;
    private int gen;  
    private int nhormiga;
    private int [] mejrecor;
    private double mlo;
    private int mgen;  
    private int mh;
    
}
