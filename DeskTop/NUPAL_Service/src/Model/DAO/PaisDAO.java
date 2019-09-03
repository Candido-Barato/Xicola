/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Pais;
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
public class PaisDAO extends GenericoDAO implements ObjectDAO<Pais>{
   
    @Override
    public Pais Create(ResultSet rss) {
        Pais p = new Pais();
        try {
            p.setCodPais(rss.getInt(1));
            p.setPais(rss.getString(2));
        } catch (SQLException ex) {
            super.setStatus(true);
             System.out.println("Essro "+ex.getLocalizedMessage()+" Fonte Create(ResultSet rss) ProvinciaDao ");
            Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    @Override
    public Pais Read() {
      Pais p = new Pais();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while (rstt.next()) {
                p=Create(rstt);
            }
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void Update(Pais x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Pais x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pais> Listar() {
        ArrayList<Pais> listaPessoa = new ArrayList<>();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while(rstt.next()) {
                listaPessoa.add(Create(rstt));
            }
            fechaConexao(com, prst,rst);
            
            return listaPessoa;
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPessoa;
    }

    @Override
    public void Create() {
       
       super.Create(super.getSql(), super.getParamentro());    
    }

   

}