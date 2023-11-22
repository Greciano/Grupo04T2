package com.ejemplos.spring.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Genero;
import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.model.Plataforma;

@Repository
public class JuegoRepositoryImpl implements JuegoRepository {

	private BufferedReader lector;
	private String linea;
	private String partes[] = null;
	private int numeroEnumeracion = 1;
	private List<Juego> listaJuegos = new ArrayList<>();

	@Override
	public List<Juego> getJuego() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addJuego(Juego juego) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteJuego(int id) {
		// TODO Auto-generated method stub

	}

	public JuegoRepositoryImpl() {
		leerYAlmacenarDatos("src/main/resources/vgsales.csv", listaJuegos);
	}

	public static void leerYAlmacenarDatos(String file, List<Juego> listajuegos) {
		List<String[]> dataList = new ArrayList<>();
		boolean isFirstLine = true;
		int rowsToRead = 16600;

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null && rowsToRead > 0) {
				if (isFirstLine) {
					isFirstLine = false;
					continue;
				}

				String[] row = parseCsvLine(line);

				dataList.add(row);
				rowsToRead--;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String[] row : dataList) {
			String nombre = row[1];
			// Verifica si el año es "N/A" antes de intentar convertirlo
			int fecha;
			if ("N/A".equals(row[3]) || "N64".equals(row[3])) {
				// Asigna un valor predeterminado o haz lo que sea apropiado en tu caso
				fecha = 0; // Puedes cambiarlo al valor que desees o lanzar una excepción, etc.
			} else {
				fecha = Integer.parseInt(row[3]);
			}
			String editor = row[5];
			String plataformastr = row[2];
			String generostr = row[4];
			String euSalesStr = row[7].replace(",", "");
			double euSalesDouble = Double.parseDouble(euSalesStr);

			Plataforma plataforma = Plataforma.fromString(plataformastr);
			Genero genero = Genero.fromString(generostr);

			Juego juego = new Juego(nombre, fecha, editor, plataforma, genero, euSalesDouble);
			listajuegos.add(juego);

			String rutaArchivo = "src/main/resources/archivo.sql";
			generarScript(listajuegos, rutaArchivo);
		}
	}

	private static String[] parseCsvLine(String line) {
		List<String> columns = new ArrayList<>();
		boolean inQuotes = false;
		StringBuilder currentColumn = new StringBuilder();

		for (char c : line.toCharArray()) {
			if (c == '"') {
				inQuotes = !inQuotes;
			} else if (c == ',' && !inQuotes) {
				columns.add(currentColumn.toString().trim());
				currentColumn.setLength(0);
			} else {
				currentColumn.append(c);
			}
		}

		// Agregar la última columna
		columns.add(currentColumn.toString().trim());

		return columns.toArray(new String[0]);
	}

	public static void generarScript(List<Juego> juegos, String rutaArchivo) {
		try (FileWriter writer = new FileWriter(rutaArchivo)) {

			for (Juego juego : juegos) {

				String insertStatement = generarInsertStatement(juego);

				writer.write(insertStatement + ";\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String generarInsertStatement(Juego juego) {

		String insertStatement = String.format(
				"INSERT INTO juegos (nombre, fecha, editor, plataforma, genero, eu_sales) "
						+ "VALUES ('%s', %d, '%s', '%s', '%s', %.2f)",
				juego.getNombre(), juego.getFecha(), juego.getEditor(), juego.getPlataforma().getValor(),
				juego.getGenero().getValor(), juego.getEuSales());

		return insertStatement;
	}

	public void getJuegos() {
		StringBuilder sb = new StringBuilder();
		for (Juego e : listaJuegos) {
			sb.append(e.toString() + "\n");
		}
		System.out.println(sb.toString());

	}

}
