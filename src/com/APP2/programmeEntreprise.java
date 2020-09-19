package com.APP2;

import java.util.ArrayList;
import java.util.Scanner;


public class programmeEntreprise {
	
	private static void ajouterEmploye(ArrayList<Employe> listeEmployes) {
		System.out.println("\n\n\nAJOUTER UN EMPLOYE :\n");

		Scanner sc = new Scanner(System.in);
		int choix = 0;
		String nom;
		String prenom;
		String numeroTelephone;
		Date dateNaissance = new Date(0, 0, 0);
		Date dateEmboche = new Date(0, 0, 0);
		
		System.out.print("Entrez le nom : ");
		nom = sc.nextLine();
		
		System.out.print("\nEntrez le prenom : ");
		prenom = sc.nextLine();
		
		System.out.print("\nEntrez le numero de téléphone : ");
		numeroTelephone = sc.nextLine();
		
		System.out.println("\nEntrez la date de naissance : ");
		System.out.print("Jour : ");
		dateNaissance.jour = sc.nextInt();
		System.out.print("Mois : ");
		dateNaissance.mois = sc.nextInt();
		System.out.print("Année : ");
		dateNaissance.annee = sc.nextInt();
		
		System.out.println("\nEntrez la date d'emboche : ");
		System.out.print("Jour : ");
		dateEmboche.jour = sc.nextInt();
		System.out.print("Mois : ");
		dateEmboche.mois = sc.nextInt();
		System.out.print("Année : ");
		dateEmboche.annee = sc.nextInt();
		
		System.out.println("\nEntrez le secteur :");
		System.out.println("1 : Vente");
		System.out.println("2 : Production");
		System.out.println("3 : Manutention");
		System.out.print("\nEntrez votre choix : ");
		choix = sc.nextInt();
		
		switch (choix) {
		
			case 1:
				int chiffreDAffaire;
				System.out.print("\nEntrez le chiffre d'affaire : ");
				chiffreDAffaire = sc.nextInt();
				listeEmployes.add(new EmployeVente(
						nom,
						prenom,
						numeroTelephone,
						dateNaissance,
						dateEmboche,
						chiffreDAffaire));
				break;
				
			case 2:
				int nombreDUnitesProduites;
				System.out.print("\nEntrez le nombre d'unités produites mensuellement : ");
				nombreDUnitesProduites = sc.nextInt();
				listeEmployes.add(new EmployeProduction(
						nom,
						prenom,
						numeroTelephone,
						dateNaissance,
						dateEmboche,
						nombreDUnitesProduites));
				break;
				
			case 3:
				int nombreHeureMois;
				System.out.print("\nEntrez le nombre d'heure mensuel : ");
				nombreHeureMois = sc.nextInt();
				listeEmployes.add(new EmployeManutention(
						nom,
						prenom,
						numeroTelephone,
						dateNaissance,
						dateEmboche,
						nombreHeureMois));
				break;
				
			default:
				System.out.println("\nVotre choix n'est pas valide.");
				System.out.println("Le secteur par defaut sera la vente.");

				int chiffreDAffaire2;
				System.out.print("\nEntrez le chiffre d'affaire : ");
				chiffreDAffaire2 = sc.nextInt();
				listeEmployes.add(new EmployeVente(
						nom,
						prenom,
						numeroTelephone,
						dateNaissance,
						dateEmboche,
						chiffreDAffaire2));
				break;							
		}
		
		System.out.println("\nBienvenu " + prenom + " " + nom + " !");
	}
	
	private static void supprimerEmploye(ArrayList<Employe> listeEmployes) {
		System.out.println("\n\n\nSUPPRIMER UN EMPLOYE :\n");
		
		int i;
		int indice = -1;
		Scanner sc = new Scanner(System.in);
		String nom;
		String prenom;
		
		System.out.print("Entrez le nom : ");
		nom = sc.nextLine();
		
		System.out.print("\nEntrez le prenom : ");
		prenom = sc.nextLine();

		
		for (i = 0; i < listeEmployes.size(); i++) {
			if (nom.equals(listeEmployes.get(i).nom) && 
				prenom.equals(listeEmployes.get(i).prenom)) {
				
				indice = i;
			}
		}

		if (indice == -1 || indice == listeEmployes.size()) {
			System.out.println("\nAucun employé se nomme " + nom + " " + prenom + ".");
		}
		else {
			System.out.println("\n" + nom + " " + prenom + " à été supprimé.");
			listeEmployes.remove(indice);
		}
	}
	
