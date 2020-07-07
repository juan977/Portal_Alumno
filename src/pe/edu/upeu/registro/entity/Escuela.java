package pe.edu.upeu.registro.entity;

public class Escuela {
	private int idescuela;
	private String nombre;
	public Escuela() {
		super();
	}
	public Escuela(int idescuela, String nombre) {
		super();
		this.idescuela = idescuela;
		this.nombre = nombre;
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
