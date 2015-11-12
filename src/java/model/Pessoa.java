package model;

import dao.PessoaDAO;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class Pessoa {
    
    private int id;
    private String nome;
    private String dataNascimento;
    private String estadoCivil;
    private String CPF;
    private String identidade;

    public Pessoa(int id, String nome, String dataNascimento, String estadoCivil, String CPF, String identidade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.CPF = CPF;
        this.identidade = identidade;
    }
    
    public Pessoa(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }
    
    public static List<Pessoa> obterPessoas() throws ClassNotFoundException{
        return PessoaDAO.obterPessoas();
    }
    
}
