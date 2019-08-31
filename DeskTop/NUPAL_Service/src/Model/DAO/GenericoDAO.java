/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


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
    private boolean status;

    protected GenericoDAO() {
        this.conect=super.conect();
    }

    public Connection getConect() {
        return conect;
    }
    
    protected void Create(String sql,Object[] paramentro){
        status=false;
        try {
            prst = conect.prepareStatement(sql);
            for (int i = 0; i < paramentro.length; i++) {
                prst.setObject(i+1,paramentro[i]);
            }
            prst.execute();
            prst.close();
        } catch (SQLException e) {
            status=true;
            System.out.println("Erro "+e.getLocalizedMessage()+" Fonte Create()}");
        }catch (Exception es){
        }
    }
    
    protected void Update(String sql,Object[] paramentro){
        status=false;
        try {
            prst = conect.prepareStatement(sql);
            for (int i = 0; i < paramentro.length; i++) {
                prst.setObject(i+1,paramentro[i]);
            }
            prst.execute();
             fechaConexao(conect, prst);
        } catch (SQLException e) {
            status=true;
            System.out.println("Erro "+e.getLocalizedMessage()+" Fonte Create()}");
        }
    }
    
    protected void Delete(String sql,Object[] paramentro){
        status=false;
        try {
            prst = conect.prepareStatement(sql);
            for (int i = 0; i < paramentro.length; i++) {
                prst.setObject(i+1,paramentro[i]);
            }
            prst.execute();
            fechaConexao(conect, prst);
        } catch (SQLException e) {
            status=true;
            System.out.println("Erro "+e.getLocalizedMessage()+" Fonte Create()}");
        }
    }
    
    protected ResultSet Read(String sql,Object[] paramentro){
        status=false;
        try {
            prst = conect.prepareStatement(sql);
            for (int i = 0; i < paramentro.length; i++) {
                prst.setObject(i+1,paramentro[i]);
            }
            rst = prst.executeQuery();
        } catch (SQLException e) {
            status=true;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    

    
    
    
    
}
