package com.ejemplos.spring.model;

public class JuegoDTO {
	private String nombre;
	private int fecha;
	private String editor;
	private String plataforma;
	private String genero;
	private double euSales;

	public JuegoDTO() {
	}

	public JuegoDTO(String nombre, int fecha, String editor, String plataforma, String genero, double euSales) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.editor = editor;
		this.plataforma = plataforma;
		this.genero = genero;
		this.euSales = euSales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getEuSales() {
		return euSales;
	}

	public void setEuSales(double euSales) {
		this.euSales = euSales;
	}
}
