/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Bairro;
import Model.DAO.BairroDAO;
import Model.DAO.DistritoDAO;
import Model.DAO.PaisDAO;
import Model.DAO.ProvinciaDAO;
import Model.Distrito;
import Model.Pais;
import Model.Provincia;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Barato Soft Solution
 */
public class Localizacao_Controler {

    private PaisDAO pd;
    private ProvinciaDAO pr;
    private DistritoDAO dd;
    private BairroDAO bd;
    public static ArrayList<Distrito> listaDistrito;
    public static ArrayList<Pais> listaPais;
    public static ArrayList<Provincia> listaProvincia;
    public static ArrayList<Bairro> listaBairro;

    public void buscaDistrito() {
        dd = new DistritoDAO();
        dd.setSql("SELECT * FROM distrito");
        dd.setParamentro(new Object[]{});
        listaDistrito = (ArrayList<Distrito>) dd.Listar();
        if (dd.isStatus()) {
            JOptionPane.showMessageDialog(null, "A operacao falhou");
        } else {
            JOptionPane.showMessageDialog(null, "A operacao bbem sucedida");
        }
    }

    public void buscaBairro() {
        bd = new BairroDAO();
        bd.setSql("SELECT * FROM bairro");
        bd.setParamentro(new Object[]{});
        listaBairro = (ArrayList<Bairro>) bd.Listar();
        if (bd.isStatus()) {
            JOptionPane.showMessageDialog(null, "A operacao falhou");
        } else {
            JOptionPane.showMessageDialog(null, "A operacao bbem sucedida");
        }
    }

    public void buscaPais() {
        pd = new PaisDAO();
        pd.setSql("SELECT * FROM pais");
        pd.setParamentro(new Object[]{});
        listaPais = (ArrayList<Pais>) pd.Listar();
        if (pd.isStatus()) {
            JOptionPane.showMessageDialog(null, "A operacao falhou");
        } else {
            JOptionPane.showMessageDialog(null, "A operacao bbem sucedida");
        }
    }

    public void buscaProvincia() {
        pr = new ProvinciaDAO();
        pr.setSql("SELECT * FROM provincia");
        pr.setParamentro(new Object[]{});
        listaProvincia = (ArrayList<Provincia>) pr.Listar();
        if (pr.isStatus()) {
            JOptionPane.showMessageDialog(null, "A operacao falhou");
        } else {
            JOptionPane.showMessageDialog(null, "A operacao bbem sucedida");
        }
    }

    /*SELECT * FROM pais;
;
;
;*/
    public void buscaNacionalidade(int id) {
    }

    public void buscaPais(int id) {
    }

    public void buscaProvincia(int id) {
    }

    public void buscaBairro(int id) {
    }
    
}
