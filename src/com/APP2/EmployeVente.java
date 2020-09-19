package com.APP2;

import java.util.ArrayList;
import java.util.Scanner;


public class EmployeVente extends Employe {
	int chiffreDAffaire;
	
	public EmployeVente(String nom, String prenom, String numeroTelephone, Date dateNaissance, Date dateEmboche, int chiffreDAffaire) {
		super(nom, prenom, numeroTelephone, dateNaissance, dateEmboche);
		this.chiffreDAffaire = chiffreDAffaire;
	}

	@Override
	public void modifierInfo(String champ) {
		if (champ.equals("chiffreDAffaire")) {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Entrez un nouveau chiffre d'affaire : ");
			chiffreDAffaire = sc.nextInt();
			System.out.println("");
		} 
		else {
			super.modifierInfo(champ);
		}
	}
	
	@Override
	public void afficherInfo() {
		super.afficherInfo();
		System.out.println("Secteur : Vente");
		System.out.println("Chiffre d'affaire : " + chiffreDAffaire + " €");
		System.out.println();
	}
	
	@Override
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

		return (int) ((chiffreDAffaire / 3 + 500) * prime);
	}

	public static int salaireTotal(ArrayList<Employe> listeEmployes) {
		int salaireTotal = 0;
		
		for (Employe employe : listeEmployes) {
			if (employe.getClass() == EmployeVente.class) {
				salaireTotal += employe.salaire();
			}
		}
		return salaireTotal;	
	}
}
