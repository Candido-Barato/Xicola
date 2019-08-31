/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.DAO.PessoaDAO;
import Model.Pessoa;
import javax.swing.JOptionPane;

/**
 *
 * @author Barato Soft Solution
 */
public class Pessoa_Controler {
    
    PessoaDAO pd = new PessoaDAO();
    
    public void addPessoa(Pessoa p){
        pd.setSql("INSERT INTO pessoa (`Nome`,`Apelido`,`Estado_Civil`,`Data_Nasc`,`Email`,`Nr_Tell`) VALUES(?,?,?,?,?,?)");
        pd.setParamentro(new Object[]{p.getNome(),p.getApelido(),p.getEstadoCivil(),p.getDataNasc(),p.getEmail(),p.getNrTell()});
        pd.Create();
        if(pd.isStatus()){
            JOptionPane.showMessageDialog(null,"A operacao falhou");
        }else{
             JOptionPane.showMessageDialog(null,"A operacao bbem sucedida");
        }
    }
    
    //SELECT * FROM pessoa WHERE `id_Pessoa`= and `Nome`=
    
}
