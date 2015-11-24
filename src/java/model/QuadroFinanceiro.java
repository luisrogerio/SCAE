package model;

import dao.QuadroFinanceiroDAO;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class QuadroFinanceiro {
    
    private int id;
    private String escolaridade;
    private String situacaoDeTrabalho;
    private String ocupacao;
    private float rendaMensal;
    private FormularioSocioeconomico formularioSocioeconomico;
    private Pessoa pessoa;
    
    private int codigoFormularioSocioeconomico;
    private String codigoPessoa;

    public QuadroFinanceiro(int id, String escolaridade, String situacaoDeTrabalho, String ocupacao, 
            float rendaMensal, FormularioSocioeconomico formularioSocioeconomico, Pessoa pessoa) {
        this.id = id;
        this.escolaridade = escolaridade;
        this.situacaoDeTrabalho = situacaoDeTrabalho;
        this.ocupacao = ocupacao;
        this.rendaMensal = rendaMensal;
        this.formularioSocioeconomico = formularioSocioeconomico;
        this.pessoa = pessoa;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getSituacaoDeTrabalho() {
        return situacaoDeTrabalho;
    }

    public void setSituacaoDeTrabalho(String situacaoDeTrabalho) {
        this.situacaoDeTrabalho = situacaoDeTrabalho;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public float getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(float rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public FormularioSocioeconomico getFormularioSocioeconomico() {
        if(this.codigoFormularioSocioeconomico != 0 && this.formularioSocioeconomico == null){
            try {
                this.pessoa = FormularioSocioeconomico.obterFormularioSocioeconomico(this.codigoFormularioSocioeconomico);
            } catch (ClassNotFoundException){
                
            }
        }
        return this.formularioSocioeconomico;
    }

    public void setFormularioSocioeconomico(FormularioSocioeconomico formularioSocioeconomico) {
        this.formularioSocioeconomico = formularioSocioeconomico;
    }

    public Pessoa getPessoa() {
        if(this.codigoPessoa != 0 && this.pessoa == null){
            try {
                this.pessoa = Pessoa.obterPessoa(this.codigoPessoa);
            } catch (ClassNotFoundException){
                
            }
        }
        return this.pessoa;
    }

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
    
    public static List<QuadroFinanceiro> obterQuadrosFinanceiros() throws ClassNotFoundException{
        return QuadroFinanceiroDAO.obterQuadrosFinanceiros();
    }
    
}
