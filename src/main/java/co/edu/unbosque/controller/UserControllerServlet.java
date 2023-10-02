package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.mapping.List;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

import co.edu.unbosque.model.AdministrativoDTO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.AdministrativoDAO;
import co.edu.unbosque.model.persistence.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -4331680861219300600L;
	private UserDAO uDao;
	private AdministrativoDAO aDao;

	public UserControllerServlet() {
		aDao = new AdministrativoDAO();
		uDao = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.write(aDao.getAdministrativos().toString());
		out.close();

		// PrintWriter out = resp.getWriter();
//		for (UserDTO u : uDao.getusersList()) {
//			out.write(u.toString());
//		}
//		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// AGREGAR ADMINISTRATIVO
		PrintWriter out = resp.getWriter();
		String action = req.getParameter("_method");

		if (action.equalsIgnoreCase("Registrar Administrador")) {
			String nombre = req.getParameter("textNom");
			String cedula = req.getParameter("ced");
			String contraseña = req.getParameter("con");
			aDao.create(new AdministrativoDTO(0, nombre, Long.parseLong(cedula), contraseña));

			RequestDispatcher rd = req.getRequestDispatcher("message-success.jsp");
			rd.forward(req, resp);

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
		// TODO Auto-generated method stub

		super.doDelete(req, resp);
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
