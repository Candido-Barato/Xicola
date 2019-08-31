/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Distrito;
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
public class DistritoDAO extends GenericoDAO implements ObjectDAO<Distrito>{
   
    @Override
    public Distrito Create(ResultSet rss) {
        Distrito p = new Distrito();
        try {
            p.setId_Prov(rss.getInt(""));
            p.setId_distrito(rss.getInt(""));
            p.setDistrito(rss.getString(""));
        } catch (SQLException ex) {
            super.setStatus(true);
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    @Override
    public Distrito Read(Distrito x) {
       Distrito p = new Distrito();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while (rstt.next()) {
                p=Create(rstt);
            }
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void Update(Distrito x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Distrito x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Distrito> Listar(Distrito x) {
        ArrayList<Distrito> listaPessoa = new ArrayList<>();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while(rstt.next()) {
                listaPessoa.add(Create(rstt));
            }
            fechaConexao(com, prst,rst);
            
            return listaPessoa;
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPessoa;
    }

    @Override
    public void Create() {
       
       super.Create(super.getSql(), super.getParamentro());    
    }

   

}