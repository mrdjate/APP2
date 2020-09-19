package com.APP2;

import java.util.ArrayList;
import java.util.Scanner;


public class EmployeProduction extends Employe {
	int nombreDUnitesProduites;

	public EmployeProduction(String nom, String prenom, String numeroTelephone, Date dateNaissance, Date dateEmboche, int nombreDUnitesProduites) {
		super(nom, prenom, numeroTelephone, dateNaissance, dateEmboche);
		this.nombreDUnitesProduites = nombreDUnitesProduites;
	}

	@Override
	public void modifierInfo(String champ) {
		if (champ.equals("nombreDUnitesProduites")) {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Entrez le nouveau nombre d'unités produites mensuellement : ");
			nombreDUnitesProduites = sc.nextInt();
			System.out.println("");
		} 
		else {
			super.modifierInfo(champ);
		}
	}
	
	@Override
	public void afficherInfo() {
		super.afficherInfo();
		System.out.println("Secteur : Production");
		System.out.println("Nombre d'unités produites mensuellement : " + nombreDUnitesProduites);
		System.out.println();
	}
	
	public int salaire() {
		float prime = 1;
		Date tempsDansEntreprise = anciennete();
		
		if ( tempsDansEntreprise.annee < 5 ) {
			prime = (float) 1.02;
		}
		else if ( tempsDansEntreprise.annee < 10 ) {
			prime = (float) 1.05;
		}
		else {
			prime = (float) 1.1;
		}

		return (int) ((nombreDUnitesProduites * 5) * prime);
	}

	public static int salaireTotal(ArrayList<Employe> listeEmployes) {
		int salaireTotal = 0;
		
		for (Employe employe : listeEmployes) {
			if (employe.getClass() == EmployeProduction.class) {
				salaireTotal += employe.salaire();
			}
		}
		return salaireTotal;
	}
}

