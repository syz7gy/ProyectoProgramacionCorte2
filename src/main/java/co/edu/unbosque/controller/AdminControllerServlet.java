package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.AdministrativoDTO;
import co.edu.unbosque.model.AlcoholicoDTO;
import co.edu.unbosque.model.PersonaDeServiciosDTO;
import co.edu.unbosque.model.PsicologoDTO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.AdministrativoDAO;
import co.edu.unbosque.model.persistence.AlcoholicoDAO;
import co.edu.unbosque.model.persistence.PersonaDeServiciosDAO;
import co.edu.unbosque.model.persistence.PsicologoDAO;
import co.edu.unbosque.model.persistence.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -4331680861219300600L;
	private AdministrativoDAO aDao;
	private AlcoholicoDAO ahDao;
	private PsicologoDAO pDao;
	private PersonaDeServiciosDAO psDao;

	public AdminControllerServlet() {
		psDao = new PersonaDeServiciosDAO();
		pDao = new PsicologoDAO();
		aDao = new AdministrativoDAO();
		ahDao = new AlcoholicoDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("_methodAdmin");
		PrintWriter out = resp.getWriter();
		
		if (action.equals("Login")) {
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

		// AGREGAR ADMINISTRATIVO

		else if (action.equalsIgnoreCase("Sign Up Admin"))

		{
			String name = req.getParameter("nameAdmin");
			long cedula = Long.parseLong(req.getParameter("docAdmin"));
			String userName = req.getParameter("usernameAdmin");
			String password = req.getParameter("pswAdmin");
			String dateBorn = req.getParameter("dateAdmin");
			aDao.create(new AdministrativoDTO(0, name, dateBorn, cedula, userName, password));

			RequestDispatcher rd = req.getRequestDispatcher("message-success.jsp");
			rd.forward(req, resp);

			// AGREGAR ALCOHOLICO
		} else if (action.equalsIgnoreCase("AgregarClient")) {
			String nameCli = req.getParameter("nameCli");
			String userNameCli = req.getParameter("usernameCli");
			String dateBorCli = req.getParameter("bdateCli");
			long cedulaCli = Long.parseLong(req.getParameter("documentCli"));
			int nSesiones = Integer.parseInt(req.getParameter("nSesiones"));
			String apodo = req.getParameter("apodo");
			String passwordCli = req.getParameter("passwordCli");
			ahDao.create(
					new AlcoholicoDTO(0, nameCli, dateBorCli, cedulaCli, userNameCli, passwordCli, nSesiones, apodo));
			RequestDispatcher rd = req.getRequestDispatcher("login-success-admin.jsp");
			rd.forward(req, resp);

			// UPDATE ALCOHOLICO
		} else if (action.equalsIgnoreCase("ActualizarClient")) {
			int id = Integer.parseInt(req.getParameter("idCli"));
			String nameCli = req.getParameter("nameCli");
			String userNameCli = req.getParameter("usernameCli");
			String dateBorCli = req.getParameter("bdateCli");
			long cedulaCli = Long.parseLong(req.getParameter("documentCli"));
			int nSesiones = Integer.parseInt(req.getParameter("nSesiones"));
			String apodo = req.getParameter("apodo");
			String passwordCli = req.getParameter("passwordCli");
			ahDao.updateById(id, nameCli, dateBorCli, cedulaCli, userNameCli, passwordCli, nSesiones, apodo);

			RequestDispatcher rd = req.getRequestDispatcher("login-success-admin.jsp");
			rd.forward(req, resp);

			// MOSTRAR ALCOHOLICO
		} else if (action.equalsIgnoreCase("MostrarClientes")) {

			ahDao.readAll();
			out.print("User list: <br>");
			for (AlcoholicoDTO ahDto : ahDao.getAlcoholicos()) {
				out.write(ahDto.toString() + "<br>");

			}

			// DELETE ALCOHOLICO
		} else if (action.equalsIgnoreCase("EliminarClint")) {
			int id = Integer.parseInt(req.getParameter("idCli"));

			ahDao.deleteById(id);
			RequestDispatcher rd = req.getRequestDispatcher("login-success-admin.jsp");
			rd.forward(req, resp);
		}
		// AGREGAR PSICOLOGO
		else if (action.equalsIgnoreCase("AgregarPsy")) {

			String namePsy = req.getParameter("namePsy");
			String userNamePsy = req.getParameter("usernamePsy");
			String dateBorPsy = req.getParameter("bdatePsy");
			String dateGraPsy = req.getParameter("dateGra");
			int sApo = Integer.parseInt(req.getParameter("sesionesApo"));
			int dServicio = Integer.parseInt(req.getParameter("dServicio"));
			String salario = req.getParameter("salarioPsy");
			long cedulaPsy = Long.parseLong(req.getParameter("documentPsy"));
			String passwordPsy = req.getParameter("passwordPsy");

			pDao.create(new PsicologoDTO(0, namePsy, dateBorPsy, cedulaPsy, userNamePsy, passwordPsy, dateGraPsy,
					dServicio, sApo, salario));

			RequestDispatcher rd = req.getRequestDispatcher("login-success-admin.jsp");
			rd.forward(req, resp);

		}

		// ACTUALIZAR PSICOLOGO
		else if (action.equalsIgnoreCase("ActualizarPsy")) {
			int ID = Integer.parseInt(req.getParameter("idPsy"));
			String namePsy = req.getParameter("namePsy");
			String userNamePsy = req.getParameter("usernamePsy");
			String dateBorPsy = req.getParameter("bdatePsy");
			String dateGraPsy = req.getParameter("dateGra");
			int sApo = Integer.parseInt(req.getParameter("sesionesApo"));
			int dServicio = Integer.parseInt(req.getParameter("dServicio"));
			String salario = req.getParameter("salarioPsy");
			long cedulaPsy = Long.parseLong(req.getParameter("documentPsy"));
			String passwordPsy = req.getParameter("passwordPsy");

			pDao.updateById(ID, namePsy, dateBorPsy, cedulaPsy, userNamePsy, passwordPsy, dateGraPsy, dServicio, sApo,
					salario);

			RequestDispatcher rd = req.getRequestDispatcher("login-success-admin.jsp");
			rd.forward(req, resp);

		}

		// MOSTRAR PSICOLOGO
		else if (action.equalsIgnoreCase("MostrarPsy")) {

			pDao.readAll();
			for (PsicologoDTO pDto : pDao.getPsicologos()) {
				out.write(pDto.toString() + "<br>");
			}

		}

		// ELIMINAR PSICOLOGO
		else if (action.equalsIgnoreCase("EliminarPsy")) {

			int ID = Integer.parseInt(req.getParameter("idPsy"));
			pDao.deleteById(ID);

			RequestDispatcher rd = req.getRequestDispatcher("login-success-admin.jsp");
			rd.forward(req, resp);

		}

		// AGREGAR SERVICIO
		else if (action.equalsIgnoreCase("AgregarSer")) {

			String nameSer = req.getParameter("nameSer");
			String userNameSer = req.getParameter("usernameSer");
			String dateBorSer = req.getParameter("bdateSer");
			long cedulaSer = Long.parseLong(req.getParameter("documentSer"));
			int nSesiones = Integer.parseInt(req.getParameter("nSesionesSer"));
			String salario = req.getParameter("salarioSer");
			String passwordSer = req.getParameter("passwordSer");

			psDao.create(new PersonaDeServiciosDTO(0, nameSer, dateBorSer, cedulaSer, userNameSer, passwordSer, salario,
					nSesiones));
			RequestDispatcher rd = req.getRequestDispatcher("login-success-admin.jsp");
			rd.forward(req, resp);

			// ACTUALIZAR SERVICIO
		} else if (action.equalsIgnoreCase("ActualizarSer")) {
			int ID = Integer.parseInt(req.getParameter("idSer"));
			String nameSer = req.getParameter("nameSer");
			String userNameSer = req.getParameter("usernameSer");
			String dateBorSer = req.getParameter("bdateSer");
			long cedulaSer = Long.parseLong(req.getParameter("documentSer"));
			int nSesiones = Integer.parseInt(req.getParameter("nSesionesSer"));
			String salario = req.getParameter("salarioSer");
			String passwordSer = req.getParameter("passwordSer");

			psDao.updateById(ID, nameSer, dateBorSer, cedulaSer, userNameSer, passwordSer, salario,
					nSesiones);
			RequestDispatcher rd = req.getRequestDispatcher("login-success-admin.jsp");
			rd.forward(req, resp);
		}
		
		//MOSTRAR SERVICIO
		else if(action.equalsIgnoreCase("MostrarSer")) {
			
			psDao.readAll();
			for (PersonaDeServiciosDTO psDto : psDao.getpServicios()) {
				out.write(psDto.toString() + "<br>");
				
			}
		}
		
		//ELIMINAR SERVICIO
		else if(action.equalsIgnoreCase("EliminarSer")) {
			
			int ID = Integer.parseInt(req.getParameter("idSer"));
			psDao.deleteById(ID);
			RequestDispatcher rd = req.getRequestDispatcher("login-success-admin.jsp");
			rd.forward(req, resp);
		}

		else if (action.equalsIgnoreCase("Modificar")) {

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
