package Pruebas;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import edu.unlam.mdg.ArchivoDeMesadas;
import edu.unlam.mdg.Mesada;

public class PruebaMesada {
	@Test
	public void pruebaMesada( ) throws IOException {
		Mesada[] mesadas = ArchivoDeMesadas.leer("src\\Pruebas\\mesada.in");
		
		ArchivoDeMesadas.escribir("src\\Pruebas\\mesada.out", Mesada.pilaMinima(mesadas));
	}

}
