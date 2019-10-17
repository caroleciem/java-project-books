package ProjetFichierMVP;

import ProjetFichierMVP.MenuLivres;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuProjet {


    public static void main(String[] args) {
        // je crée ma nouvelle Arraylist
        ArrayList<String> listeFichiers = new ArrayList<>();
        //Pour chaque args, je crée un nouveau fichier dans ma liste
        for (int i = 0; i < args.length; i++) {
            ajoutList(listeFichiers, args[i]);

        }
        //j'initialise mon boolean de saisie correcte de choix
        boolean saisie = false;
        int choix = -1;
        //je boucle jusqu'à ce que j'ai une saisie correcte
        while (saisie == false || choix != 5) {
            afficheMenu();
            choix = recupereLeChoix();
            if (choix != -1) {
                saisie = (validationDuChoix(choix, listeFichiers));
            }
        }
    }

    // fonction qui affiche mon menu principal
    public static void afficheMenu() {

        System.out.println("Menu : \n");
        System.out.println("1 : Lister les fichiers\n");
        System.out.println("2 : Ajouter un fichier\n");
        System.out.println("3 : Supprimer un fichier \n");
        System.out.println("4 : Afficher des informations sur un livre\n");
        System.out.println("5 : Quitter le programme  \n");
        System.out.print("\n");
        System.out.println("Quel est votre choix ?");

    }
//fonction pour ajouter un fichier dans ma liste

    public static ArrayList ajoutList(ArrayList listeFichiers, String args) {

        listeFichiers.add(args);

        return listeFichiers;
    }
//fonction pour supprimer un fichier dans ma liste

    public static ArrayList suppList(ArrayList listeFichiers, int ficASup) {

        //j'enlève 1 à l'indicateur car j'avais ajouté 1 pour l'affichage
        ficASup--;
        listeFichiers.remove(ficASup);

        return listeFichiers;
    }


    // fonction pour récupérer la saisie effectuée
    public static int recupereLeChoix() {
        Scanner clavier = new Scanner(System.in);
        try {
            int choix = clavier.nextInt();
            return choix;
        } catch (InputMismatchException e) {
            System.out.println("ce n'est pas un entier !");
            clavier.nextLine();
            return -1;
        }
    }

    // fonction pour valider la saisie effectuée
    public static boolean validationDuChoix(int choix, ArrayList listeFichiers) {

        boolean saisie = true;
        switch (choix) {
            case 1: {
                System.out.println("Votre choix est de lister les fichiers\n");
                if (listeFichiers.size() == 0) {
                    System.out.println("Vous n'avez pas de fichiers dans votre liste\n");
                } else {
                    affListeFichiers(listeFichiers);
                }
                break;
            }
            case 2: {
                System.out.println("Votre choix est d'ajouter un fichier\n");
                ajouterFichierDansListe(listeFichiers);


                break;
            }
            case 3: {
                System.out.println("Votre choix est de supprimer un fichier \n");
                if (listeFichiers.size() == 0) {
                    System.out.println("il n'a pas pas de fichiers à supprimer\n");
                } else {
                    supprimerFichierDansListe(listeFichiers);
                }
                break;
            }
            case 4: {
                System.out.println("Votre choix est d'afficher des informations sur un livre\n");
                if (listeFichiers.size() == 0) {
                    System.out.println("Vous n'avez pas de livres sur lesquels vous pouvez afficher des informations\n");
                } else {
                    affListeFichiers(listeFichiers);


                    boolean livreSel = false;
                    while (livreSel == false) {
                        System.out.println("Quel livre voulez-vous sélectionner?");
                        Scanner clavier = new Scanner(System.in);
                        try {
                            //le fichier à supprimer ficASup est le choix saisi au clavier
                            int livre = clavier.nextInt();
                            // je valide que le choix est bien compris entre 0 et la taille de ma liste
                            if (livre > listeFichiers.size() || livre == 0) {
                                System.out.println(" votre choix n'est pas dans la liste des fichiers!");
                            } else {
                                livreSel = true;

                                MenuLivres.menuLivres(listeFichiers, livre - 1);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("ce n'est pas un entier !");
                            clavier.nextLine();

                        }
                    }
                }

                break;
            }
            case 5: {
                System.out.println("Vous avez décidé de quitter le programme");

                break;
            }
            default: {
                saisie = false;
                System.out.println("Ce choix n'est pas dans la liste");

            }

        }
        return saisie;
    }

    // fonction d'affichage de la lists des fichiers:

    public static void affListeFichiers(ArrayList listeFichiers) {
        String res = "";
        for (int i = 0; i < listeFichiers.size(); i++) {
            int j = i + 1;
            res += j + " - " + listeFichiers.get(i) + "\n";

        }
        System.out.println(res);
        System.out.println("\n");
    }
    //fonction qui récupère le fichier saisi par l'utilisateur puis ajoute le fichier à l'ArrayList
    public static void ajouterFichierDansListe(ArrayList listeFichiers) {
        System.out.println("Quel fichier voulez-vous ajouter?");
        Scanner clavier = new Scanner(System.in);
        String nvFichier = clavier.nextLine();
        ajoutList(listeFichiers, nvFichier);
        System.out.println("votre fichier a bien été ajouté");


    }
    // fonction qui affiche la liste des fichiers et demande à l'utilisateur de choisir le fichier à supprimer
    public static void supprimerFichierDansListe(ArrayList listeFichiers) {
        System.out.println("voici la liste de vos fichiers : ");

        affListeFichiers(listeFichiers);
        boolean fichierSel = false;
        while (fichierSel == false) {
            System.out.println("Quel fichier voulez-vous supprimer?");
            Scanner clavier = new Scanner(System.in);
            try {
                //le fichier à supprimer ficASup est le choix saisi au clavier
                int ficASup = clavier.nextInt();
                // je valide que le choix est bien compris entre 0 et la taille de ma liste
                if (ficASup > listeFichiers.size() || ficASup == 0) {
                    System.out.println(" votre choix n'est pas dans la liste des fichiers!");
                } else {
                    fichierSel = true;

                    suppList(listeFichiers, ficASup);
                    System.out.println("votre fichier a bien été supprimé");
                }
            } catch (InputMismatchException e) {
                System.out.println("ce n'est pas un entier !");
                clavier.nextLine();

            }
        }
    }
}

