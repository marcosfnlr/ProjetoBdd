package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FornecedorDAO;
import model.Fornecedor;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/AtualizarFornecedorController")
public class AtualizarFornecedorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarFornecedorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		FornecedorDAO dao = FornecedorDAO.getInstance();
		request.setAttribute("fornecedor", dao.findByID(id));
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/update-fornecedor.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String razaoSocial = request.getParameter("razaoSocial");
		String cnpj = request.getParameter("cnpj");
		Integer id = Integer.parseInt(request.getParameter("id"));

		Fornecedor novoForn = new Fornecedor(id, razaoSocial, cnpj);

		FornecedorDAO dao = FornecedorDAO.getInstance();
		dao.atualizar(novoForn);

		request.setAttribute("listaFornecedores", dao.findAll());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-fornecedores.jsp");
		requestDispatcher.forward(request, response);
	}

}
