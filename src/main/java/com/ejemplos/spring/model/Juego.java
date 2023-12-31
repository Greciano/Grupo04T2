package com.ejemplos.spring.model;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Schema(name = "Juego", description = "Detalles de un juego")
public class Juego {
	@Schema(description = "Nombre del juego", example = "Super Mario Bros.")
	private String nombre;
	@Schema(description = "Año de lanzamiento del juego", example = "1985")
	private int fecha; // Año de lanzamiento del juego
	@Schema(description = "Nombre del editor del juego", example = "Nintendo")
	private String editor; // Nombre del editor del juego
	@Schema(description = "Plataforma en la que se juega", example = "NES")
	private Plataforma plataforma; // Plataforma en la que se juega
	@Schema(description = "Género al que pertenece el juego", example = "Plataformas")
	private Genero genero; // Género al que pertenece el juego
	@Schema(description = "Ventas en Europa del juego", example = "10.5")
	private double euSales;

	/**
	 * Constructor vacío para un juego.
	 */
	public Juego() {
		super();
	}

	/**
	 * Constructor para un juego con atributos iniciales.
	 *
	 * @param nombre     El nombre del juego.
	 * @param fecha      El año de lanzamiento del juego.
	 * @param editor     El nombre del editor del juego.
	 * @param plataforma La plataforma en la que se juega.
	 * @param genero     El género al que pertenece el juego.
	 */
	public Juego(String nombre, int fecha, String editor, Plataforma plataforma, Genero genero, double euSales) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.editor = editor;
		this.plataforma = plataforma;
		this.genero = genero;
		this.euSales = euSales;
	}

	/**
	 * Obtiene el nombre del juego.
	 *
	 * @return El nombre del juego.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del juego.
	 *
	 * @param nombre El nombre del juego.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el año de lanzamiento del juego.
	 *
	 * @return El año de lanzamiento del juego.
	 */
	public int getFecha() {
		return fecha;
	}

	/**
	 * Establece el año de lanzamiento del juego.
	 *
	 * @param fecha El año de lanzamiento del juego.
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el nombre del editor del juego.
	 *
	 * @return El nombre del editor del juego.
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * Establece el nombre del editor del juego.
	 *
	 * @param editor El nombre del editor del juego.
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}

	/**
	 * Obtiene la plataforma en la que se juega el juego.
	 *
	 * @return La plataforma en la que se juega el juego.
	 */
	public Plataforma getPlataforma() {
		return plataforma;
	}

	/**
	 * Establece la plataforma en la que se juega el juego.
	 *
	 * @param plataforma La plataforma en la que se juega el juego.
	 */
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * Obtiene el género al que pertenece el juego.
	 *
	 * @return El género al que pertenece el juego.
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * Establece el género al que pertenece el juego.
	 *
	 * @param genero El género al que pertenece el juego.
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene las ventas de europa del juego.
	 *
	 * @return Las ventas que tiene el juego en europa.
	 */
	public double getEuSales() {
		return euSales;
	}

	/**
	 * Establece las ventas de europa del juego.
	 *
	 * @param euSales ventas que tiene el juego en europa.
	 */
	public void setEuSales(double euSales) {
		this.euSales = euSales;
	}

	/**
	 * Devuelve una representación en forma de cadena de un juego.
	 *
	 * @return Una cadena que representa un juego con sus atributos.
	 */

	@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", fecha=" + fecha + ", editor=" + editor + ", plataforma=" + plataforma
				+ ", genero=" + genero + ", euSales=" + euSales + "]";
	}

}
