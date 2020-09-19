package com.APP2;

import java.util.ArrayList;
import java.util.Scanner;


public class EmployeManutention extends Employe {
	int nombreHeureMois;
	
	public EmployeManutention(String nom, String prenom, String numeroTelephone, Date dateNaissance, Date dateEmboche, int nombreHeureMois) {
		super(nom, prenom, numeroTelephone, dateNaissance, dateEmboche);
		this.nombreHeureMois = nombreHeureMois;
	}

	@Override
	public void modifierInfo(String champ) {
		if (champ.equals("nombreHeureMois")) {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Entrez le nouveau nombre d'heure mensuel : ");
			nombreHeureMois = sc.nextInt();
			System.out.println("");
		} 
		else {
			super.modifierInfo(champ);
		}
	}
	
	@Override
	public void afficherInfo() {
		super.afficherInfo();
		System.out.println("Secteur : Manutention");
		System.out.println("Nombre d'heure mensuel : " + nombreHeureMois);
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

		return (int) ((nombreHeureMois * 70) * prime);
	}

	public static int salaireTotal(ArrayList<Employe> listeEmployes) {
		int salaireTotal = 0;
		
		for (Employe employe : listeEmployes) {
			if (employe.getClass() == EmployeManutention.class) {
				salaireTotal += employe.salaire();
			}
		}
		return salaireTotal;
	}
}
