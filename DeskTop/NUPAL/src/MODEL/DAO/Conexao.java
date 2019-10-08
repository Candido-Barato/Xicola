/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

/**
 *
 * @author Barato Soft Solution
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    public  PreparedStatement prst=null;
    public  ResultSet rst=null;
    public Connection com=null;
    public   CallableStatement call;
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String DATABASE = "nupal_centro";
    private static final String DRIVER_CONEXAO = "com.mysql.jdbc.Driver";
    private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/";
    private boolean status=false;
    
    public Conexao() {
    
    }
    
    public  Connection conect(){
       Connection conect=null;
        try {
            Class.forName(DRIVER_CONEXAO);
            conect = DriverManager.getConnection(STR_CONEXAO + DATABASE, USUARIO, SENHA);
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("Problema ao ao conectar "+e.getMessage()+" Fonte Conexao {Conect()}");
        }
        return conect;
    }
    
    public  void fechaConexao(Connection con, PreparedStatement stmt) {
        try {
            if(con != null) 
                fechaConexao(con);
            if(stmt != null) {
                stmt.close();
                System.out.println("Statment fechado com sucesso");
            }
        }catch(SQLException e) {
            System.out.println("Nao foi possivel fechar o statement"+e.getMessage()+" Aviso importante (BDconexao)");
        }
    }
    
    public  void fechaConexao(Connection con) {
        try {
            if(con != null) {
                con.close();
                System.out.println("Conexao Fechada a conexao com o Banco de Dados");
            }           
        } catch(SQLException e) {
            System.out.println("Nao foi possivel fechar a conexao"
                +e.getMessage()+" Aviso importante (BDconexao)");
        }
    }
    
    public  void fechaConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        try {
            if(con != null && stmt != null) 
                fechaConexao(con,stmt);
            if(rs != null) {
                rs.close();
                System.out.println("ResultSet fechado com sucesso");
            }
        }catch(SQLException e) {
            System.out.println("Nao foi possivel fechar o ResultSet!"
                +e.getMessage()+" Aviso importante (BDconexao)");
        }
     

    }
     public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}