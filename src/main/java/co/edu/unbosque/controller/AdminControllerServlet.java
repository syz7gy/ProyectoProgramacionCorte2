package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.AdministrativoDTO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.AdministrativoDAO;
import co.edu.unbosque.model.persistence.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -4331680861219300600L;
	private AdministrativoDAO aDao;

	public AdminControllerServlet() {
		aDao = new AdministrativoDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// AGREGAR ADMINISTRATIVO
		String action = req.getParameter("_methodAdmin");
		PrintWriter out = resp.getWriter();

		if (action.equalsIgnoreCase("Sign Up Admin")) {
			String name = req.getParameter("nameAdmin");
			long cedula = Long.parseLong(req.getParameter("docAdmin"));
			String userName = req.getParameter("usernameAdmin");
			String password = req.getParameter("pswAdmin");
			String dateBorn = req.getParameter("dateAdmin");
			aDao.create(new AdministrativoDTO(0, name, dateBorn, cedula, userName, password));
			
			RequestDispatcher rd = req.getRequestDispatcher("message-success.jsp");
			rd.forward(req, resp);

			// UPDATE ADMINISTRATIVO
		} else if (action.equalsIgnoreCase("Modificar")) {

			int id = Integer.parseInt(req.getParameter("chageIdAd"));
			String name = req.getParameter("textNom");
			String userName = req.getParameter("userNameAd");
			String dateBorn = req.getParameter("dateBirth");
			long cedula = Long.parseLong(req.getParameter("ced"));
			String password = req.getParameter("con");
			aDao.updateById(id, name, dateBorn, cedula, userName, password);

			RequestDispatcher rl = req.getRequestDispatcher("message-update-success.jsp");
			rl.forward(req, resp);

			// DELETE ADMIN
		} else if (action.equalsIgnoreCase("Delete")) {

			int id = Integer.parseInt(req.getParameter("deleteAdmin"));
			aDao.deleteById(id);

			RequestDispatcher rDeleteAdmin = req.getRequestDispatcher("message-delete-admin.jsp");
			rDeleteAdmin.forward(req, resp);
		}

		// MOSTRAR ADMIN
		else if (action.equals("Mostrar")) {

			aDao.readAll();
			out.print("User list: <br>");
			for (AdministrativoDTO aDto : aDao.getAdministrativos()) {
				out.write(aDto.toString() + "<br>");
			}
		}

		// LOGIN ADMIN
		else if (action.equals("Login")) {
			resp.setContentType("text/html");
			String username = req.getParameter("loginUsernameAdm");
			String password = req.getParameter("loginPasswordAdm");
			boolean status = aDao.validate(new AdministrativoDTO(0, null, null, 0, username, password));

			if (status) {
				RequestDispatcher r2 = req.getRequestDispatcher("login-success-admin.jsp");
				r2.forward(req, resp);
			} else {
				RequestDispatcher r2 = req.getRequestDispatcher("message-error-login.jsp");
				r2.forward(req, resp);
			}
		}

		out.close();
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doHead(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(arg0, arg1);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(arg0, arg1);
	}
}
