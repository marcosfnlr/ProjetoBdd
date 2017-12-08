package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompraDAO;
import dao.ProdutoDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/AtualizarCompraController")
public class AtualizarCompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarCompraController() {
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
		CompraDAO dao = CompraDAO.getInstance();
		ProdutoDAO daoP = ProdutoDAO.getInstance();
		request.setAttribute("produtos", daoP.getProdutosCompra(id));
		request.setAttribute("compra", dao.findByID(id));
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/update-compra.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
