/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Candidato;

/**
 *
 * @author Raissa
 */
public class CandidatoDAO {

    public static List<Candidato> obterCandidatos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM candidatos");
            while (rs.next()) {
                Candidato candidato = new Candidato(
                        rs.getString("matricula"),
                        rs.getString("genero"),
                        rs.getString("telefoneResidencial"),
                        rs.getString("telefoneCelular"),
                        rs.getString("instituicaoFundamental"),
                        rs.getString("instituicaoMedio"),
                        null
                );
                candidato.setCodigoPessoa(rs.getInt("pessoa"));
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
    
    public static Candidato obterCandidato(int id) 
            throws ClassNotFoundException{
        Candidato candidato = null;
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
