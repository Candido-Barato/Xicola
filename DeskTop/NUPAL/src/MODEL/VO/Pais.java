/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.VO;

/**
 *
 * @author Barato Soft Solution
 */
public class Pais {
    protected int id_pais;
    protected String nome_Pais;

    public Pais(int id_pais, String nome_Pais) {
        this.id_pais = id_pais;
        this.nome_Pais = nome_Pais;
    }

    public Pais() {
        this(0,"");
    }

    
    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getNome_Pais() {
        return nome_Pais;
    }

    public void setNome_Pais(String nome_Pais) {
        this.nome_Pais = nome_Pais;
    }
    
    
    
}
