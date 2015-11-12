package model;

import dao.EnderecoDAO;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class Endereco {
    
    private int id;
    private String logradouro;
    private String rua;
    private String bairro;
    private String cidade;
    private String UF;
    private String logradouroRepublica;
    private String ruaRepublica;
    private String bairroRepublica;
    private String cidadeRepublica;
    private String UFRepublica;

    public Endereco(int id, String logradouro, String rua, String bairro, String cidade, String UF, 
            String logradouroRepublica, String ruaRepublica, String bairroRepublica, String cidadeRepublica, 
            String UFRepublica) {
        this.id = id;
        this.logradouro = logradouro;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
        this.logradouroRepublica = logradouroRepublica;
        this.ruaRepublica = ruaRepublica;
        this.bairroRepublica = bairroRepublica;
        this.cidadeRepublica = cidadeRepublica;
        this.UFRepublica = UFRepublica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getLogradouroRepublica() {
        return logradouroRepublica;
    }

    public void setLogradouroRepublica(String logradouroRepublica) {
        this.logradouroRepublica = logradouroRepublica;
    }

    public String getRuaRepublica() {
        return ruaRepublica;
    }

    public void setRuaRepublica(String ruaRepublica) {
        this.ruaRepublica = ruaRepublica;
    }

    public String getBairroRepublica() {
        return bairroRepublica;
    }

    public void setBairroRepublica(String bairroRepublica) {
        this.bairroRepublica = bairroRepublica;
    }

    public String getCidadeRepublica() {
        return cidadeRepublica;
    }

    public void setCidadeRepublica(String cidadeRepublica) {
        this.cidadeRepublica = cidadeRepublica;
    }

    public String getUFRepublica() {
        return UFRepublica;
    }

    public void setUFRepublica(String UFRepublica) {
        this.UFRepublica = UFRepublica;
    }
    
    public static List<Endereco> obterEnderecos() throws ClassNotFoundException{
        return EnderecoDAO.obterEnderecos();
    }
    
}
