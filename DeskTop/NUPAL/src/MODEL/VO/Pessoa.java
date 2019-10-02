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
public class Pessoa {
    private String id_pessoa, nome, apelido,estado_civil;
    private char sexo;
    private Date data_nascimento;

    public Pessoa(String id_pessoa, String nome, String apelido, String estado_civil, char sexo, Date data_nascimento) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.apelido = apelido;
        this.estado_civil = estado_civil;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
    }

    public Pessoa() {
        this("","","","Solteiro",'M',new Date());
    }
    
    

    public String getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(String id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
}
