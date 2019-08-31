/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Barato Soft Solution
 */
public class Filiacao {
    
        private String nomePai, nomeMae, profPai, profMae;
        private int nrTellPai, nrTellMae;
        public Filiacao() {
            this("","","","",0,0);
        }

    public Filiacao(String nomePai, String nomeMae, String profPai, String profMae, int nrTellPai, int nrTellMae) {
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.profPai = profPai;
        this.profMae = profMae;
        this.nrTellPai = nrTellPai;
        this.nrTellMae = nrTellMae;
    }
        

        public String getNomePai() {
            return nomePai;
        }

        public void setNomePai(String nomePai) {
            this.nomePai = nomePai;
        }

        public String getNomeMae() {
            return nomeMae;
        }

        public void setNomeMae(String nomeMae) {
            this.nomeMae = nomeMae;
        }

        public String getProfPai() {
            return profPai;
        }

        public void setProfPai(String profPai) {
            this.profPai = profPai;
        }

        public String getProfMae() {
            return profMae;
        }

        public void setProfMae(String profMae) {
            this.profMae = profMae;
        }

        public int getNrTellPai() {
            return nrTellPai;
        }

        public void setNrTellPai(int nrTellPai) {
            this.nrTellPai = nrTellPai;
        }

        public int getNrTellMae() {
            return nrTellMae;
        }

        public void setNrTellMae(int nrTellMae) {
            this.nrTellMae = nrTellMae;
        }
        
        
        
    }
    
