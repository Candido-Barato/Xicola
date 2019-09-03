/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Bairro;
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
public class BairroDAO extends GenericoDAO implements ObjectDAO<Bairro>{
   
    @Override
    public Bairro Create(ResultSet rss) {
        Bairro p = new Bairro();
        try {
            p.setId_bairro(rss.getInt(1));
            p.setId_distrito(rss.getInt(2));
            p.setBairro(rss.getString(3));
        } catch (SQLException ex) {
            super.setStatus(true);
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    @Override
    public Bairro Read() {
       Bairro p = new Bairro();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while (rstt.next()) {
                p=Create(rstt);
            }
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void Update(Bairro x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Bairro x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bairro> Listar() {
        ArrayList<Bairro> listaPessoa = new ArrayList<>();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while(rstt.next()) {
                listaPessoa.add(Create(rstt));
            }
            fechaConexao(com, prst,rst);
            
            return listaPessoa;
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPessoa;
    }

    @Override
    public void Create() {
       
       super.Create(super.getSql(), super.getParamentro());    
    }

   

}