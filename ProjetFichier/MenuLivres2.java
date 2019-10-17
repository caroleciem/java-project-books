package ProjetFichier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MenuLivres2 {
    public static void menuLivres(ArrayList<String> listeFichier, int livre) {

        System.out.println("vous avez choisi le fichier " + listeFichier.get(livre));
        String nom = listeFichier.get(livre);
        String mot = " ";
        String nomFichierTraité =" ";
        int nbOcc = 0;
        int choixActionLivre;

        //liste de mes mots (avec doublons)
        ArrayList<String> myMot = new ArrayList<>();
        //liste de mes mots sans doublons
        ArrayList<String> myMotUn = new ArrayList<>();
        //liste de mes objets mot
        ArrayList<Mot> motOcc = new ArrayList<>();
        //hashmap des mots (ss doublons) avec leur nombre d'occurrence
        HashMap<String, Integer> nbMot = new HashMap<>();


        // je recherche le nombre de ligne de mon fichier

        //recherche des éléments avce le fichier prétraité
        String nomFichierTraite = "t"+ listeFichier.get(livre);
        try (Scanner sc = new Scanner(new File(nomFichierTraite))) {
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
                    myMotUn.add(mot);
                }
            }
            // nbre de ligne du fichier
            int nbrLig = myMot.size();
            //nbre de mots différents du fichier
            int nbMotDuFichier = nbMot.size();
            //affectation de mon ArrayList Mot avec mes objets Mot (libelle, occ)

            creationArrayListMot(myMotUn, nbMot,motOcc);


            boolean actionFichier = false;
            while (actionFichier == false) {
                //affichage du sous menu
                afficheMenuLivre();
                //recupération du choix saisi par l'utilisateur
                choixActionLivre = MenuProjet2.recupereLeChoix();
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
                        case 3: {
                            System.out.println ("Voici les 50 mots les plus courants du livre");
                            afficheMotsCour(motOcc);

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
        System.out.println("3 : afficher les 50 mots les plus courants\n");
        System.out.println("Quel est votre choix ?");

    }
    public static ArrayList<Mot> creationArrayListMot(ArrayList <String>myMotUn,HashMap <String,Integer> nbMot, ArrayList <Mot> motOcc){

        String motDeObjet;
        for (int i = 0; i< myMotUn.size();i++) {
            int nbOcc = 0;
            motDeObjet = myMotUn.get(i);
            nbOcc = nbMot.get(myMotUn.get(i));
            Mot objet1 = new Mot (motDeObjet,nbOcc);
            motOcc.add(objet1);

        }
        Collections.sort(motOcc);
        return motOcc;
    }
    public static void afficheMotsCour(ArrayList <Mot> motOcc){
        for (int i=0; i< 50; i++){
            System.out.println(motOcc.get(i));
        }
    };


}
