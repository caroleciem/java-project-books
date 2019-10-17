package ProjetFichier;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreTraitement {

        public static String traitement (String nom) throws FileNotFoundException {
            String tNom =" ";
            tNom = ("t"+nom);
            Pattern p = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
            try(Scanner sc = new Scanner(new File(nom));
                PrintStream fileOut = new PrintStream(new FileOutputStream(tNom))){
                for(int i=0; sc.hasNextLine(); ++i){
                    for(Matcher m1 = p.matcher(sc.nextLine()); m1.find();) {
                        fileOut.println(m1.group());
                    }
                }

            }
            catch (FileNotFoundException e) {
                System.out.println("fichier inexistant");
            }
            return tNom;
        }
}
