package model;

import dao.EditalDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class Edital {

    private int id;
    private String ano;
    private int semestre;
    private String descricao;

    public Edital(int id, String ano, int semestre, String descricao) {
        this.id = id;
        this.ano = ano;
        this.semestre = semestre;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static List<Edital> obterEditais() throws ClassNotFoundException {
        return EditalDAO.obterEditais();
    }

    public static void gravar(Edital edital) throws ClassNotFoundException, SQLException {
        EditalDAO.gravar(edital);
    }

}
