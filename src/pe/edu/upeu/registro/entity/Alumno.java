package pe.edu.upeu.registro.entity;

public class Alumno {
	private int idalumno;
	private int idescuela;
	private String nombres;
	private String correo;
	private String telefono;

	public Alumno() {
		super();
	}

	public Alumno(int idalumno, int idescuela, String nombres, String correo, String telefono) {
		super();
		this.idalumno = idalumno;
		this.idescuela = idescuela;
		this.nombres = nombres;
		this.correo = correo;
		this.telefono = telefono;
	}

	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public int getIdescuela() {
		return idescuela;
	}

	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
