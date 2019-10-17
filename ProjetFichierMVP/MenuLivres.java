package ProjetFichierMVP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MenuLivres {
    public static void menuLivres(ArrayList<String> listeFichier, int livre) {

        System.out.println("vous avez choisi le fichier " + listeFichier.get(livre));
        String nom = listeFichier.get(livre);
        String mot = " ";
        int nbOcc = 0;
        int choixActionLivre;

        ArrayList<String> myMot = new ArrayList<>();
        HashMap<String, Integer> nbMot = new HashMap<>();
        // je recherche le nombre de ligne de mon fichier

        try (Scanner sc = new Scanner(new File(listeFichier.get(livre)))) {
            for (int i = 0; sc.hasNextLine(); ++i) {
                mot = (sc.nextLine());
                mot = mot.toUpperCase();
                // ajout du mot dans l'Arraylist myMot
                myMot.add(mot);
                // vérification si le mot existe déjà dans la HashMap, si existe, on ajoute 1 à l'occurence, sinon, on crée la ligne à 1
                if (nbMot.containsKey(mot)) {
                    nbOcc = nbMot.get(mot);
                    nbOcc++;
                    nbMot.put(mot, nbOcc);

                } else {
                    nbOcc = 1;
                    nbMot.put(mot, nbOcc);
                }
            }
            // nbre de ligne du fichier
            int nbrLig = myMot.size();


            //nbre de mots différents du fichier
            int nbMotDuFichier = nbMot.size();


            boolean actionFichier = false;
            while (actionFichier == false) {
                //affichage du sous menu
                afficheMenuLivre();
                //recupération du choix saisi par l'utilisateur
                choixActionLivre = MenuProjet.recupereLeChoix();
                if (choixActionLivre != -1) {
                    actionFichier = true;
                    switch (choixActionLivre) {
                        case 1: {
                            System.out.println("Le nombre de lignes du livre est: "+ nbrLig + "\n");

                            break;
                        }
                        case 2: {
                            System.out.println("le nombre de mots du livre est "+ nbMotDuFichier+ "\n");


                            break;
                        }
                        default: {
                            actionFichier = false;
                            System.out.println("Ce choix n'est pas dans la liste");

                        }

                    }
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("fichier inexistant");
        }




    }
    //affichage du sous-menu d'actions sur les fichiers

    public static void afficheMenuLivre() {

        System.out.println("Menu : \n");
        System.out.println("1 : Afficher le nombre de ligne du fichier\n");
        System.out.println("2 : Afficher le nombre de mots différents du fichier\n");
        System.out.println("Quel est votre choix ?");

    }


}
