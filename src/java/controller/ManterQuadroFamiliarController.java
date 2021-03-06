/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FormularioSocioeconomico;
import model.Pessoa;
import model.QuadroFamiliar;

/**
 *
 * @author Raissa
 */
public class ManterQuadroFamiliarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }
    }

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            request.setAttribute("formulariosSocioeconomicos", FormularioSocioeconomico.obterFormulariosSocioeconomicos());
            RequestDispatcher view = request.getRequestDispatcher("/manterQuadroFamiliar.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("textId"));
        int formulario_socioeconomico = Integer.parseInt(request.getParameter("selectFormularioSocioeconomico"));
        String pessoa = request.getParameter("selectPessoa");
        String doenca = request.getParameter("textDoenca");
        boolean capacidadeTrabalho = null != request.getParameter("checkCapacidadeTrabalho");
        boolean dependenciaAtividade = null != request.getParameter("checkDependenciaAtividades");
        float gastoMensal = Float.parseFloat(request.getParameter("textGastosMensais"));

        try {
            QuadroFamiliar quadroFamiliar = new QuadroFamiliar(id, doenca, capacidadeTrabalho,
                    dependenciaAtividade, gastoMensal, null, null);
            quadroFamiliar.setCodigoFormularioSocioeconomico(formulario_socioeconomico);
            quadroFamiliar.setCodigoPessoa(pessoa);
            QuadroFamiliar.gravar(quadroFamiliar);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaQuadroFamiliarController");
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
            int id = Integer.parseInt(request.getParameter("codigoQuadroFamiliar"));
            QuadroFamiliar quadroFamiliar = QuadroFamiliar.obterQuadroFamiliar(id);
            request.setAttribute("quadroFamiliar", quadroFamiliar);
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            request.setAttribute("formulariosSocioeconomicos", FormularioSocioeconomico.obterFormulariosSocioeconomicos());
            RequestDispatcher view = request.getRequestDispatcher("/manterQuadroFamiliar.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("textId"));
        int formulario_socioeconomico = Integer.parseInt(request.getParameter("selectFormularioSocioeconomico"));
        String pessoa = request.getParameter("selectPessoa");
        String doenca = request.getParameter("textDoenca");
        boolean capacidadeTrabalho = null != request.getParameter("checkCapacidadeTrabalho");
        boolean dependenciaAtividade = null != request.getParameter("checkDependenciaAtividades");
        float gastoMensal = Float.parseFloat(request.getParameter("textGastosMensais"));

        try {
            QuadroFamiliar quadroFamiliar = new QuadroFamiliar(id, doenca, capacidadeTrabalho,
                    dependenciaAtividade, gastoMensal, null, null);
            quadroFamiliar.setCodigoFormularioSocioeconomico(formulario_socioeconomico);
            quadroFamiliar.setCodigoPessoa(pessoa);
            QuadroFamiliar.alterar(quadroFamiliar);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaQuadroFamiliarController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (Exception ex) {

        }
    }
    
    public void prepararExcluir(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            int id = Integer.parseInt(request.getParameter("codigoQuadroFamiliar"));
            request.setAttribute("quadroFamiliar", QuadroFamiliar.obterQuadroFamiliar(id));
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            request.setAttribute("formulariosSocioeconomicos", FormularioSocioeconomico.obterFormulariosSocioeconomicos());
            RequestDispatcher view = request.getRequestDispatcher("/manterQuadroFamiliar.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }
    
    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("textId"));
        int formulario_socioeconomico = 0;
        String pessoa = request.getParameter("selectPessoa");
        String doenca = request.getParameter("textDoenca");
        boolean capacidadeTrabalho = null != request.getParameter("checkCapacidadeTrabalho");
        boolean dependenciaAtividade = null != request.getParameter("checkDependenciaAtividades");
        float gastoMensal = Float.parseFloat(request.getParameter("textGastosMensais"));

        try {
            QuadroFamiliar quadroFamiliar = new QuadroFamiliar(id, doenca, capacidadeTrabalho,
                    dependenciaAtividade, gastoMensal, null, null);
            quadroFamiliar.setCodigoFormularioSocioeconomico(formulario_socioeconomico);
            quadroFamiliar.setCodigoPessoa(pessoa);
            QuadroFamiliar.excluir(quadroFamiliar);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaQuadroFamiliarController");
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
