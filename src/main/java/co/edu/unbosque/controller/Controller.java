package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.AdministrativoDAO;
import co.edu.unbosque.model.persistence.AlcoholicoDAO;
import co.edu.unbosque.model.persistence.PersonaDeServiciosDAO;
import co.edu.unbosque.model.persistence.PsicologoDAO;
import co.edu.unbosque.model.persistence.UserDAO;
import co.edu.unbosque.view.Console;

public class Controller {

	private Console c;
	private AdministrativoDAO adao;
	private PsicologoDAO pdao;
	private PersonaDeServiciosDAO pdsdao;
	private AlcoholicoDAO aldao;
	
	public Controller() {
		c = new Console();
		adao = new AdministrativoDAO();
		pdao = new PsicologoDAO();
		pdsdao = new PersonaDeServiciosDAO();
		aldao = new AlcoholicoDAO();
	}

	public void run() {

		ciclo1: while (true) {

			c.printLine("---MENU---");
			c.printLine("1. Crear.");
			c.printLine("2. Actualizar.");
			c.printLine("3. Eliminar.");
			c.printLine("4. Mostrar.");
			c.printLine("5. Salir.");

			ciclo2: while (true) {
			String temp = c.readLine();
			switch (temp) {
			case "1": {

				c.printLine("1. Administrativo\n2. Psicologo\n3. Persona de servicios\n4. Alcoholico ");
				int op = c.readInt();
				switch (op) {
				case 1:{
					c.printLine("Crear administrativo.");
					c.printLine("Ingrese nombre:");
					String nombre = c.readLine();
					c.burnLine();
					c.printLine("Ingrese cedula:");
					long cedula = c.readLong();
					c.burnLine();
					c.printLine("Ingrese contrasena:");
					String contrasena = c.readLine();
					
					adao.create(new AdministrativoDTO(0, nombre, cedula, contrasena));
					break ciclo2;
				}
				case 2:{
					c.printLine("Crear Psicologo.");
					c.printLine("Ingrese nombre:");
					String nombre = c.readLine();
					c.burnLine();
					c.printLine("Ingrese cedula:");
					long cedula = c.readLong();
					c.printLine("Ingrese contrasena:");
					String contrasena = c.readLine();
					c.burnLine();
					c.printLine("Ingrese año de graduacion:");
					String aGraduacion = c.readLine();
					c.printLine("Ingrese dias de servicio:");
					int dServicio = c.readInt();
					c.printLine("Ingrese sesiones apoyadas:");
					int sApoyada = c.readInt();
					c.burnLine();
					c.printLine("Ingrese salario:");
					String salario = c.readLine();
					
					pdao.create(new PsicologoDTO(0, nombre, cedula, contrasena, aGraduacion, sApoyada, dServicio, salario));
					break ciclo2;
				
				}
				
				case 3: {
					c.printLine("Crear Persona de servicios.");
					c.printLine("Ingrese nombre:");
					String nombre = c.readLine();
					c.burnLine();
					c.printLine("Ingrese cedula:");
					long cedula = c.readLong();
					c.printLine("Ingrese contrasena:");
					String contrasena = c.readLine();
					c.burnLine();
					c.printLine("Ingrese numero de sesiones limpiadas: ");
					int sLimpiadas = c.readInt();
					c.printLine("Ingrese salario:");
					String salario = c.readLine();
					
					pdsdao.create(new PersonaDeServiciosDTO(0, nombre, cedula, contrasena,sLimpiadas, salario));
					
					break ciclo2;
					
				}
				
				case 4: {
					
					c.printLine("Crear Alcoholico.");
					c.printLine("Ingrese nombre:");
					String nombre = c.readLine();
					c.burnLine();
					c.printLine("Ingrese cedula:");
					long cedula = c.readLong();
					c.printLine("Ingrese contrasena:");
					String contrasena = c.readLine();
					c.burnLine();
					c.printLine("Ingrese numero de sesiones a las que asistido: ");
					int sLimpiadas = c.readInt();
					c.burnLine();
					c.printLine("Ingrese apodo:");
					String apodo = c.readLine();
					
					aldao.create(new AlcoholicoDTO(0, nombre, cedula, contrasena, sLimpiadas, apodo));
					
				}
				
				
			}}
//			case "2": {
//
//				if (udao.getusersList().isEmpty()) {
//					break;
//				}
//
//				c.printLine("Ingrese el id del usuario que desea actualizar los datos");
//
//				int id = c.readInt();
//
//				c.printLine("Ingrese su nombre:");
//				c.burnLine();
//				String nombre = c.readLine();
//				c.printLine("Ingrese su nombre de usuario");
//				String usuario = c.readLine();
//				c.printLine("Ingrese su contraseña");
//				String contraseña = c.readLine();
//
//				if (udao.updateById(id, nombre, usuario, contraseña) == 0) {
//					c.printLine("Se ha actalizado con exito");
//				} else {
//					c.printLine("Ha ocurrido un problema");
//				}
//
//				break;
//			}
//			case "3": {
//
//				if (udao.getusersList().isEmpty()) {
//					break;
//				}
//
//				c.printLine("Ingrese el id del usuario que desea eliminar los datos");
//
//				int id = c.readInt();
//				c.burnLine();
//				if (udao.deleteById(id) == 0) {
//					c.printLine("Se ha eliminado con exito");
//				} else {
//					c.printLine("Ha ocurrido un problema");
//				}
//
//				break;
//			}
//			case "4": {
//
//				c.printLine(udao.readAll());
//
//				break;
//			}
//			case "5": {
//
//				if (!udao.getusersList().isEmpty()) {
//					c.printLine("Ingrese el nombre de el ingreso que desea mostrar:");
//					String nombre = c.readLine();
//					c.printLine(udao.readByName(nombre));
//				}
//
//				break;
//			}
//			case "6": {
//				c.printLine("Saliendo");
//				break ciclo1;
//			}
//
//			default:
//				c.printLine("Elija una opcion valida, imbecil");
//				break;
//			}
			}
		}

	}
	}}
