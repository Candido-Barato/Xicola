/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.VO.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barato Soft Solution
 */
public class AutenticarDao extends GenericoDAO implements ObjectDAO<Usuario> {

    @Override
    public Usuario Create(ResultSet rss) {
         Usuario p = new Usuario();
        try {
           
            p.setAcessar(true);
            p.setAcesso(rss.getString("id_user"));
            /* p.setId_local(0);
            p.setAcesso(acesso);
            p.setNome_local(nome_local);*/
            
        } catch (SQLException ex) {
            Logger.getLogger(AutenticarDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Usuario Read() {
        Usuario p = new Usuario();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while (rstt.next()) {
                p=Create(rstt);
            }
        } catch (SQLException ex) {
             super.setStatus(true);
        }
        return p;
    }

    @Override
    public void Update(Usuario x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Usuario x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> Listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
