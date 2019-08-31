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
public class Bairro extends Distrito{
    private int id_bairro;
    private String bairro;

    public Bairro(int id_bairro, String bairro, int id_distrito, String distrito, int id_Prov, String provincia, int codPais, String pais) {
        super(id_distrito, distrito, id_Prov, provincia, codPais, pais);
        this.id_bairro = id_bairro;
        this.bairro = bairro;
    }

    public Bairro() {
        this(0,"",0,"",0,"",0,"");
    }

    public int getId_bairro() {
        return id_bairro;
    }

    public void setId_bairro(int id_bairro) {
        this.id_bairro = id_bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    
    
}
