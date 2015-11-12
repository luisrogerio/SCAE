package model;

import dao.ModalidadeDAO;
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
    
    public static List<Modalidade> obterModalidades() throws ClassNotFoundException{
        return ModalidadeDAO.obterModalidades();
    }
    
}
