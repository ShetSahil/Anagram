//import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Anagram implements Array{
    static int Score = 0;
    static String scramble( Random random, String inputString ){
            // Convert your string into a simple char array:
            char a[] = inputString.toCharArray();
            // Scramble the letters using the standard Fisher-Yates shuffle, 
            for( int i=0 ; i<a.length ; i++ )
            {
                int j = random.nextInt(a.length);
                // Swap letters
                char temp = a[i]; a[i] = a[j];  a[j] = temp;
            }       
            return new String( a );
        }

    static boolean AnagramChecker(String a, String b){
        boolean isAnagram = false;
        if(a.equals(b)) isAnagram = true;
        return isAnagram;
    }
    static boolean AnagramMain (Scanner scan, String name, int currentWordIndex){
        Random r = new Random();
        String a; // to store entered value
        String b; // to stored the question jumbled word
        int chances = 3;
        b = scramble( r, name );
        boolean isAnagram = false; // to validate
        System.out.println("The given jumbled word is " + b + "?"); //print question
        System.out.println("type exit to EXIT!"); // print 
        System.out.println("enter the correct answer:"); // print 
        for (int i = 0; i < chances; i++) {
            a = scan.nextLine(); //give the typed value to variable
            if(a.toLowerCase().equals("exit")) return true; 
            //toLowercase to lower case the typed Exit and equal() to check string and System.exit(1) to quit
            isAnagram = AnagramChecker(a,name); // check if both a & b are equal
            if (!isAnagram) {
                System.out.println("Hint: "+ array[currentWordIndex][i+1]);
                System.out.println("not Anagram");
            } else {
                Score += 10;
                System.out.println("Correct!\n");
                break;
            }
        }
        if (!isAnagram) {
            System.out.println("The Correct Answer was " +name+" !"); 
            System.out.println("\n"); 
            //return true;
        };
        return false;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < array.length ; i++) {
            boolean output = AnagramMain(scan , array[i][0] , i);
            if (output) {
                break;
            }
            
        } 
        scan.close();
        System.out.println("Game Over: \n \t Total Score "  + Score);
    }
}
