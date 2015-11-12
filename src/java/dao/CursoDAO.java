package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

/**
 *
 * @author Raissa
 */
public class CursoDAO {

    public static List<Curso> obterCursos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Curso> cursos = new ArrayList<Curso>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM cursos");
            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getString("turno")
                );
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cursos;
    }
    
    public static void fecharConexao(Connection conexao, Statement comando){
        try {
            if (comando != null){
                comando.close();   
            }
            if (conexao != null){
                conexao.close();
            }
            }catch (SQLException e){
        }
    }
}
