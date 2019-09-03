/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Provincia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barato Soft Solution
 */
public class ProvinciaDAO extends GenericoDAO implements ObjectDAO<Provincia>{
   
    @Override
    public Provincia Create(ResultSet rss) {
        Provincia p = new Provincia();
        try {
            p.setId_Prov(rss.getInt(1));
            p.setCodPais(rss.getInt(2));
            p.setProvincia(rss.getString(3));
        } catch (SQLException ex) {
            super.setStatus(true);
            System.out.println("Essro "+ex.getLocalizedMessage()+" Fonte Create(ResultSet rss) ProvinciaDao ");
            Logger.getLogger(ProvinciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    @Override
    public Provincia Read() {
       Provincia p = new Provincia();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while (rstt.next()) {
                p=Create(rstt);
            }
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(ProvinciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void Update(Provincia x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Provincia x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Provincia> Listar() {
        ArrayList<Provincia> listaPessoa = new ArrayList<>();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while(rstt.next()) {
                listaPessoa.add(Create(rstt));
            }
            fechaConexao(com, prst,rst);
            
            return listaPessoa;
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(ProvinciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPessoa;
    }

    @Override
    public void Create() {
       
       super.Create(super.getSql(), super.getParamentro());    
    }

   

}