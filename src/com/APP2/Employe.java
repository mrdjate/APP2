package com.APP2;

import java.util.ArrayList;
import java.util.Scanner;


public abstract class Employe
{
	String nom;
	String prenom;
	String numeroTelephone;
	Date dateNaissance;
	Date dateEmboche;
	
	public Employe(String nom, String prenom, String numeroTelephone, Date dateNaissance, Date dateEmboche)
    {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelephone = numeroTelephone;
		this.dateNaissance = dateNaissance;
		this.dateEmboche = dateEmboche;
	}
	
	public void modifierInfo(String champ) {
		Scanner sc = new Scanner(System.in);
		
		switch (champ) {
		
			case "nom":
				System.out.print("Entrez un nouveau nom : ");
				nom = sc.nextLine();
				System.out.println("");
				break;
				
			case "prenom":
				System.out.print("Entrez un nouveau prenom : ");
				prenom = sc.nextLine();
				System.out.println("");
				break;
				
			case "numeroTelephone":
				System.out.print("Entrez un nouveau numerode telephone : ");
				numeroTelephone = sc.nextLine();
				System.out.println("");
				break;
				
			case "dateNaissance":
				System.out.println("Entrez une nouvelle date de naissance :");
				System.out.print("Jour : ");
				dateNaissance.jour = sc.nextInt();
				System.out.print("Mois : ");
				dateNaissance.mois = sc.nextInt();
				System.out.print("Année : ");
				dateNaissance.annee = sc.nextInt();
				System.out.println("");
				break;
				
			case "dateEmboche":
				System.out.println("Entrez une nouvelle date d'emboche :");
				System.out.print("Jour : ");
				dateEmboche.jour = sc.nextInt();
				System.out.print("Mois : ");
				dateEmboche.mois = sc.nextInt();
				System.out.print("Année : ");
				dateEmboche.annee = sc.nextInt();
				System.out.println("");
				break;
				
			default:
				System.out.println("Employe : modifierInfo : default : Le champ n'a pas ete reconnu.\n");
				break;
		}
	}
	
	public void afficherInfo() {
		Date tempsDansEntreprise = anciennete();
		System.out.println("\nNom : " + nom);
		System.out.println("Prenom : " + prenom);
		System.out.println("Numero de telephone : " + numeroTelephone);
		System.out.println("Date de naissance : " + dateNaissance.jour + "/" + dateNaissance.mois + "/" + dateNaissance.annee);
		System.out.println("Date d'emboche : " + dateEmboche.jour + "/" + dateEmboche.mois + "/" + dateEmboche.annee);
		System.out.println("Ancienneté : " + tempsDansEntreprise.annee + " années " + tempsDansEntreprise.mois + " mois " + tempsDansEntreprise.jour + " jour ");
		System.out.println("Salaire : " + salaire() + " €");
	}

	protected Date anciennete() {
		Date tempsDansEntreprise = new Date(0, 0, 0);
		return tempsDansEntreprise;
	}
	
	abstract public int salaire();
	
	public static int salaireTotal(ArrayList<Employe> listeEmployes) {
		int salaireTotal = 0;
		
		for (Employe employe : listeEmployes) {
			salaireTotal += employe.salaire();
		}
		return salaireTotal;
	}

	public static int salaireMoyen(ArrayList<Employe> listeEmployes) {
		return salaireTotal(listeEmployes) / listeEmployes.size();
	}
}
