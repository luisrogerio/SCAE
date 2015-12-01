package model;

import dao.QuadroFamiliarDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class QuadroFamiliar {

    private int id;
    private String doenca;
    private boolean capacidadeTrabalho;
    private boolean dependenciaAtividade;
    private float gastoMensal;
    private FormularioSocioeconomico formularioSocioeconomico;
    private Pessoa pessoa;

    private int codigoFormularioSocioeconomico;
    private String codigoPessoa;

    public QuadroFamiliar(int id, String doenca, boolean capacidadeTrabalho, boolean dependenciaAtividade,
            float gastoMensal, FormularioSocioeconomico formularioSocioeconomico, Pessoa pessoa) {
        this.id = id;
        this.doenca = doenca;
        this.capacidadeTrabalho = capacidadeTrabalho;
        this.dependenciaAtividade = dependenciaAtividade;
        this.gastoMensal = gastoMensal;
        this.formularioSocioeconomico = formularioSocioeconomico;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public boolean isCapacidadeTrabalho() {
        return capacidadeTrabalho;
    }

    public void setCapacidadeTrabalho(boolean capacidadeTrabalho) {
        this.capacidadeTrabalho = capacidadeTrabalho;
    }

    public boolean isDependenciaAtividade() {
        return dependenciaAtividade;
    }

    public void setDependenciaAtividade(boolean dependenciaAtividade) {
        this.dependenciaAtividade = dependenciaAtividade;
    }

    public float getGastoMensal() {
        return gastoMensal;
    }

    public void setGastoMensal(float gastoMensal) {
        this.gastoMensal = gastoMensal;
    }

//    public FormularioSocioeconomico getFormularioSocioeconomico() {
//        if (this.codigoFormularioSocioeconomico != 0 && this.formularioSocioeconomico == null) {
//            try {
//                this.pessoa = FormularioSocioeconomico.obterFormularioSocioeconomico(this.codigoFormularioSocioeconomico);
//            } catch (ClassNotFoundException) {
//
//            }
//        }
//        return this.formularioSocioeconomico;
//    }

    public void setFormularioSocioeconomico(FormularioSocioeconomico formularioSocioeconomico) {
        this.formularioSocioeconomico = formularioSocioeconomico;
    }

//    public Pessoa getPessoa() {
//        if (this.codigoPessoa != 0 && this.pessoa == null) {
//            try {
//                this.pessoa = Pessoa.obterPessoa(this.codigoPessoa);
//            } catch (ClassNotFoundException) {
//
//            }
//        }
//        return this.pessoa;
//    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getCodigoFormularioSocioeconomico() {
        return codigoFormularioSocioeconomico;
    }

    public void setCodigoFormularioSocioeconomico(int codigoFormularioSocioeconomico) {
        this.codigoFormularioSocioeconomico = codigoFormularioSocioeconomico;
    }

    public String getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(String codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public static List<QuadroFamiliar> obterQuadrosFamiliares() throws ClassNotFoundException {
        return QuadroFamiliarDAO.obterQuadrosFamiliares();
    }
    
    public static void gravar(QuadroFamiliar quadroFamiliar) throws ClassNotFoundException, SQLException{
        QuadroFamiliarDAO.gravar(quadroFamiliar);
    }

}
