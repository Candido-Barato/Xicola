/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLER;

import MODEL.DAO.AlunoDao;
import MODEL.VO.Aluno;
import VIEW.Auxiliar;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Barato Soft Solution
 */
public class AlunoControler {
    AlunoDao alDao;
     ArrayList<Aluno> listaAlunos;

    public AlunoControler() {
        alDao = new AlunoDao();
        listaAlunos = new ArrayList<>();
    }
     
    public void Busca_Alunos(){
        alDao.setSql("select id_pessoa,nome, apelido, sexo, estado_civil, data_nascimento,Data_Registo,Estado, Total_Servicos_Ativos from pessoa,aluno where aluno.id_Aluno=pessoa.id_pessoa order by Data_Registo desc;");
        alDao.setParamentro(new Object[]{});
        listaAlunos = (ArrayList<Aluno>) alDao.Listar();
    }
    
    public void preencherModelo(DefaultTableModel modelo){
        Busca_Alunos();
        listaAlunos.forEach((t) -> {
             modelo.addRow(new Object[]{t.getId_pessoa(),t.getNome()+" "+t.getApelido(),t.getEstado(),t.getTotal_Servicos(),Auxiliar.auxJanela.dataString(t.getData_ingresso())});
        });
    }
    
}
