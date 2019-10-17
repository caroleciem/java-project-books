package ProjetFichier;

public class Mot implements Comparable<Mot> {
    private String libelleMot;
    private int occ;
    public Mot(String libelleMot, int occ){
        this.libelleMot= libelleMot;
        this.occ= occ;
    }
    public Mot(Mot Other){
        libelleMot = Other.libelleMot;
        occ = Other.occ;
    }
    public boolean equals(Object other){
        if(other != null && (other instanceof Mot)){
            Mot otherMot= (Mot) other;
            if(libelleMot.equals(otherMot.libelleMot)
                    && (occ == otherMot.occ)){
                return true;
            }

        }
        return false;
    }
    public String toString() {
        return "Mot: " + this.libelleMot +
                "\n Occurrence " + this.occ;
    }
    public int compareTo(Mot other) {
        //trions les mots selon leur occ dans l'ordre croissant
        //retroune un entier négative, zéro ou positive si l'occ
        //de ce mot est moins que, égale à ou supérieur à l'objet comparé avec
        return (other.occ -this.occ );
    }

}
