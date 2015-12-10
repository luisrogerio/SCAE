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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Candidato;
import model.Pessoa;

/**
 *
 * @author Raissa
 */
public class CandidatoDAO {

    public static void gravar(Candidato candidato) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            Pessoa pessoa = new Pessoa(candidato.getId(), candidato.getNome(), candidato.getDataNascimento(),
                    candidato.getEstadoCivil(), candidato.getCPF(), candidato.getIdentidade());
            Pessoa.gravar(pessoa);
        } catch (SQLException e) {
            throw e;
        }
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO candidatos (matricula, curso, pessoa, genero, telefoneResidencial, telefoneCelular, instituicaoFundamental, instituicaoMedio) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, candidato.getMatricula());
            comando.setInt(2, candidato.getCodigoCurso());
            comando.setString(3, candidato.getCodigoPessoa());
            comando.setString(4, candidato.getGenero());
            comando.setString(5, candidato.getTelefoneResidencial());
            comando.setString(6, candidato.getTelefoneCelular());
            comando.setString(7, candidato.getInstituicaoFundamental());
            comando.setString(8, candidato.getInstituicaoMedio());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static void alterar(Candidato candidato) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            Pessoa pessoa = new Pessoa(candidato.getId(), candidato.getNome(), candidato.getDataNascimento(),
                    candidato.getEstadoCivil(), candidato.getCPF(), candidato.getIdentidade());
            Pessoa.alterar(pessoa);
        } catch (SQLException e) {
            throw e;
        }
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE candidatos SET curso = ?, pessoa = ?, "
                    + "genero = ?, telefoneResidencial = ?, telefoneCelular = ?, "
                    + "instituicaoFundamental = ?, instituicaoMedio = ? "
                    + "WHERE matricula = ?" ;
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(8, candidato.getMatricula());
            if(candidato.getCurso() == null){
                comando.setNull(1, Types.NULL);
            } else {
                comando.setInt(1, candidato.getCodigoCurso());
            }
            comando.setString(2, candidato.getMatricula());
            comando.setString(3, candidato.getGenero());
            comando.setString(4, candidato.getTelefoneResidencial());
            comando.setString(5, candidato.getTelefoneCelular());
            comando.setString(6, candidato.getInstituicaoFundamental());
            comando.setString(7, candidato.getInstituicaoMedio());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Candidato> obterCandidatos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM candidatos, pessoas WHERE pessoas.id = candidatos.pessoa");
            while (rs.next()) {
                Candidato candidato = new Candidato(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("dataNascimento"),
                        rs.getString("estadoCivil"),
                        rs.getString("CPF"),
                        rs.getString("identidade"),
                        rs.getString("matricula"),
                        rs.getString("genero"),
                        rs.getString("telefoneResidencial"),
                        rs.getString("telefoneCelular"),
                        rs.getString("instituicaoFundamental"),
                        rs.getString("instituicaoMedio"),
                        null
                );
                candidato.setCodigoPessoa(rs.getString("pessoa"));
                candidato.setCodigoCurso(rs.getInt("curso"));
                candidatos.add(candidato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return candidatos;
    }

    public static Candidato obterCandidato(String matricula) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Candidato candidato = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM candidatos, "
                    + "pessoas WHERE pessoas.id = candidatos.pessoa "
                    + "AND candidatos.matricula LIKE \"" + matricula + "\"");
            
            rs.first();
            candidato = new Candidato(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("dataNascimento"),
                    rs.getString("estadoCivil"),
                    rs.getString("CPF"),
                    rs.getString("identidade"),
                    rs.getString("matricula"),
                    rs.getString("genero"),
                    rs.getString("telefoneResidencial"),
                    rs.getString("telefoneCelular"),
                    rs.getString("instituicaoFundamental"),
                    rs.getString("instituicaoMedio"),
                    null
            );
            candidato.setCodigoPessoa(rs.getString("pessoa"));
            candidato.setCodigoCurso(rs.getInt("curso"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return candidato;
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