	private static void modifierEmploye(ArrayList<Employe> listeEmployes) {
		System.out.println("\n\n\nMODIFIER UN EMPLOYE :\n");
		
		int i;
		int indice = -1;
		Scanner sc = new Scanner(System.in);
		String nom;
		String prenom;
		
		System.out.print("Entrez le nom : ");
		nom = sc.nextLine();
		
		System.out.print("\nEntrez le prenom : ");
		prenom = sc.nextLine();

		
		for (i = 0; i < listeEmployes.size(); i++) {
			if (nom.equals(listeEmployes.get(i).nom) && 
				prenom.equals(listeEmployes.get(i).prenom)) {
				
				indice = i;
			}
		}

		if (indice == -1 || indice == listeEmployes.size()) {
			System.out.println("\nAucun employé se nomme " + nom + " " + prenom + ".");
		}
		else {
			listeEmployes.get(indice).afficherInfo();
			int choix;
			
			System.out.println("\nQuel champ souhaitez vous modifier :");
			System.out.println("1 : nom");
			System.out.println("2 : prenom");
			System.out.println("3 : numero de telephone");
			System.out.println("4 : date de naissance");
			System.out.println("5 : date d'emboche");
			if (listeEmployes.get(indice).getClass() == EmployeVente.class) {
				System.out.println("6 : chiffre d'affaire");
			}
			else if (listeEmployes.get(indice).getClass() == EmployeProduction.class) {
				System.out.println("6 : nombre d'unités produites mensuellement");
			}
			else if (listeEmployes.get(indice).getClass() == EmployeManutention.class) {
				System.out.println("6 : nombre d'heure mensuel");
			}
			System.out.print("\nEntrez votre choix : ");
			choix = sc.nextInt();
			
			switch (choix) {
			
				case 1:
					listeEmployes.get(indice).modifierInfo("nom");
					System.out.println("Le champ nom de " + nom + " " + prenom + " à été modifié.");
					break;

				case 2:
					listeEmployes.get(indice).modifierInfo("prenom");
					System.out.println("Le champ prenom de " + nom + " " + prenom + " à été modifié.");
					break;
					
				case 3:
					listeEmployes.get(indice).modifierInfo("numeroTelephone");
					System.out.println("Le champ numero de téléphone de " + nom + " " + prenom + " à été modifié.");
					break;
				
				case 4:
					listeEmployes.get(indice).modifierInfo("dateNaissance");
					System.out.println("Le champ date naissance de " + nom + " " + prenom + " à été modifié.");
					break;
					
				case 5:
					listeEmployes.get(indice).modifierInfo("dateEmboche");
					System.out.println("Le champ date d'emboche de " + nom + " " + prenom + " à été modifié.");
					break;
				
				case 6:
					if (listeEmployes.get(indice).getClass() == EmployeVente.class) {
						listeEmployes.get(indice).modifierInfo("chiffreDAffaire");
						System.out.println("Le champ chiffre d'affaire de " + nom + " " + prenom + " à été modifié.");
						}
					else if (listeEmployes.get(indice).getClass() == EmployeProduction.class) {
						listeEmployes.get(indice).modifierInfo("nombreDUnitesProduites");
						System.out.println("Le champ nombre d'unités produites mensuellement de " + nom + " " + prenom + " à été modifié.");
						}
					else if (listeEmployes.get(indice).getClass() == EmployeManutention.class) {
						listeEmployes.get(indice).modifierInfo("nombreHeureMois");
						System.out.println("Le champ nombre d'heure mensuel de " + nom + " " + prenom + " à été modifié.");
						}
					break;
					
				default:
					System.out.println("Votre choix n'est pas valide.\n");
					break;
			}
		}
	}

