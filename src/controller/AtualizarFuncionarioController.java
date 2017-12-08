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
@WebServlet("/AtualizarFuncionarioController")
public class AtualizarFuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarFuncionarioController() {
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
		
		CargoDAO daoC = CargoDAO.getInstance();
		FuncionarioDAO daoF = FuncionarioDAO.getInstance();
		
		request.setAttribute("listaCargos", daoC.findAll());
		request.setAttribute("funcionario", daoF.findByID(id));
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/update-funcionario.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		Integer idCargo = Integer.parseInt(request.getParameter("cargo"));
		Integer id = Integer.parseInt(request.getParameter("id"));

		Funcionario novoFunc = new Funcionario(id, nome, cpf, email, idCargo);

		FuncionarioDAO dao = FuncionarioDAO.getInstance();
		dao.atualizar(novoFunc);

		request.setAttribute("listaFuncionarios", dao.findAll());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-funcionarios.jsp");
		requestDispatcher.forward(request, response);
	}

}
