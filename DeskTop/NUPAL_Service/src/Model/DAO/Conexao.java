/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

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
    public  PreparedStatement prst;
    public  ResultSet rst;
    public Connection com;
    public   CallableStatement call;
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String DATABASE = "gestao_pessoal";
    private static final String DRIVER_CONEXAO = "com.mysql.jdbc.Driver";
    private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/";
    
    
    public Conexao() {
    
    }
    
    public  Connection conect(){
       Connection conect=null;
        try {
            Class.forName(DRIVER_CONEXAO);
            conect = DriverManager.getConnection(STR_CONEXAO + DATABASE, USUARIO, SENHA);
        } catch(ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver MySql nao foi encontrado no bamco de dados: "
                    +e.getMessage(),"Conexao com Base de dados (BDconexao), ", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException s) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com a base de dadosno bamco de dados: "
                    +s.getMessage(),"Conexao com Base de dados (BDconexao) ", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Nao foi possivel fechar o statement"
                +e.getMessage(),"Aviso importante (BDconexao)",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public  void fechaConexao(Connection con) {
        try {
            if(con != null) {
                con.close();
                System.out.println("Conexao Fechada a conexao com o Banco de Dados");
            }           
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel fechar a conexao"
                +e.getMessage(),"Aviso importante (BDconexao)",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Nao foi possivel fechar o ResultSet!"
                +e.getMessage(),"Aviso importante (BDconexao)",JOptionPane.ERROR_MESSAGE);
        }
    }
}