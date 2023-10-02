package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -4331680861219300600L;
	private UserDAO uDao;

	public UserControllerServlet() {
		uDao = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		for (UserDTO u : uDao.getusersList()) {
			out.write(u.toString());
		}
//		out.write("Holi :3");
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean status = uDao.validate(new UserDTO(0, username, password, password));
		log(username);
		log(password);
		PrintWriter out = resp.getWriter();
		if(status) {
//			out.write("jajaj lo encontre :V");
			RequestDispatcher rd = req.getRequestDispatcher("login-success.jsp");
			rd.forward(req, resp);
			
		}else {
//			out.write("Usuario o contraseña incorrecta");
			RequestDispatcher re = req.getRequestDispatcher("login-error.jsp");
			re.forward(req, resp);
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
