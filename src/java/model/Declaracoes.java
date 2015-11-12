package model;

import dao.DeclaracoesDAO;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class Declaracoes {
    
    private int id;
    private boolean residenciaRepublica;
    private boolean naoAtividade;
    private boolean atividadeInformal;
    private boolean inexistenciaContaBancaria;
    private boolean inexistenciaContaBancariaJuridica;
    private Pessoa pessoa;
    private Edital edital;
    
    private int codigoPessoa;
    private int codigoEdital;

    public Declaracoes(int id, boolean residenciaRepublica, boolean naoAtividade, boolean atividadeInformal, 
            boolean inexistenciaContaBancaria, boolean inexistenciaContaBancariaJuridica, Pessoa pessoa, Edital edital) {
        this.id = id;
        this.residenciaRepublica = residenciaRepublica;
        this.naoAtividade = naoAtividade;
        this.atividadeInformal = atividadeInformal;
        this.inexistenciaContaBancaria = inexistenciaContaBancaria;
        this.inexistenciaContaBancariaJuridica = inexistenciaContaBancariaJuridica;
        this.pessoa = pessoa;
        this.edital = edital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isResidenciaRepublica() {
        return residenciaRepublica;
    }

    public void setResidenciaRepublica(boolean residenciaRepublica) {
        this.residenciaRepublica = residenciaRepublica;
    }

    public boolean isNaoAtividade() {
        return naoAtividade;
    }

    public void setNaoAtividade(boolean naoAtividade) {
        this.naoAtividade = naoAtividade;
    }

    public boolean isAtividadeInformal() {
        return atividadeInformal;
    }

    public void setAtividadeInformal(boolean atividadeInformal) {
        this.atividadeInformal = atividadeInformal;
    }

    public boolean isInexistenciaContaBancaria() {
        return inexistenciaContaBancaria;
    }

    public void setInexistenciaContaBancaria(boolean inexistenciaContaBancaria) {
        this.inexistenciaContaBancaria = inexistenciaContaBancaria;
    }

    public boolean isInexistenciaContaBancariaJuridica() {
        return inexistenciaContaBancariaJuridica;
    }

    public void setInexistenciaContaBancariaJuridica(boolean inexistenciaContaBancariaJuridica) {
        this.inexistenciaContaBancariaJuridica = inexistenciaContaBancariaJuridica;
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

    public Edital getEdital() {
        if(this.codigoEdital != 0 && this.edital == null){
            try {
                this.edital = Edital.obterEdital(this.codigoEdital);
            } catch (ClassNotFoundException){
                
            }
        }
        return this.edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public int getCodigoEdital() {
        return codigoEdital;
    }

    public void setCodigoEdital(int codigoEdital) {
        this.codigoEdital = codigoEdital;
    }
    
    public static List<Declaracoes> obterDeclaracoes() throws ClassNotFoundException{
        return DeclaracoesDAO.obterDeclaracoes();
    }
    
}
