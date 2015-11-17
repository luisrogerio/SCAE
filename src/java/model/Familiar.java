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
    private FormularioSocioeconomico formularioSocioeconomico; 
    
    private int codigoPessoa;
    private int codigoFormularioSocioeconomico;

    public Familiar(int codigoPessoa, String nome, String dataNascimento, String estadoCivil, String CPF, 
            String identidade, int id, String nacionalidade, String parentesco, 
            FormularioSocioeconomico formularioSocioeconomico) {
        super(codigoPessoa, nome, dataNascimento, estadoCivil, CPF, identidade);
        this.id = id;
        this.nacionalidade = nacionalidade;
        this.parentesco = parentesco;
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

    public FormularioSocioeconomico getFormularioSocioeconomico() {
        if(this.codigoFormularioSocioeconomico != 0 && this.formularioSocioeconomico == null){
            try {
                this.formularioSocioeconomico = FormularioSocioeconomico.obterFormularioSocioeconomico(this.codigoFormularioSocioeconomico);
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
