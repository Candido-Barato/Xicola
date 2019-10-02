/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.VO.Aluno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Barato Soft Solution
 */
public class AlunoDao extends GenericoDAO implements ObjectDAO<Aluno> {


    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Aluno x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(Aluno x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno Create(ResultSet rss) {
        Aluno p = new Aluno();
        try {
            p.setId_pessoa(rss.getString("id_pessoa"));
            p.setNome(rss.getString("nome"));
            p.setApelido(rss.getString("apelido"));
            p.setSexo(rss.getString("sexo").charAt(0));
            p.setEstado_civil(rss.getString("estado_civil"));
            p.setData_nascimento(new Date(rss.getDate("data_nascimento").getTime()));
            p.setData_ingresso(new Date(rss.getDate("Data_Registo").getTime()));
            p.setEstado(rss.getString("Estado"));
            p.setTotal_Servicos(rss.getInt("Total_Servicos_Ativos"));
        } catch (SQLException ex) {
            System.out.println("Problema com parametros "+ex.getMessage());
        }
        return p;
        
    }

    @Override
    public Aluno Read() {
        Aluno a = new Aluno();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while(rstt.next()) {
                a=Create(rstt);
            }
            fechaConexao(com, prst,rst);
            
        } catch (SQLException ex) {
             super.setStatus(true);
             System.out.println("Problema no Listar Alunos "+ex.getMessage());
        }
        return a;
    }

    @Override
    public List<Aluno> Listar() {
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while(rstt.next()) {
                listaAlunos.add(Create(rstt));
            }
            fechaConexao(com, prst,rst);
            
        } catch (SQLException ex) {
             super.setStatus(true);
             System.out.println("Problema no Listar Alunos "+ex.getMessage());
        }
        return listaAlunos;

    }
    
}
