package edu.unlam.mdg;


public class Mesada {
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
			
	@Override
	public String toString() {
		return "Largo: " + this.largo + " Ancho: " + this.ancho;
	}

	public static int pilaMinima(Mesada[] mesadas) {
		int cantidadDePilas = 0;//
		Mesada[] mesadasRestantes = mesadas;
		
		for(int i = 0; i < mesadas.length; i ++) {
			if(mesadasRestantes[i].largo != -1) {
				for(int j = i + 1; j < mesadas.length; j ++) {
					if((mesadasRestantes[i].largo >= mesadasRestantes[j].largo && mesadasRestantes[i].ancho >= mesadasRestantes[j].ancho) ||
							(mesadasRestantes[i].largo >= mesadasRestantes[j].ancho && mesadasRestantes[i].ancho >= mesadasRestantes[j].largo)) {
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
