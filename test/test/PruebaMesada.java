package test;


import java.io.IOException;

import org.junit.Test;

import edu.unlam.mdg.ArchivoDeMesadas;
import edu.unlam.mdg.Mesada;

public class PruebaMesada {
	@Test
	public void pruebaMesada( ) throws IOException {
		Mesada[] mesadas = ArchivoDeMesadas.leer("test/lotes/in/01_CasoEnunciado.in");
		
		ArchivoDeMesadas.escribir("test/lotes/out/01_CasoEnunciado.out", Mesada.pilaMinima(mesadas));
	}

}
