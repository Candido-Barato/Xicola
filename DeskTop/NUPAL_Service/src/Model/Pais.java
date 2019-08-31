/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Barato Soft Solution
 */
public class Pais {
    private int codPais;
    private String pais;

    public Pais(int codPais, String pais) {
        this.codPais = codPais;
        this.pais = pais;
    }
    
    
    public Pais() {
        this(0, "");
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    
}
