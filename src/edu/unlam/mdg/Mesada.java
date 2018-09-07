package edu.unlam.mdg;

import java.util.Arrays;

public class Mesada implements Comparable<Mesada>{
	private int largo;
	private int ancho;
	
	public Mesada(int largo, int ancho) {
		if(largo >= 0 && largo <=1000000)
			this.largo = largo;
		else
			this.largo = 0;
			
		if(ancho >= 0 && ancho <=1000000)
			this.ancho = ancho;
		else
			this.ancho = 0;
	}
			
	public Mesada(Mesada otro) {
		this.largo = otro.largo;
		this.ancho = otro.ancho;
	}
	
	public static boolean copiarMesada(Mesada[]m1, Mesada[]m2) {
		if(m1.length < m2.length)
			return false;
		
		for(int i = 0; i < m2.length; i ++)
			m1[i] = new Mesada(m2[i]);
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Largo: " + this.largo + " Ancho: " + this.ancho;
	}
	
	@Override
	public int compareTo(Mesada m) {
		if((this.largo >= m.largo && this.ancho >= m.ancho) || (this.largo >= m.ancho && this.ancho >= m.largo))
			return -1;
		
		if((this.largo == m.largo && this.ancho == m.ancho) || (this.largo == m.ancho && this.ancho == m.largo))
			return 0;
			
		return 1;
	}
	
	public static int pilaMinima(Mesada[] mesadas) {
		//para que directamente devuelva 1 y no realice
		//todo el calculo
		if(mesadas.length == 1)
			return 1;
		
		int cantidadDePilas = 0;
		Mesada[] mesadasRestantes = new Mesada[mesadas.length];
		
		//copio los valores para no modificar el objeto original
		Mesada.copiarMesada(mesadasRestantes, mesadas);		
		//ordeno para facilitar las comparaciones
		Arrays.sort(mesadasRestantes);
		
		Mesada mesadaAnterior = new Mesada(mesadasRestantes[0]);

		//Voy sacando las mesadas que tomo para apilar
		mesadasRestantes[0].largo = -1;
		mesadasRestantes[0].ancho = -1;
		
		for(int i = 0; i < mesadas.length; i ++) {
			if(mesadasRestantes[i].largo != -1) {				 
				for(int j = i + 1; j < mesadas.length; j ++) {
					if((mesadaAnterior.largo >= mesadasRestantes[j].largo && mesadaAnterior.ancho >= mesadasRestantes[j].ancho) ||
							(mesadaAnterior.largo >= mesadasRestantes[j].ancho && mesadaAnterior.ancho >= mesadasRestantes[j].largo)) {
						//la mesada siguiente debe caber dentro de la anterior
						mesadaAnterior = new Mesada(mesadasRestantes[j]);
						mesadasRestantes[j].largo = -1;
						mesadasRestantes[j].ancho = -1;
					}//fin if
				}
								
				cantidadDePilas ++;
			}//fin 	if(mesadasRestantes[i].largo != -1)	
		}
		
		return cantidadDePilas;
	}

	public static Mesada mesadaMasGrande(Mesada[] mesas) {
		Mesada mesaMasGrande = mesas[0];
		
		for(int i=1; i<mesas.length; i++) {
			if(mesas[i].largo >= mesaMasGrande.largo &&  mesas[i].ancho > mesaMasGrande.ancho)
				mesaMasGrande = mesas[i];
		}
		
		return mesaMasGrande;	
	}
}
