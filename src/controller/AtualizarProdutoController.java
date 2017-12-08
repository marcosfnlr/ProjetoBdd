package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import model.Produto;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/AtualizarProdutoController")
public class AtualizarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarProdutoController() {
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
		ProdutoDAO dao = ProdutoDAO.getInstance();
		request.setAttribute("produto", dao.findByID(id));
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/update-produto.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		Integer id = Integer.parseInt(request.getParameter("id"));

		Produto novo = new Produto(id, nome, descricao);

		ProdutoDAO dao = ProdutoDAO.getInstance();
		dao.atualizar(novo);

		request.setAttribute("listaProdutos", dao.findAll());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-produtos.jsp");
		requestDispatcher.forward(request, response);
	}

}
