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

			c.imprimirConSalto("---MENU---");
			c.imprimirConSalto("1. Crear.");
			c.imprimirConSalto("2. Actualizar.");
			c.imprimirConSalto("3. Eliminar.");
			c.imprimirConSalto("4. Mostrar.");
			c.imprimirConSalto("5. Salir.");

			ciclo2: while (true)  {
			String temp = c.leerCadena();
			switch (temp) {
			case "1": {

				c.imprimirConSalto("1. Administrativo\n2. Psicologo\n3. Persona de servicios\n4. Alcoholico ");
				int op = c.leerEntero();
				switch (op) {
				case 1:{
					c.imprimirConSalto("Crear administrativo.");
					c.imprimirConSalto("Ingrese nombre:");
					String nombre = c.leerCadena();
					c.imprimirConSalto("Ingrese cedula:");
					long cedula = c.leerLong();
					c.imprimirConSalto("Ingrese contrasena:");
					String contrasena = c.leerCadena();
					
					adao.create(new AdministrativoDTO(0, nombre, cedula, contrasena));
					System.out.println(adao.toString());
					break ciclo2;
				}
				case 2:{
					c.imprimirConSalto("Crear Psicologo.");
					c.imprimirConSalto("Ingrese nombre:");
					String nombre = c.leerCadena();
					c.imprimirConSalto("Ingrese cedula:");
					long cedula = c.leerLong();
					c.imprimirConSalto("Ingrese contrasena:");
					String contrasena = c.leerCadena();
					c.imprimirConSalto("Ingrese año de graduacion:");
					String aGraduacion = c.leerCadena();
					c.imprimirConSalto("Ingrese dias de servicio:");
					int dServicio = c.leerEntero();
					c.imprimirConSalto("Ingrese sesiones apoyadas:");
					int sApoyada = c.leerEntero();
					c.imprimirConSalto("Ingrese salario:");
					String salario = c.leerCadena();
					
					pdao.create(new PsicologoDTO(0, nombre, cedula, contrasena, aGraduacion, sApoyada, dServicio, salario));
					break ciclo2;
				
				}
				
				case 3: {
					c.imprimirConSalto("Crear Persona de servicios.");
					c.imprimirConSalto("Ingrese nombre:");
					String nombre = c.leerCadena();
					c.imprimirConSalto("Ingrese cedula:");
					long cedula = c.leerLong();
					c.imprimirConSalto("Ingrese contrasena:");
					String contrasena = c.leerCadena();
					c.imprimirConSalto("Ingrese numero de sesiones limpiadas: ");
					int sLimpiadas = c.leerEntero();
					c.imprimirConSalto("Ingrese salario:");
					String salario = c.leerCadena();
					pdsdao.create(new PersonaDeServiciosDTO(0, nombre, cedula, contrasena,sLimpiadas, salario));
					break ciclo2;
					
				}
				
				case 4: {
					
					c.imprimirConSalto("Crear Alcoholico.");
					c.imprimirConSalto("Ingrese nombre:");
					String nombre = c.leerCadena();
					c.imprimirConSalto("Ingrese cedula:");
					long cedula = c.leerLong();
					c.imprimirConSalto("Ingrese contrasena:");
					String contrasena = c.leerCadena();
					c.imprimirConSalto("Ingrese numero de sesiones a las que asistido: ");
					int sLimpiadas = c.leerEntero();
					c.imprimirConSalto("Ingrese apodo:");
					String apodo = c.leerCadena();
					
					aldao.create(new AlcoholicoDTO(0, nombre, cedula, contrasena, sLimpiadas, apodo));
					break ciclo2;
				}
				
				
			}}
//			case "2": {
//
//				if (udao.getusersList().isEmpty()) {
//					break;
//				}
//
//				c.imprimirConSalto("Ingrese el id del usuario que desea actualizar los datos");
//
//				int id = c.leerEntero();
//
//				c.imprimirConSalto("Ingrese su nombre:");
//				c.burnLine();
//				String nombre = c.leerEntero();
//				c.imprimirConSalto("Ingrese su nombre de usuario");
//				String usuario = c.leerEntero();
//				c.imprimirConSalto("Ingrese su contraseña");
//				String contraseña = c.leerEntero();
//
//				if (udao.updateById(id, nombre, usuario, contraseña) == 0) {
//					c.imprimirConSalto("Se ha actalizado con exito");
//				} else {
//					c.imprimirConSalto("Ha ocurrido un problema");
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
//				c.imprimirConSalto("Ingrese el id del usuario que desea eliminar los datos");
//
//				int id = c.leerEntero();
//				c.burnLine();
//				if (udao.deleteById(id) == 0) {
//					c.imprimirConSalto("Se ha eliminado con exito");
//				} else {
//					c.imprimirConSalto("Ha ocurrido un problema");
//				}
//
//				break;
//			}
//			case "4": {
//
//				c.imprimirConSalto(udao.readAll());
//
//				break;
//			}
//			case "5": {
//
//				if (!udao.getusersList().isEmpty()) {
//					c.imprimirConSalto("Ingrese el nombre de el ingreso que desea mostrar:");
//					String nombre = c.leerEntero();
//					c.imprimirConSalto(udao.readByName(nombre));
//				}
//
//				break;
//			}
//			case "6": {
//				c.imprimirConSalto("Saliendo");
//				break ciclo1;
//			}
//
//			default:
//				c.imprimirConSalto("Elija una opcion valida, imbecil");
//				break;
//			}
			}
		}

	}
	}}
