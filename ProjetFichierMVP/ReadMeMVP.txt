Le package ProjetFichierMVP  contient le projet java-project-books composé de deux Classes + readme:
La classe MenuProjet qui contient le Main et toute la partie du menu principal
la classe MenuLivre qui contient la gestion du menu livre (et sous-menu) lorsque le choix 4 a été effectué

Il est possible de mettre des noms de fichiers en arguments pour initialiser ces fichiers dès l'affichage du menu principal.
les différents fichiers devrons être placés à la racine du projet

Au lancement, affichage du  Menu principal:
-------------------------------------------
Menu :

1 : Lister les fichiers

2 : Ajouter un fichier

3 : Supprimer un fichier

4 : Afficher des informations sur un livre

5 : Quitter le programme


Quel est votre choix ?
--------------------------------------------

Choix 1:
si aucun fichier n'a été saisi ou envoyé en argument, un message s'affichera à l'utilisateur (Vous n'avez pas de fichiers dans votre liste), sinon, la liste des fichiers sera listée et le Menu principal
sera réaffiché
Choix 2: la saisie du fichier à ajouter sera demandée à l'utilisateur et le fichier sera ajouté à la liste de fichier et un message informera l'utilisateur que le fichier a bien été ajouté et lemenu principal est réaffiché
Choix 3: aucun fichier n'a été saisi ou envoyé en argument, un message s'affichera à l'utilisateur(il n'a pas pas de fichiers à supprimer), sinon ilaffiche la liste des fichiers et demande à l'utilisateur de saisir un choix d'un fichier dans cette liste
Choix 4: débranche sur le MenuLivre(s'il y a des fichiers dans la liste)
Choix 5: termine le programme

MenuLivre:
-----------------------------------------------------------
Votre choix est d'afficher des informations sur un livre

1 - Smith-Richesse_des_Nations_5.Trt.txt
2 - Smith-Richesse_des_Nations_5-Trt.txt



Quel livre voulez-vous sélectionner?
-----------------------------------------------------------

La liste des fichiers est affichée et il est demandé de sélectionné un des fichiers

une fois le fichier sélectionné, il est vérifié que le fichier existe à la racine du projet. Si ce n'est pas le cas, un message précise à l'utilisateur que le fichier est inexistant.
sinon, le sous menu suivant s'affiche :

-----------------------------------------------------------
vous avez choisi le fichier Smith-Richesse_des_Nations_5-Trt.txt
Menu :

1 : Afficher le nombre de ligne du fichier

2 : Afficher le nombre de mots différents du fichier

Quel est votre choix ?
------------------------------------------------------------

choix 1 :affiche le nombre de ligne du fichier et reaffiche le menu principal
Choix 2 :affiche le nombre de mots différents et réaffiche le menu principal