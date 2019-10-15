/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.VO;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Barato Soft Solution
 */
public class DadosComponentes {
    private ArrayList<Provincia_Distrito_Bairro> paises;
    private ArrayList<Provincia_Distrito_Bairro> pronvicias;
    private ArrayList<Provincia_Distrito_Bairro> distritos;
    private ArrayList<Provincia_Distrito_Bairro> bairro;

    public DadosComponentes() {
    }

    public ArrayList<Provincia_Distrito_Bairro> getPaises() {
        return paises;
    }

    public void setPaises(ArrayList<Provincia_Distrito_Bairro> paises) {
        this.paises = paises;
    }

    public ArrayList<Provincia_Distrito_Bairro> getPronvicias() {
        return pronvicias;
    }

    public void setPronvicias(ArrayList<Provincia_Distrito_Bairro> pronvicias) {
        this.pronvicias = pronvicias;
    }

    public ArrayList<Provincia_Distrito_Bairro> getDistritos() {
        return distritos;
    }

    public void setDistritos(ArrayList<Provincia_Distrito_Bairro> distritos) {
        this.distritos = distritos;
    }

    public ArrayList<Provincia_Distrito_Bairro> getBairro() {
        return bairro;
    }

    public void setBairro(ArrayList<Provincia_Distrito_Bairro> bairro) {
        this.bairro = bairro;
    }
    
    
}
