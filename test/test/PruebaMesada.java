package test;


import java.io.IOException;

import org.junit.Test;

import edu.unlam.mdg.ArchivoDeMesadas;
import edu.unlam.mdg.Mesada;

public class PruebaMesada {
	@Test
	public void testMetodoQueBuscaLaMesaMasGrande( ) throws IOException {
		Mesada[] mesas = new Mesada[10];
		
		mesas[0] = new Mesada(2, 1);
		mesas[1] = new Mesada(7, 9);
		mesas[2] = new Mesada(5, 3);
		mesas[3] = new Mesada(10, 15);
		mesas[4] = new Mesada(4, 1);
		mesas[5] = new Mesada(1, 5);
		mesas[6] = new Mesada(9, 4);
		mesas[7] = new Mesada(30, 36);
		mesas[8] = new Mesada(30, 35);
		mesas[9] = new Mesada(2, 2);
		
		Mesada mesaMasGrande = Mesada.mesadaMasGrande(mesas);
		
		System.out.println(mesaMasGrande);
	}
	
	@Test
	public void testCasoEnunciado( ) throws IOException {
		Mesada[] mesadas = ArchivoDeMesadas.leer("test/lotes/in/01_CasoEnunciado.in");
		
		ArchivoDeMesadas.escribir("test/lotes/out/01_CasoEnunciado.out", Mesada.pilaMinima(mesadas));
	}
	
	@Test
	public void testUnaSolaMesada( ) throws IOException {
		Mesada[] mesadas = ArchivoDeMesadas.leer("test/lotes/in/02_UnaSolaMesada.in");
		
		ArchivoDeMesadas.escribir("test/lotes/out/02_UnaSolaMesada.out", Mesada.pilaMinima(mesadas));
	}
	
	@Test
	public void testElegirLaMejorAgrupacion( ) throws IOException {
		Mesada[] mesadas = ArchivoDeMesadas.leer("test/lotes/in/03_ElegirLaMejorAgrupacion.in");
		
		ArchivoDeMesadas.escribir("test/lotes/out/03_ElegirLaMejorAgrupacion.out", Mesada.pilaMinima(mesadas));
	}

}
