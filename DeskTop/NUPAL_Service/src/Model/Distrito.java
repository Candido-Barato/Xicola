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
public class Distrito extends Provincia{
    protected int id_distrito;
    protected String distrito;

    public Distrito(int id_distrito, String distrito, int id_Prov, String provincia, int codPais, String pais) {
        super(id_Prov, provincia, codPais, pais);
        this.id_distrito = id_distrito;
        this.distrito = distrito;
    }

    public Distrito() {
        this(0,"",0,"",0,"");
    }

    public int getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(int id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    
    
    
}
