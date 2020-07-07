package pe.edu.upeu.registro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.registro.dao.AlumnoDao;
import pe.edu.upeu.registro.dao.EscuelaDao;
import pe.edu.upeu.registro.daoImp.AlumnoDaoImp;
import pe.edu.upeu.registro.daoImp.EscuelaDaoImp;
import pe.edu.upeu.registro.entity.Alumno;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/hc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlumnoDao alm = new AlumnoDaoImp();
	private EscuelaDao esc = new EscuelaDaoImp();
	private Gson g = new Gson();
	int idal, ides;
	String nmc, cor, tel;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch (op) {
		case 1:
			// Listar Escuelas
			out.println(g.toJson(esc.readAll()));
			break;
		case 2:
			// Listar Alumnos
			out.println(g.toJson(alm.readAll()));
			break;
		case 3:
			// Registrar Alumno
			alm.create(new Alumno(0, Integer.parseInt(request.getParameter("cat")), request.getParameter("nmc"),
					request.getParameter("cor"), request.getParameter("tel")));
			out.println(g.toJson("Registro guardado correctamente"));
			break;
		case 4:
			//Buscar Alumno Por ID
			out.println(g.toJson(alm.read(Integer.parseInt(request.getParameter("id")))));
			break;
		case 5:
			//Eliminar Alumno 
			int x = alm.delete(Integer.parseInt(request.getParameter("id")));
			out.println(g.toJson(x));
			break;
		case 6:
			//Modificar Alumno
			idal = Integer.parseInt(request.getParameter("idal"));
			ides = Integer.parseInt(request.getParameter("idesc"));
			nmc = request.getParameter("nmc");
			cor = request.getParameter("cor");
			tel = request.getParameter("tel");
			out.println(g.toJson(alm.update(new Alumno(idal, ides, nmc, cor, tel))));
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
