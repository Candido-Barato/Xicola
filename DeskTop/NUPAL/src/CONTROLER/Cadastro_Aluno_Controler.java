/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLER;

import static CONTROLER.Dados_Controler.vlc;
import MODEL.DAO.AlunoDao;
import MODEL.VO.Aluno;
import VIEW.Formacao.Cadastro_Aluno;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Barato Soft Solution
 */
public class Cadastro_Aluno_Controler implements ActionListener {

    private Cadastro_Aluno viewAluno;
    private Aluno modelAluno;
    private AlunoDao daoAluno;
    private byte componet = 1;
    private Dados_Controler dadosC;

    public Cadastro_Aluno_Controler(Cadastro_Aluno viewAluno, Aluno modelAluno, AlunoDao daoAluno) {
        this.viewAluno = viewAluno;
        this.modelAluno = modelAluno;
        this.daoAluno = daoAluno;
        this.viewAluno.Config();
    }

    public void chamarEnvetos() {
        this.viewAluno.getJbCancelar().addActionListener(this);
        this.viewAluno.getJbProximo().addActionListener(this);
        this.viewAluno.getJbVoltar().addActionListener(this);
        this.viewAluno.getJpStep_03().getJcRelacionameto().addActionListener(this);
        this.viewAluno.getJpStep_01().getJcTipoDoc().addActionListener(this);
        this.viewAluno.getJpStep_01().getJcNac().addActionListener(this);

    }

    public void preencherDadosComponentes() {
        dadosC = new Dados_Controler();
        viewAluno.getJpStep_01().getJcTipoDoc().addItem("B.I (Bilhete de identidade)");
        viewAluno.getJpStep_01().getJcTipoDoc().addItem("Cedula");
        viewAluno.getJpStep_01().getJcTipoDoc().addItem("Boletim de Nascimento");
        viewAluno.getJpStep_01().getJcEstadoC().addItem("Solteiro");
        viewAluno.getJpStep_01().getJcEstadoC().addItem("Casado");
        viewAluno.getJpStep_01().getJcSexo().addItem("Masculino");
        viewAluno.getJpStep_01().getJcSexo().addItem("Femenino");

        viewAluno.getJpStep_03().getJcRelacionameto().addItem("Auto-Encarregado");
        viewAluno.getJpStep_03().getJcRelacionameto().addItem("Pai");
        viewAluno.getJpStep_03().getJcRelacionameto().addItem("Mae");
        viewAluno.getJpStep_03().getJcRelacionameto().addItem("Outro");

        dadosC.buscarPaises();
        dadosC.getDadosComponete().getPaises().forEach((t) -> {
            viewAluno.getJpStep_01().getJcNac().addItem(t.getNome_());
        });
        dadosC.buscarPronvicias(1);
        dadosC.getDadosComponete().getPronvicias().forEach((t) -> {
            viewAluno.getJpStep_01().getJcNat().addItem(t.getNome_());
            viewAluno.getJpStep_02().getJcProv().addItem(t.getNome_());
        });
        dadosC.buscarDistritos(-1);
        dadosC.getDadosComponete().getDistritos().forEach((t) -> {
            viewAluno.getJpStep_02().getJcDistrito().addItem(t.getNome_());
        });
        dadosC.buscarBairros(-1);
        dadosC.getDadosComponete().getBairro().forEach((t) -> {
            viewAluno.getJpStep_02().getJcBairro().addItem(t.getNome_());
        });
        this.viewAluno.addPainelCentro(viewAluno.getJpStep_01());
        viewAluno.getJpStep_01().getJcTipoDoc().setSelectedIndex(-1);
        viewAluno.getJpStep_03().getJcRelacionameto().setSelectedIndex(-1);

    }

