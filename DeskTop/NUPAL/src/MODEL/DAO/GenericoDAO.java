/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author NAVANE
 */
public class GenericoDAO extends Conexao{
    private final Connection conect;
    private String sql;
    private Object []paramentro;
    

    protected GenericoDAO() {
        this.conect=super.conect();
    }

    public Connection getConect() {
        return conect;
    }
    
    
    
    protected void Create(String sql,Object[] paramentro){
        try {
            if(conect!=null){
            prst = conect.prepareStatement(sql);
            for (int i = 0; i < paramentro.length; i++) {
                prst.setObject(i+1,paramentro[i]);
            }
            prst.execute();
            prst.close();
            }else{
                System.out.println("Nao Foi possivel conectar ");
            }
        } catch (SQLException e) {
            System.out.println("Erro "+e.getLocalizedMessage()+" Fonte Create()}");
        }catch (Exception es){
        }
    }
    
    protected void Update(String sql,Object[] paramentro){
        try {
            if(conect!=null){
            prst = conect.prepareStatement(sql);
            for (int i = 0; i < paramentro.length; i++) {
                prst.setObject(i+1,paramentro[i]);
            }
            prst.execute();
             fechaConexao(conect, prst);
             }else{
                System.out.println("Nao Foi possivel conectar ");
            }
        } catch (SQLException e) {
            System.out.println("Erro "+e.getLocalizedMessage()+" Fonte Create()}");
        }
    }
    
    protected void Delete(String sql,Object[] paramentro){
        try {
            if(conect!=null){
            prst = conect.prepareStatement(sql);
            for (int i = 0; i < paramentro.length; i++) {
                prst.setObject(i+1,paramentro[i]);
            }
            prst.execute();
            fechaConexao(conect, prst);
             }else{
                System.out.println("Nao Foi possivel conectar ");
            }
        } catch (SQLException e) {
            System.out.println("Erro "+e.getLocalizedMessage()+" Fonte Create()}");
        }
    }
    
    protected ResultSet Read(String sql,Object[] paramentro){
        try {
            if(conect!=null){
            prst = conect.prepareStatement(sql);
            for (int i = 0; i < paramentro.length; i++) {
                prst.setObject(i+1,paramentro[i]);
            }
            rst = prst.executeQuery();
            }else{
                System.out.println("Nao Foi possivel conectar ");
            }
        } catch (SQLException e) {
            System.out.println("Erro "+e.getLocalizedMessage()+" Fonte Read()}");
        }
        return rst;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object[] getParamentro() {
        return paramentro;
    }

    public void setParamentro(Object[] paramentro) {
        this.paramentro = paramentro;
    }

   
    
    
    

    
    
    
    
}
