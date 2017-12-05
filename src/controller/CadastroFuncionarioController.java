package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CargoDAO;
import dao.FuncionarioDAO;
import model.Funcionario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/CadastroFuncionarioController")
public class CadastroFuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroFuncionarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CargoDAO dao = CargoDAO.getInstance();
		request.setAttribute("listaCargos", dao.findAll());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/funcionario.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Integer cpf = Integer.parseInt(request.getParameter("cpf"));
		String email = request.getParameter("email");
		Integer idCargo = Integer.parseInt(request.getParameter("cargo"));

		Funcionario novoFunc = new Funcionario(null, nome, cpf, email, idCargo);

		FuncionarioDAO dao = FuncionarioDAO.getInstance();
		dao.inserir(novoFunc);

		request.setAttribute("listaFuncionarios", dao.findAll());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-funcionarios.jsp");
		requestDispatcher.forward(request, response);
	}

}
