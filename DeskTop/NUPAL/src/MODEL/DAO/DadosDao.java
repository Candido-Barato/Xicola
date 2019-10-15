/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.VO.Provincia_Distrito_Bairro;
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
public class DadosDao extends GenericoDAO implements ObjectDAO<Provincia_Distrito_Bairro> {


    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void Update(Provincia_Distrito_Bairro x) {
       
    }

    @Override
    public void Delete(Provincia_Distrito_Bairro x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Provincia_Distrito_Bairro Create(ResultSet rss) {
        Provincia_Distrito_Bairro a = new Provincia_Distrito_Bairro();
        try {
           a.setId(rss.getInt("id"));
           a.setId_pais(rss.getInt("dep"));
           a.setNome_(rss.getString("nome"));
        } catch (SQLException ex) {
            Logger.getLogger(DadosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  a;
       
    }

    @Override
    public Provincia_Distrito_Bairro Read() {
         Provincia_Distrito_Bairro a = new Provincia_Distrito_Bairro();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while(rstt.next()) {
                a=Create(rstt);
            }
            fechaConexao(com, prst,rst);
            
        } catch (SQLException|NullPointerException ex) {
             System.out.println("Problema no Listar Alunos "+ex.getMessage()+" Fonte AlunoDAO {Read()}");
        }
        return a;
    }

    @Override
    public List<Provincia_Distrito_Bairro> Listar() {
        ArrayList< Provincia_Distrito_Bairro> listaAlunos = new ArrayList<>();
        try {
            ResultSet rstt=super.Read(super.getSql(), super.getParamentro());
            while(rstt.next()) {
                listaAlunos.add(Create(rstt));
            }
            fechaConexao(com, prst,rst);
        } catch (SQLException|NullPointerException ex) {
             System.out.println("Problema no Listar Alunos "+ex.getMessage()+" Fonte AlunoDAO {Listar()}");
        }
        return listaAlunos;
    }
    
}
