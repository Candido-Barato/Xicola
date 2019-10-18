/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLER;

import MODEL.BO.ValidarCampo;
import MODEL.DAO.DadosDao;
import MODEL.VO.DadosComponentes;
import MODEL.VO.Provincia_Distrito_Bairro;
import java.util.ArrayList;

/**
 *
 * @author Barato Soft Solution
 */
public class Dados_Controler {

    private DadosComponentes dadosComponete;
    private DadosDao dadosD;
    static ValidarCampo vlc = new ValidarCampo();

    public Dados_Controler(DadosComponentes dadosComponete, DadosDao dadosD) {
        this.dadosComponete = dadosComponete;
        this.dadosD = dadosD;
    }

    public Dados_Controler() {
        this(new DadosComponentes(), new DadosDao());
    }

    public void buscarPronvicias(int id_prov) {
        if (id_prov != -1) {
            dadosD.setSql("select id_prov as id, id_pais as dep, nome_provincia as nome from provincia where id_pais=?");
            dadosD.setParamentro(new Object[]{id_prov});
        } else {
            dadosD.setSql("select id_prov as id, id_pais as dep, nome_provincia as nome from provincia where id_pais");
            dadosD.setParamentro(new Object[]{});

        }
        dadosComponete.setPronvicias((ArrayList<Provincia_Distrito_Bairro>) dadosD.Listar());
    }

    public void buscarPaises() {
        dadosD.setSql("select id_pais as id, id_regiao as dep, nome_pais as nome from pais");
        dadosD.setParamentro(new Object[]{});
        dadosComponete.setPaises((ArrayList<Provincia_Distrito_Bairro>) dadosD.Listar());
    }

    public void buscarDistritos(int id_prov) {
        if (id_prov != -1) {
            dadosD.setSql("select id_distrito as id, id_prov as dep, nome_distrito as nome from distrito where id_prov =?");
            dadosD.setParamentro(new Object[]{id_prov});
        } else {
            dadosD.setSql("select id_distrito as id, id_prov as dep, nome_distrito as nome from distrito");
            dadosD.setParamentro(new Object[]{});
        }
        dadosComponete.setDistritos((ArrayList<Provincia_Distrito_Bairro>) dadosD.Listar());
    }

    public void buscarBairros(int id_distrito) {
        if (id_distrito != -1) {
            dadosD.setSql("select id_bairro as id, id_distrito as dep, nome_bairro as nome  from bairro where id_distrito=?;");
            dadosD.setParamentro(new Object[]{id_distrito});
        } else {
            dadosD.setSql("select id_bairro as id, id_distrito as dep, nome_bairro as nome  from bairro;");
            dadosD.setParamentro(new Object[]{});
        }
        dadosComponete.setBairro((ArrayList<Provincia_Distrito_Bairro>) dadosD.Listar());
    }

    public DadosComponentes getDadosComponete() {
        return dadosComponete;
    }

    public void setDadosComponete(DadosComponentes dadosComponete) {
        this.dadosComponete = dadosComponete;
    }

    public DadosDao getDadosD() {
        return dadosD;
    }

    public void setDadosD(DadosDao dadosD) {
        this.dadosD = dadosD;
    }

}
