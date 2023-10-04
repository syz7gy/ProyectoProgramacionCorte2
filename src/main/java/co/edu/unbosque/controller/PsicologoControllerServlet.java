package co.edu.unbosque.controller;

import java.io.IOException;

import co.edu.unbosque.model.AdministrativoDTO;
import co.edu.unbosque.model.PsicologoDTO;
import co.edu.unbosque.model.persistence.PsicologoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PsicologoControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1820018526657912541L;
	private PsicologoDAO pDao;

	public PsicologoControllerServlet() {
		pDao = new PsicologoDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("_methodPsy");

		// LOGIN PSICOLOGO
		if (action.equals("Login")) {
			resp.setContentType("text/html");
			String username = req.getParameter("loginUsernamePsy");
			String password = req.getParameter("loginPasswordPsy");
			boolean status = pDao.validate(new PsicologoDTO(0, null, null, 0, username, password, null, 0, 0, null));

			if (status) {
				RequestDispatcher r2 = req.getRequestDispatcher("login-success-psychologist.jsp");
				r2.forward(req, resp);
			} else {
				RequestDispatcher r2 = req.getRequestDispatcher("message-error-login.jsp");
				r2.forward(req, resp);
			}
		}

		else if (action.equalsIgnoreCase("Sign Up Psychologyst")) {

			String name = req.getParameter("namePsy");
			long cedula = Long.parseLong(req.getParameter("docPsy"));
			String userName = req.getParameter("usernamePsy");
			String password = req.getParameter("PasswordPsy");
			String dateBorn = req.getParameter("bdatePsy");
			String dateGrad = req.getParameter("bdatePsyGrad");
			int dServicio = Integer.parseInt(req.getParameter("diaServerPsy"));
			String salario = req.getParameter("Salario");
			int sApoyo = Integer.parseInt(req.getParameter("nSesiones"));
			pDao.create(new PsicologoDTO(0, name, dateBorn, cedula, userName, password, dateGrad, dServicio, sApoyo,
					salario));

			RequestDispatcher rd = req.getRequestDispatcher("login-success-psychologist.jsp");
			rd.forward(req, resp);

		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(req, resp);
	}

}
