package model;

import dao.CursoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class Curso {
    
    private int id;
    private String nome;
    private String turno;
    private String tipo;

    public Curso(int id, String nome, String turno, String tipo) {
        this.id = id;
        this.nome = nome;
        this.turno = turno;
        this.tipo = tipo;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public static List<Curso> obterCursos() throws ClassNotFoundException{
        return CursoDAO.obterCursos();
    }
    
    public static Curso obterCurso(int id) throws ClassNotFoundException{
        return CursoDAO.obterCurso(id);
    }
    
    public static void gravar(Curso curso) throws ClassNotFoundException, SQLException{
        CursoDAO.gravar(curso);
    }
    
    public static void alterar(Curso curso) throws ClassNotFoundException, SQLException{
        CursoDAO.alterar(curso);
    }
    
    public void excluir(Curso curso) throws SQLException,ClassNotFoundException{
        CursoDAO.excluir(curso);
    }
    
}
