package edu.unlam.mdg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoDeMesadas {
	public static Mesada[] leer(String direccion) throws FileNotFoundException {
		File entrada = new File(direccion);
		Scanner sc = new Scanner(entrada);
		int cantidadMesadas = sc.nextInt();
		Mesada[] mesadas = new Mesada[cantidadMesadas];
		
		for(int i = 0; i < cantidadMesadas; i ++)
			mesadas[i] = new Mesada(sc.nextInt(), sc.nextInt());
		
		sc.close();
		
		return mesadas;
	}
	
	public static void escribir(String direccion, int pilas) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(direccion));
		
		salida.println(pilas);
		salida.close();
	}
}
