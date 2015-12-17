package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static void gravar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO cursos (id, nome, turno, tipo) VALUES (?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, curso.getId());
            comando.setString(2, curso.getNome());
            comando.setString(3, curso.getTurno());
            comando.setString(4, curso.getTipo());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

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

    public static Curso obterCurso(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Curso curso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM cursos WHERE id = " + id);
            rs.first();
            curso = new Curso(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("turno"),
                    rs.getString("tipo")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return curso;
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
        }
    }
       public static void excluir(Curso curso) throws SQLException, ClassNotFoundException{
           Connection conexao = null;
           Statement comando = null;
           String stringSQL;
           
           try {
               conexao = BD.getConexao();
               comando = conexao.createStatement();
               stringSQL = "delete from cursos where id = "+curso.getId();
               comando.execute(stringSQL);
               
           }catch (SQLException e){
               throw e;
           }finally{
               fecharConexao(conexao, comando);
           }
       }
                
       public static void alterar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update cursos set nome = ?, turno = ?, tipo = ? where id =?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(4, curso.getId());
            comando.setString(1, curso.getNome());
            comando.setString(2, curso.getTurno());
            comando.setString(3, curso.getTipo());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
}
