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
public class Endereco {
    private Bairro bairro;
    private String avenida;
    private byte quarterao, nrCasa;
    private int id, codigoPostal;

    public Endereco() {
        this(new Bairro(),"",(byte)0,(byte)0,0,0);
    }

    public Endereco(Bairro bairro, String avenida, byte quarterao, byte nrCasa, int id, int codigoPostal) {
        this.bairro = bairro;
        this.avenida = avenida;
        this.quarterao = quarterao;
        this.nrCasa = nrCasa;
        this.id = id;
        this.codigoPostal = codigoPostal;
    }

    
    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }


    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public byte getQuarterao() {
        return quarterao;
    }

    public void setQuarterao(byte quarterao) {
        this.quarterao = quarterao;
    }

    public byte getNrCasa() {
        return nrCasa;
    }

    public void setNrCasa(byte nrCasa) {
        this.nrCasa = nrCasa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
    
}
