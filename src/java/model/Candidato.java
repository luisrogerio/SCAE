package model;

import dao.CandidatoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class Candidato extends Pessoa {

    private String matricula;
    private String genero;
    private String telefoneResidencial;
    private String telefoneCelular;
    private String instituicaoFundamental;
    private String instituicaoMedio;
    private Curso curso;
    private String codigoPessoa;

    private int codigoCurso;

    public Candidato(String id, String nome, String dataNascimento, String estadoCivil, String CPF, String identidade, String matricula, String genero, String telefoneResidencial, String telefoneCelular,
            String instituicaoFundamental, String instituicaoMedio, Curso curso) {
        super(id, nome, dataNascimento, estadoCivil, CPF, identidade);
        this.matricula = matricula;
        this.genero = genero;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneCelular = telefoneCelular;
        this.instituicaoFundamental = instituicaoFundamental;
        this.instituicaoMedio = instituicaoMedio;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getInstituicaoFundamental() {
        return instituicaoFundamental;
    }

    public void setInstituicaoFundamental(String instituicaoFundamental) {
        this.instituicaoFundamental = instituicaoFundamental;
    }

    public String getInstituicaoMedio() {
        return instituicaoMedio;
    }

    public void setInstituicaoMedio(String instituicaoMedio) {
        this.instituicaoMedio = instituicaoMedio;
    }
//
//    public Curso getCurso() {
//        if (this.codigoCurso != 0 && this.curso == null) {
//            try {
//                this.curso = Curso.obterCurso(this.codigoCurso);
//            } catch (ClassNotFoundException) {
//
//            }
//        }
//
//        return this.curso;
//    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(String codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public static List<Candidato> obterCandidatos() throws ClassNotFoundException {
        return CandidatoDAO.obterCandidatos();
    }

    public static Candidato obterCandidato(int matricula) throws ClassNotFoundException {
        return CandidatoDAO.obterCandidato(matricula);
    }

    public static void gravar(Candidato candidato) throws ClassNotFoundException, SQLException {
        CandidatoDAO.gravar(candidato);
    }

}
