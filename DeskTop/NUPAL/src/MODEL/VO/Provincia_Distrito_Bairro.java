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
public class Provincia_Distrito_Bairro extends Pais{
    protected int id;
    protected String nome_;

    public Provincia_Distrito_Bairro(int id, String nome_, int id_pais, String nome_Pais) {
        super(id_pais, nome_Pais);
        this.id = id;
        this.nome_ = nome_;
    }

    

    public Provincia_Distrito_Bairro() {
        this(0,"",0,"");
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNome_() {
        return nome_;
    }

    public void setNome_(String nome_) {
        this.nome_ = nome_;
    }

    
    
    
}
