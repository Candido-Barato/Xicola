/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.VO;

/**
 *
 * @author Barato Soft Solution
 */
public class Usuario {
    private String username, senha, acesso, nome_local;
    private int id_local;
    private Byte[] foto;
    private boolean acessar;

    public Usuario(String username, String senha, String acesso, String nome_local, int id_local, Byte[] foto, boolean acessar) {
        this.username = username;
        this.senha = senha;
        this.acesso = acesso;
        this.nome_local = nome_local;
        this.id_local = id_local;
        this.foto = foto;
        this.acessar = acessar;
    }

   

    public Usuario() {
        this("","","","",0,new Byte[0],false);
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getNome_local() {
        return nome_local;
    }

    public void setNome_local(String nome_local) {
        this.nome_local = nome_local;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    public boolean isAcessar() {
        return acessar;
    }

    public void setAcessar(boolean acessar) {
        this.acessar = acessar;
    }
    
    
    
    
}
