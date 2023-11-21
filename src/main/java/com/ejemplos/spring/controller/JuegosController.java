package com.ejemplos.spring.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ejemplos.spring.model.Genero;
import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.model.Plataforma;

public class JuegosController {

	private BufferedReader lector;
	private String linea;
	private String partes[] = null;
	private int numeroEnumeracion = 1;
	private List<Juego> listaJuegos = new ArrayList<>();

	public JuegosController() {
		leerYAlmacenarDatos("src/main/resources/vgsales.csv", listaJuegos);
	}

	public static void leerYAlmacenarDatos(String file, List<Juego> listajuegos) {
		List<String[]> dataList = new ArrayList<>();
		boolean isFirstLine = true;
		int rowsToRead = 100; // Cambia este valor para controlar cuántas filas leer

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null && rowsToRead > 0) {
				if (isFirstLine) {
					isFirstLine = false;
					continue;
				}
				String[] row = line.split(",");

				dataList.add(row);
				rowsToRead--;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String[] row : dataList) {
			String nombre = row[1];
			int fecha = Integer.parseInt(row[3]);
			String editor = row[5];
			String plataformastr = row[2];
			String generostr = row[4];
			String euSalesStr = row[7].replace(",", "");
			double euSalesDouble = Double.parseDouble(euSalesStr);

			Plataforma plataforma = Plataforma.fromString(plataformastr);
			Genero genero = Genero.fromString(generostr);

			Juego juego = new Juego(nombre, fecha, editor, plataforma, genero, euSalesDouble);
			listajuegos.add(juego);
		}

	}

	public void getJuegos() {
		StringBuilder sb = new StringBuilder();
		for (Juego e : listaJuegos) {
			sb.append(e.toString() + "\n");
		}
		System.out.println(sb.toString());

	}

}