	private static void afficherInfoEmploye(ArrayList<Employe> listeEmployes) {
		System.out.println("\n\n\nINFORMATION D'UN EMPLOYE :\n");
		
		boolean affiche = false;
		Scanner sc = new Scanner(System.in);
		String nom;
		String prenom;
		
		System.out.print("Entrez le nom : ");
		nom = sc.nextLine();
		
		System.out.print("\nEntrez le prenom : ");
		prenom = sc.nextLine();

		for (Employe employe : listeEmployes) {
			
			if (nom.equals(employe.nom) && 
				prenom.equals(employe.prenom)) {
					
					employe.afficherInfo();
					affiche = true;
				}
			}
		

		if (!affiche) {
			System.out.println("\nAucun employé se nomme " + nom + " " + prenom + ".");
		}
	}
	
	public static void main(String[] args) {
		Boolean continuer = true;
		Scanner sc = new Scanner(System.in);
		int choix = 0;

		ArrayList<Employe> listeEmployes = new ArrayList<>();
		
		listeEmployes.add(new EmployeVente(
				"MARTIN",
				"Jean-Loup",
				"06 07 08 09 10 11",
				new Date(12, 04, 1998),
				new Date(10, 10, 2008),
				10000));
		
		listeEmployes.add(new EmployeProduction(
				"ATEUR",
				"Nordine",
				"06 11 11 11 11 11",
				new Date(13, 05, 1999),
				new Date(11, 11, 2009),
				400));
		
		listeEmployes.add(new EmployeManutention(
				"DANLOS",
				"Ella",
				"06 12 12 12 12 12",
				new Date(11, 03, 2000),
				new Date(9, 9, 2007),
				100));
		
		listeEmployes.add(new EmployeVente(
				"ONETTE",
				"Camille",
				"06 13 13 13 13 13",
				new Date(01, 01, 01),
				new Date(01, 01, 2012),
				15000));
		
		
		
		while (continuer)
		{
			System.out.println("\n\nMENU :");
			System.out.println("1 : Ajouter un employé");
			System.out.println("2 : Supprimer un employé");
			System.out.println("3 : Modifier les informations d'un employé");
			System.out.println("4 : Afficher les informations d'un employé");
			System.out.println("5 : Afficher les informations de tous les employés");
			System.out.println("6 : Afficher la somme des salaires selon leurs secteurs");
			System.out.println("7 : Quitter le programme");
			System.out.print("\nEntrez votre choix : ");
			choix = sc.nextInt();
			
			switch (choix) {
			
				case 1:
					ajouterEmploye(listeEmployes);
					break;

				case 2:
					supprimerEmploye(listeEmployes);
					break;
					
				case 3:
					modifierEmploye(listeEmployes);
					break;
				
				case 4:
					afficherInfoEmploye(listeEmployes);
					break;
					
				case 5:
					System.out.println("\n\n\nINFORMATIONS DE TOUS LES EMPLOYES :\n");
					for (Employe employe : listeEmployes) {
						employe.afficherInfo();; 
					}
					break;
					
				case 6:
					System.out.println("\n\n\nSOMME DES SALAIRES SELON LEURS SECTEURS :\n");

					System.out.println("salaire total du secteur vente : " + EmployeVente.salaireTotal(listeEmployes));
					System.out.println("salaire total du secteur production : " + EmployeProduction.salaireTotal(listeEmployes));
					System.out.println("salaire total du secteur manutention : " + EmployeManutention.salaireTotal(listeEmployes));
					
					System.out.println("\nsalaire total : " + Employe.salaireTotal(listeEmployes));
					System.out.println("salaire moyen : " + Employe.salaireMoyen(listeEmployes));
					break;
										
				case 7:
					continuer = false;
					break;
								
				default:
					System.out.println("Votre choix n'est pas valide.\n");
					break;
			}		
		}
	}
}
