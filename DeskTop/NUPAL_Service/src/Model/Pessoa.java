/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Barato Soft Solution
 */
public class Pessoa {
    
    private String nome, apelido, estadoCivil, email;
    private char sexo;
    private Date dataNasc;
    private int nrTell, id_Pessoa;
    private Filiacao fill;
    private Distrito natural;
    private Endereco endereco;

    public Pessoa(String nome, String apelido, String estadoCivil, String email, char sexo, Date dataNasc, int nrTell, int id_Pessoa, Filiacao fill, Distrito natural, Endereco endereco) {
        this.nome = nome;
        this.apelido = apelido;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.nrTell = nrTell;
        this.id_Pessoa = id_Pessoa;
        this.fill = fill;
        this.natural = natural;
        this.endereco = endereco;
    }

 

    public Pessoa() {
        this("","","","Solteiro",'M',new Date(),0,0, new Filiacao(), new Distrito(), new Endereco());
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_Pessoa() {
        return id_Pessoa;
    }

    public void setId_Pessoa(int id_Pessoa) {
        this.id_Pessoa = id_Pessoa;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getNrTell() {
        return nrTell;
    }

    public void setNrTell(int nrTell) {
        this.nrTell = nrTell;
    }

    public Filiacao getFill() {
        return fill;
    }

    public void setFill(Filiacao fill) {
        this.fill = fill;
    }

    public Distrito getNatural() {
        return natural;
    }

    public void setNatural(Distrito natural) {
        this.natural = natural;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
    
}
