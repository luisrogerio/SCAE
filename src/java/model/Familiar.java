package model;

import dao.FamiliarDAO;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class Familiar extends Pessoa{
    
    private int id;
    private String nacionalidade;
    private String parentesco;
    private Pessoa pessoa;
    private FormularioSocioeconomico formularioSocioeconomico; 
    
    private int codigoPessoa;
    private int codigoFormularioSocioeconomico;

    public Familiar(int id, String nacionalidade, String parentesco, Pessoa pessoa, 
            FormularioSocioeconomico formularioSocioeconomico) {
        this.id = id;
        this.nacionalidade = nacionalidade;
        this.parentesco = parentesco;
        this.pessoa = pessoa;
        this.formularioSocioeconomico = formularioSocioeconomico;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
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

    public int getCodigoFormularioSocioeconomico() {
        return codigoFormularioSocioeconomico;
    }

    public void setCodigoFormularioSocioeconomico(int codigoFormularioSocioeconomico) {
        this.codigoFormularioSocioeconomico = codigoFormularioSocioeconomico;
    }

    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }
    
    public static List<Familiar> obterFamiliares() throws ClassNotFoundException{
        return FamiliarDAO.obterFamiliares();
    }
    
}
