/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Pessoa;
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
public class PessoaDAO extends GenericoDAO implements ObjectDAO<Pessoa>{
   
    @Override
    public Pessoa Create(ResultSet rss) {
        Pessoa p = new Pessoa();
        try {
            p.setApelido(rss.getString("Apelido"));
            p.setNome(rss.getString("Nome"));
            p.setId_Pessoa(rss.getInt("id_Pessoa"));
        } catch (SQLException ex) {
            super.setStatus(true);
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    @Override
    public Pessoa Read(Pessoa x) {
        Pessoa p = new Pessoa();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while (rstt.next()) {
                p=Create(rstt);
            }
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void Update(Pessoa x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Pessoa x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> Listar(Pessoa x) {
        ArrayList<Pessoa> listaPessoa = new ArrayList<>();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while(rstt.next()) {
                listaPessoa.add(Create(rstt));
            }
            fechaConexao(com, prst,rst);
            
            return listaPessoa;
        } catch (SQLException ex) {
             super.setStatus(true);
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPessoa;
    }

    @Override
    public void Create() {
       
       super.Create(super.getSql(), super.getParamentro());    
    }


    
}
