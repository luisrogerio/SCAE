/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Candidato;
import model.Curso;

/**
 *
 * @author Raissa
 */
public class ManterCandidatoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        }
        else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        }  else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } /*else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }*/
    }

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("cursos", Curso.obterCursos());
            RequestDispatcher view = request.getRequestDispatcher("/manterCandidato.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        String matricula = request.getParameter("textMatricula");
        String nome = request.getParameter("textNome");
        String dataNascimento = request.getParameter("textDataNascimento");
        String estadoCivil = request.getParameter("textEstadoCivil");
        String CPF = request.getParameter("textCPF");
        String identidade = request.getParameter("textIdentidade");
        int curso = Integer.parseInt(request.getParameter("selectCurso"));
        String genero = request.getParameter("textGenero");
        String telefoneResidencial = request.getParameter("textTelefoneResidencial");
        String telefoneCelular = request.getParameter("textTelefoneCelular");
        String instituicaoFundamental = request.getParameter("textInstituicaoFundamental");
        String instituicaoMedio = request.getParameter("textInstituicaoMedio");

        try {
            Candidato candidato = new Candidato(matricula, nome, 
                    dataNascimento, estadoCivil, CPF, identidade, 
                    matricula, genero, telefoneResidencial, 
                    telefoneCelular, instituicaoFundamental, instituicaoMedio, null);
            candidato.setCodigoCurso(curso);
            candidato.setCodigoPessoa(matricula);
            Candidato.gravar(candidato);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCandidatoController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (Exception ex) {

        }
    }
    
    public void prepararEditar(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("cursos", Curso.obterCursos());
            String matricula = request.getParameter("codigoCandidato");
            Candidato candidato = Candidato.obterCandidato(matricula);
            request.setAttribute("candidato", Candidato.obterCandidato(matricula));
            RequestDispatcher view = request.getRequestDispatcher("/manterCandidato.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }
    
    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        String matricula = request.getParameter("textMatricula");
        String nome = request.getParameter("textNome");
        String dataNascimento = request.getParameter("textDataNascimento");
        String estadoCivil = request.getParameter("textEstadoCivil");
        String CPF = request.getParameter("textCPF");
        String identidade = request.getParameter("textIdentidade");
        int curso = Integer.parseInt(request.getParameter("selectCurso"));
        String genero = request.getParameter("textGenero");
        String telefoneResidencial = request.getParameter("textTelefoneResidencial");
        String telefoneCelular = request.getParameter("textTelefoneCelular");
        String instituicaoFundamental = request.getParameter("textInstituicaoFundamental");
        String instituicaoMedio = request.getParameter("textInstituicaoMedio");

        try {
            Candidato candidato = new Candidato(matricula, nome, 
                    dataNascimento, estadoCivil, CPF, identidade, 
                    matricula, genero, telefoneResidencial, 
                    telefoneCelular, instituicaoFundamental, instituicaoMedio, null);
            candidato.setCodigoCurso(curso);
            candidato.setCodigoPessoa(matricula);
            Candidato.alterar(candidato);//VAI MUDAR PARA 'ALTERAR'
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCandidatoController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (Exception ex) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
