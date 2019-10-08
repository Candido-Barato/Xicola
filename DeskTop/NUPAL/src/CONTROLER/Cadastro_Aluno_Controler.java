/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLER;

import MODEL.VO.Aluno;
import VIEW.Formacao.Alunos;
import static VIEW.Formacao.Alunos.cr;
import VIEW.Formacao.CadastrarAluno;
import VIEW.Formacao.CadastrarAluno_01;
import VIEW.Formacao.CadastrarAluno_02;
import static VIEW.Home.addPainelCentro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Barato Soft Solution
 */
public class Cadastro_Aluno_Controler implements ActionListener{
    private Aluno al;
    private CadastrarAluno cadastrarAluno;
    private CadastrarAluno_01 cadastrarAluno_01;
    private CadastrarAluno_02 cadastrarAluno_02;

    public Aluno getAl() {
        return al;
    }

    public Cadastro_Aluno_Controler(Aluno al, CadastrarAluno cadastrarAluno, CadastrarAluno_01 cadastrarAluno_01, CadastrarAluno_02 cadastrarAluno_02) {
        this.al = al;
        this.cadastrarAluno = cadastrarAluno;
        this.cadastrarAluno.Config();
        this.cadastrarAluno_01 = cadastrarAluno_01;
        this.cadastrarAluno_01.Config();
        this.cadastrarAluno_02 = cadastrarAluno_02;
        this.cadastrarAluno_02.Config();
    }

    public Cadastro_Aluno_Controler() {
        this(new Aluno(), new CadastrarAluno(), new CadastrarAluno_01(), new CadastrarAluno_02());
    }
    
    

    public void setAl(Aluno al) {
        this.al = al;
    }

    public CadastrarAluno getCadastrarAluno() {
        return cadastrarAluno;
    }

    public void setCadastrarAluno(CadastrarAluno cadastrarAluno) {
        this.cadastrarAluno = cadastrarAluno;
    }

    public CadastrarAluno_01 getCadastrarAluno_01() {
        return cadastrarAluno_01;
    }

    public void setCadastrarAluno_01(CadastrarAluno_01 cadastrarAluno_01) {
        this.cadastrarAluno_01 = cadastrarAluno_01;
    }

    public CadastrarAluno_02 getCadastrarAluno_02() {
        return cadastrarAluno_02;
    }

    public void setCadastrarAluno_02(CadastrarAluno_02 cadastrarAluno_02) {
        this.cadastrarAluno_02 = cadastrarAluno_02;
    }
    
    public void Evento(){
        cadastrarAluno.getJbCancelar().addActionListener((ae) -> {
            actionPerformed(ae);
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== cadastrarAluno.getJbCancelar() || ae.getSource()== cadastrarAluno_01.getJbCancelar() ||ae.getSource()== cadastrarAluno_02.getJbCancelar()){
            Alunos al = new Alunos();
            al.Config();
            addPainelCentro(al);
        }
        if(ae.getSource()== cadastrarAluno.getJbProximo()){
            preencher01();
            addPainelCentro(cr.getCadastrarAluno_01());
        }
        if(ae.getSource()== cadastrarAluno.getJbVoltar()){
            JOptionPane.showMessageDialog(cadastrarAluno, "Oy Voltar");
        }
       
        if(ae.getSource()== cadastrarAluno_01.getJbProximo()){
            addPainelCentro(cr.getCadastrarAluno_02());
        }
        if(ae.getSource()== cadastrarAluno_01.getJbVoltar()){
            //cr.al.setNome("Nome Aluno");
            cr.getCadastrarAluno().getJtNome().setText(cr.al.getNome());
            addPainelCentro(cr.getCadastrarAluno());
        }
       
        if(ae.getSource()== cadastrarAluno_02.getJbProximo()){
            JOptionPane.showMessageDialog(cadastrarAluno, "Oy");
        }
        if(ae.getSource()== cadastrarAluno_02.getJbVoltar()){
            JOptionPane.showMessageDialog(cadastrarAluno, "Oy");
        }
        cadastrarAluno.getJtNome().addFocusListener(new FocusAdapter() {

            
            
});
    }
    
    public void preencher01(){
        cr.al.setNome(cr.getCadastrarAluno().getJtNome().getText());
        cr.al.setApelido(cr.getCadastrarAluno().getJtNome().getText());
        cr.al.setSexo(cr.getCadastrarAluno().getJtNome().getText().charAt(0));
        cr.al.setEstado_civil(cr.getCadastrarAluno().getJtNome().getText());
        //cr.al.setData_nascimento(cr.getCadastrarAluno().getJtNome().getText());
    
    }

    
    
}
