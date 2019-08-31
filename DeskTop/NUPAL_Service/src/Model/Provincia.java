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
public class Provincia extends Pais{
    protected int id_Prov;
    protected String provincia;

    public Provincia(int id_Prov, String provincia, int codPais, String pais) {
        super(codPais, pais);
        this.id_Prov = id_Prov;
        this.provincia = provincia;
    }

    public Provincia() {
        this(0,"",0,"");
    }

    public int getId_Prov() {
        return id_Prov;
    }

    public void setId_Prov(int id_Prov) {
        this.id_Prov = id_Prov;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
    
}