    public Cadastro_Aluno_Controler() {
        this(new Cadastro_Aluno(), new Aluno(), new AlunoDao());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == viewAluno.getJbVoltar()) {
            componet--;
            viewAluno.getJbVoltar().setEnabled(componet != 1);
            if (componet == 3) {
                viewAluno.getJbProximo().setText("Salvar");
            } else {
                viewAluno.getJbProximo().setText("Proximo");
            }
            switch (componet) {
                case 1:
                    viewAluno.addPainelCentro(viewAluno.getJpStep_01());
                    break;
                case 2:
                    viewAluno.addPainelCentro(viewAluno.getJpStep_02());
                    break;
                case 3:

                    viewAluno.addPainelCentro(viewAluno.getJpStep_03());
                    break;
                default:
                    componet = 1;
                    break;
            }
        }
        if (ae.getSource() == viewAluno.getJbProximo()) {
            componet++;
            viewAluno.getJbVoltar().setEnabled(componet != 1);
           
            switch (componet) {
                case 1:
                    viewAluno.addPainelCentro(viewAluno.getJpStep_01());
                    break;
                case 2:
                if(!vlc.validString(viewAluno.getJpStep_01().getJtNome().getText(), (byte)2, (byte)40)){
                    viewAluno.getJpStep_01().getJtNome().setToolTipText(vlc.getTextoErro());
                };
                    viewAluno.addPainelCentro(viewAluno.getJpStep_02());
                    break;
                case 3:
                    viewAluno.addPainelCentro(viewAluno.getJpStep_03());
                    break;
                default:
                    componet = 3;
                    break;
            }
            if (componet == 3) {
                viewAluno.getJbProximo().setText("Salvar");
                viewAluno.getJbProximo().setBackground(Color.GREEN);
            } else {
                 viewAluno.getJbProximo().setBackground(Color.BLUE);
                viewAluno.getJbProximo().setText("Proximo");
            }
        }
        if (ae.getSource() == viewAluno.getJbCancelar()) {
            JOptionPane.showMessageDialog(viewAluno, "Cancelar");
        }
        if (ae.getSource() == viewAluno.getJpStep_03().getJcRelacionameto()) {
              JOptionPane.showMessageDialog(viewAluno, viewAluno.getJpStep_03().getJcRelacionameto().getSelectedIndex());
            if(viewAluno.getJpStep_03().getJcRelacionameto().getSelectedIndex() != -1){
                JOptionPane.showMessageDialog(viewAluno, viewAluno.getJpStep_03().getJcRelacionameto().getSelectedIndex());
            viewAluno.getJpStep_03().getJtTipoRelacionamento().setVisible(viewAluno.getJpStep_03().getJcRelacionameto().getSelectedIndex() != -1 && viewAluno.getJpStep_03().getJcRelacionameto().getSelectedItem().equals("Outro"));
            viewAluno.getJpStep_03().getJtNomeEnc().setVisible(viewAluno.getJpStep_03().getJcRelacionameto().getSelectedIndex() != -1 && viewAluno.getJpStep_03().getJcRelacionameto().getSelectedItem().equals("Outro"));
            viewAluno.getJpStep_03().getJfContactoEnc().setVisible(viewAluno.getJpStep_03().getJcRelacionameto().getSelectedIndex() != -1 && viewAluno.getJpStep_03().getJcRelacionameto().getSelectedItem().equals("Outro"));
            viewAluno.getJpStep_03().getJtProfissaoEnc().setVisible(!viewAluno.getJpStep_03().getJcRelacionameto().getSelectedItem().equals("Auto-Encarregado"));
            viewAluno.getJpStep_03().getJtLocalTrabEnc().setVisible(!viewAluno.getJpStep_03().getJcRelacionameto().getSelectedItem().equals("Auto-Encarregado"));
            
            }
            
        }
        if (ae.getSource() == viewAluno.getJpStep_01().getJcTipoDoc()) {
            viewAluno.getJpStep_01().getJtNr_Doc().setVisible(viewAluno.getJpStep_01().getJcTipoDoc().getSelectedIndex() != -1);
            viewAluno.getJpStep_01().getJcLocEmissao().setVisible(viewAluno.getJpStep_01().getJcTipoDoc().getSelectedIndex() != -1);
            viewAluno.getJpStep_01().getJdDataEmissao().setVisible(viewAluno.getJpStep_01().getJcTipoDoc().getSelectedIndex() != -1);
        }
        if (ae.getSource() == viewAluno.getJpStep_01().getJcNac()) {
            boolean stado = false;
            if (viewAluno.getJpStep_01().getJcNac().getSelectedIndex() != -1) {
                for (int i = 0; i < dadosC.getDadosComponete().getPaises().size() && stado == false; i++) {
                    stado = dadosC.getDadosComponete().getPaises().get(i).getNome_().equals(viewAluno.getJpStep_01().getJcNac().getSelectedItem().toString());
                    if (stado) {
                        dadosC.buscarPronvicias(dadosC.getDadosComponete().getPaises().get(i).getId());
                        viewAluno.getJpStep_01().getJcNat().removeAllItems();
                        dadosC.getDadosComponete().getPronvicias().forEach((t) -> {
                            viewAluno.getJpStep_01().getJcNat().addItem(t.getNome_());
                        });
                        viewAluno.getJpStep_01().getJcNat().repaint();

                    }
                }
                dadosC.getDadosComponete().getPaises().forEach((t) -> {
                    viewAluno.getJpStep_01().getJcNac().addItem(t.getNome_());
                });

            }
        }

    }

    public Cadastro_Aluno getViewAluno() {
        return viewAluno;
    }

    public void setViewAluno(Cadastro_Aluno viewAluno) {
        this.viewAluno = viewAluno;
    }

}
