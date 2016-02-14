/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Modalidade;

/**
 *
 * @author Raissa
 */
public class ModalidadeDAO {

    public static void gravar(Modalidade modalidade) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO modalidades (id, nome) VALUES (?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, modalidade.getId());
            comando.setString(2, modalidade.getNome());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Modalidade modalidade) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE modalidades SET nome = ? WHERE id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(2, modalidade.getId());
            comando.setString(1, modalidade.getNome());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Modalidade> obterModalidades() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Modalidade> modalidades = new ArrayList<Modalidade>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM modalidades");
            while (rs.next()) {
                Modalidade modalidade = new Modalidade(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
                modalidades.add(modalidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return modalidades;
    }
    
    public static List<Integer> obterCodigosModalidadesDoFormularioSocioeconomico(int formularioSocioeconomicoId) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Integer> modalidades = new ArrayList<>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM modalidades_formulario_economico WHERE formulario_socioeconomico_id = " + formularioSocioeconomicoId);
            while (rs.next()) {
                modalidades.add(rs.getInt("modalidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return modalidades;
    }

    public static Modalidade obterModalidade(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Modalidade modalidade = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM modalidades WHERE id = " + id);
            rs.first();
            modalidade = new Modalidade(
                    rs.getInt("id"),
                    rs.getString("nome")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return modalidade;
    }
    
    public static void excluir(Modalidade modalidade) throws SQLException, ClassNotFoundException{
           Connection conexao = null;
           Statement comando = null;
           String stringSQL;
           
           try {
               conexao = BD.getConexao();
               comando = conexao.createStatement();
               stringSQL = "delete from modalidades where id = "+modalidade.getId();
               comando.execute(stringSQL);
               
           }catch (SQLException e){
               throw e;
           }finally{
               fecharConexao(conexao, comando);
           }
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
}
