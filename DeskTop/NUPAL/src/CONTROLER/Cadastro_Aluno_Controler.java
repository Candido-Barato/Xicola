/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLER;

import MODEL.DAO.AlunoDao;
import MODEL.VO.Aluno;
import VIEW.Formacao.Cadastro_Aluno;
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
        this.viewAluno.getJcRelacionameto().addActionListener(this);
        this.viewAluno.getJcRelacionameto().addActionListener(this);
        this.viewAluno.getJcTipoDoc().addActionListener(this);
        this.viewAluno.getJcNac().addActionListener(this);
    }

    public void preencherDadosComponentes() {
        dadosC = new Dados_Controler();
        viewAluno.getJcTipoDoc().addItem("B.I (Bilhete de identidade)");
        viewAluno.getJcTipoDoc().addItem("Cedula");
        viewAluno.getJcTipoDoc().addItem("Boletim de Nascimento");
        viewAluno.getJcEstadoC().addItem("Solteiro");
        viewAluno.getJcEstadoC().addItem("Casado");
        viewAluno.getJcSexo().addItem("Masculino");
        viewAluno.getJcSexo().addItem("Femenino");
        
        viewAluno.getJcRelacionameto().addItem("Auto-Encarregado");
        viewAluno.getJcRelacionameto().addItem("Pai");
        viewAluno.getJcRelacionameto().addItem("Mae");
        viewAluno.getJcRelacionameto().addItem("Outro");
        
        dadosC.buscarPaises();
        dadosC.getDadosComponete().getPaises().forEach((t) -> {
            viewAluno.getJcNac().addItem(t.getNome_());
        });
        dadosC.buscarPronvicias(1);
        dadosC.getDadosComponete().getPronvicias().forEach((t) -> {
            viewAluno.getJcNat().addItem(t.getNome_());
            viewAluno.getJcProv().addItem(t.getNome_());
        });
        dadosC.buscarDistritos(-1);
        dadosC.getDadosComponete().getDistritos().forEach((t) -> {
            viewAluno.getJcDistrito().addItem(t.getNome_());
        });
        dadosC.buscarBairros(-1);
        dadosC.getDadosComponete().getBairro().forEach((t) -> {
            viewAluno.getJcBairro().addItem(t.getNome_());
        });

    }

    public Cadastro_Aluno_Controler() {
        this(new Cadastro_Aluno(), new Aluno(), new AlunoDao());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == viewAluno.getJbVoltar()) {
            componet--;
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
                    componet = 3;
                    break;
            }
        }
        if (ae.getSource() == viewAluno.getJbCancelar()) {
            JOptionPane.showMessageDialog(viewAluno, "Cancelar");
        }
        if (ae.getSource() == viewAluno.getJcRelacionameto()) {
            viewAluno.getJtTipoRelacionamento().setVisible(viewAluno.getJcRelacionameto().getSelectedItem().equals("Outro"));
            viewAluno.getJtNomeEnc().setVisible(viewAluno.getJcRelacionameto().getSelectedItem().equals("Outro"));
            viewAluno.getJfContactoEnc().setVisible(viewAluno.getJcRelacionameto().getSelectedItem().equals("Outro"));
            viewAluno.getJtProfissaoEnc().setVisible(viewAluno.getJcRelacionameto().getSelectedIndex() != -1 && !viewAluno.getJcRelacionameto().getSelectedItem().equals("Auto - Encarregado"));
            viewAluno.getJtLocalTrabEnc().setVisible(viewAluno.getJcRelacionameto().getSelectedIndex() != -1 && !viewAluno.getJcRelacionameto().getSelectedItem().equals("Auto - Encarregado"));
        }
        if (ae.getSource() == viewAluno.getJcTipoDoc()) {
            viewAluno.getJtNr_Doc().setEnabled(viewAluno.getJcTipoDoc().getSelectedIndex() != -1);
            viewAluno.getJcLocEmissao().setEnabled(viewAluno.getJcTipoDoc().getSelectedIndex() != -1);
            viewAluno.getJdDataEmissao().setEnabled(viewAluno.getJcTipoDoc().getSelectedIndex() != -1);
        }
        if (ae.getSource() == viewAluno.getJcNac()) {
            boolean stado = false;
            if (viewAluno.getJcNac().getSelectedIndex() != -1) {
                for (int i = 0; i < dadosC.getDadosComponete().getPaises().size() && stado == false; i++) {
                    stado = dadosC.getDadosComponete().getPaises().get(i).getNome_().equals(viewAluno.getJcNac().getSelectedItem().toString());
                    if (stado) {
                        dadosC.buscarPronvicias(dadosC.getDadosComponete().getPaises().get(i).getId());
                        viewAluno.getJcNat().removeAllItems();
                        dadosC.getDadosComponete().getPronvicias().forEach((t) -> {
                            viewAluno.getJcNat().addItem(t.getNome_());
                        });
                        viewAluno.getJcNat().repaint();

                    }
                }
                dadosC.getDadosComponete().getPaises().forEach((t) -> {
                    viewAluno.getJcNac().addItem(t.getNome_());
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
