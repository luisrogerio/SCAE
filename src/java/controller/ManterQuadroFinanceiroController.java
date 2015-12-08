/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.FormularioSocioeconomico;
import model.Pessoa;
import model.QuadroFinanceiro;

/**
 *
 * @author Raissa
 */
public class ManterQuadroFinanceiroController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        }
        else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        }/* else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }*/
    }

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            request.setAttribute("formulariosSocioeconomicos", FormularioSocioeconomico.obterFormulariosSocioeconmicos());
            RequestDispatcher view = request.getRequestDispatcher("/manterQuadroFinanceiro.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex){
            
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("textId"));
        int formulario_socioeconomico = Integer.parseInt(request.getParameter("selectFormularioSocioeconomico"));
        String pessoa = request.getParameter("selectPessoa");
        String escolaridade = request.getParameter("textEscolaridade");
        String situacaoDeTrabalho = request.getParameter("textSituacaoDeTrabalho");
        String ocupacao = request.getParameter("textOcupacao");
        float rendaMensal = Float.parseFloat(request.getParameter("textRendaMensal"));

        try {
            QuadroFinanceiro quadroFinanceiro = new QuadroFinanceiro(id, escolaridade, situacaoDeTrabalho, 
                    ocupacao, rendaMensal, null, null);
            quadroFinanceiro.setCodigoFormularioSocioeconomico(formulario_socioeconomico);
            quadroFinanceiro.setCodigoPessoa(pessoa);
            QuadroFinanceiro.gravar(quadroFinanceiro);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaQuadroFinanceiroController");
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
