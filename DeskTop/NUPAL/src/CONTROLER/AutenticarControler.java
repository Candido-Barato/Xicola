/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLER;

import MODEL.DAO.AutenticarDao;
import MODEL.VO.Usuario;

/**
 *
 * @author Barato Soft Solution
 */
public class AutenticarControler {
    AutenticarDao autD = new AutenticarDao();
    Usuario p;
    
    public boolean login(String username,String senha){
        autD.setSql("select * from usuario where username=? and senha=?;");
        autD.setParamentro(new Object[]{username,senha});
        p= autD.Read();
        return p.isAcessar();
    }
    public Usuario pp(){
    return p;
    }
    
}
