/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.VO;

import java.util.Date;

/**
 *
 * @author Barato Soft Solution
 */
public class Aluno extends Pessoa{
    private int total_Servicos;
    private String estado;
    private Date data_ingresso;

    public Aluno(int total_Servicos, String estado, Date data_ingresso, String id_pessoa, String nome, String apelido, String estado_civil, char sexo, Date data_nascimento) {
        super(id_pessoa, nome, apelido, estado_civil, sexo, data_nascimento);
        this.total_Servicos = total_Servicos;
        this.estado = estado;
        this.data_ingresso = data_ingresso;
    }

    public Aluno() {
        this(0,"",new Date(), "","","","Solteiro",'M',new Date());
    }

    public Aluno(int total_Servicos, String estado, Date data_ingresso) {
        this.total_Servicos = total_Servicos;
        this.estado = estado;
        this.data_ingresso = data_ingresso;
    }

    public int getTotal_Servicos() {
        return total_Servicos;
    }

    public void setTotal_Servicos(int total_Servicos) {
        this.total_Servicos = total_Servicos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getData_ingresso() {
        return data_ingresso;
    }

    public void setData_ingresso(Date data_ingresso) {
        this.data_ingresso = data_ingresso;
    }
    

  
    
    
    
}
