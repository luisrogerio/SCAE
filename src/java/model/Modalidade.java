package model;

import dao.ModalidadeDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class Modalidade {

    private int id;
    private String nome;

    public Modalidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public static List<Modalidade> obterModalidades() throws ClassNotFoundException {
        return ModalidadeDAO.obterModalidades();
    }
    
    public static Modalidade obterModalidade(int id) throws ClassNotFoundException {
        return ModalidadeDAO.obterModalidade(id);
    }

    public static void gravar(Modalidade modalidade) throws ClassNotFoundException, SQLException {
        ModalidadeDAO.gravar(modalidade);
    }

    public static void alterar(Modalidade modalidade) throws ClassNotFoundException, SQLException {
        ModalidadeDAO.alterar(modalidade);
    }

}
