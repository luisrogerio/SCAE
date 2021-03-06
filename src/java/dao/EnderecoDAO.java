/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.CursoDAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import model.Endereco;

/**
 *
 * @author Raissa
 */
public class EnderecoDAO {

    public static void gravar(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO enderecos (id, logradouro, rua, bairro, cidade, UF, logradouroRepublica, ruaRepublica, bairroRepublica, cidadeRepublica, UFRepublica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, endereco.getId());
            comando.setString(2, endereco.getLogradouro());
            comando.setString(3, endereco.getRua());
            comando.setString(4, endereco.getBairro());
            comando.setString(5, endereco.getCidade());
            comando.setString(6, endereco.getUF());
            comando.setString(7, endereco.getLogradouroRepublica());
            comando.setString(8, endereco.getRuaRepublica());
            comando.setString(9, endereco.getBairroRepublica());
            comando.setString(10, endereco.getCidadeRepublica());
            comando.setString(11, endereco.getUFRepublica());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE enderecos SET logradouro = ?, rua = ?, bairro = ?, "
                    + "cidade = ?, UF = ?, logradouroRepublica = ?, "
                    + "ruaRepublica = ?, bairroRepublica = ?, cidadeRepublica = ?, "
                    + "UFRepublica = ? WHERE id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(11, endereco.getId());
            comando.setString(1, endereco.getLogradouro());
            comando.setString(2, endereco.getRua());
            comando.setString(3, endereco.getBairro());
            comando.setString(4, endereco.getCidade());
            comando.setString(5, endereco.getUF());
            comando.setString(6, endereco.getLogradouroRepublica());
            comando.setString(7, endereco.getRuaRepublica());
            comando.setString(8, endereco.getBairroRepublica());
            comando.setString(9, endereco.getCidadeRepublica());
            comando.setString(10, endereco.getUFRepublica());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Endereco> obterEnderecos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Endereco> enderecos = new ArrayList<Endereco>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM enderecos");
            while (rs.next()) {
                Endereco endereco = new Endereco(
                        rs.getInt("id"),
                        rs.getString("logradouro"),
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("UF"),
                        rs.getString("logradouroRepublica"),
                        rs.getString("ruaRepublica"),
                        rs.getString("bairroRepublica"),
                        rs.getString("cidadeRepublica"),
                        rs.getString("UFRepublica")
                );
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return enderecos;
    }

    public static Endereco obterEndereco(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Endereco endereco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM enderecos WHERE id = " + id);
            rs.first();
            endereco = new Endereco(
                    rs.getInt("id"),
                    rs.getString("logradouro"),
                    rs.getString("rua"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("UF"),
                    rs.getString("logradouroRepublica"),
                    rs.getString("ruaRepublica"),
                    rs.getString("bairroRepublica"),
                    rs.getString("cidadeRepublica"),
                    rs.getString("UFRepublica")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return endereco;
    }
    
    public static void excluir(Endereco endereco) throws SQLException, ClassNotFoundException{
           Connection conexao = null;
           Statement comando = null;
           String stringSQL;
           
           try {
               conexao = BD.getConexao();
               comando = conexao.createStatement();
               stringSQL = "delete from enderecos where id = "+endereco.getId();
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
