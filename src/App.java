import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        ArrayList<Celebrity> Celebrities = new ArrayList<Celebrity>();
        Scanner sc = new Scanner(System.in);
        addCelebrity(Celebrities);
        int guessCount = 0;

        int random = (int)(Math.random() * 10);
        Celebrity randomCeleb = Celebrities.get(random);
        

        rules();
        
        while (guessCount <= 20){
            System.out.println(randomCeleb.getName());
            String input = sc.nextLine();
            
            if (traitGuess(input) == true){
                if (input.contains("age") || input.contains("older") || input.contains("younger")){

                    for (int i = 0; i < input.length(); i++){
                        if (input.substring(i, i+1).equals(1) || input.substring(i, i+1).equals(2)||input.substring(i, i+1).equals(3)||input.substring(i, i+1).equals(4)||input.substring(i, i+1).equals(5)||input.substring(i, i+1).equals(6)||input.substring(i, i+1).equals(7)||input.substring(i, i+1).equals(8)||input.substring(i, i+1).equals(9)||input.substring(i, i+1).equals(0)){
                            int guessedAge = Integer.parseInt(input.substring(i, i+2));
                        }
                    }
                    int guessedAge = Integer.parseInt(input.substring(10));
                    int celebAge = Integer.parseInt(randomCeleb.getAge());

                    if(celebAge == (guessedAge)){
                        System.out.println("Yes, this celebrity is " + randomCeleb.getAge() + " years old");
                    }
                    else if (celebAge < guessedAge){
                        System.out.println("No, this celebrity is younger than " + guessedAge);
                    }
                    else if (celebAge > guessedAge){
                        System.out.println("No, this celebrity is older than " + guessedAge);
                    }
                }

            }

            if(celebGuess(input) == true){
                if (input.contains("CELEB")){
                    if(input.contains(randomCeleb.getName())){
                        System.out.println("Yes! " + randomCeleb.getName() + " is the celebrity!");
                    }

                    else{
                        System.out.println("No, that is not the celebrity");

                    }

                }

            }
        }


        
    }
    public static boolean traitGuess(String input){
        if (input.contains("TRAIT")){
            return true;
        }
        else{

            return false;
        }
    }

    public static boolean celebGuess(String input){
        if (input.contains("CELEB")){
            return true;
        }
        else{

            return false;
        }
    }

 

    public static void rules(){
        System.out.println("Guessable Traits: age, height, profession, hairColor, isMale, alive, and race");
        System.out.println("How to guess a trait: ask in this exact format: 'TRAIT'-traitType-guess. For example, TRAIT-age-62");
        System.out.println("How to guess a celebrity: ask in this exact format: 'CELEB'-guess. For example, CELEB-Adam Sandler");
    }


    public static void addCelebrity(ArrayList<Celebrity> Celebrities){
        Celebrity AdamSandler = new Celebrity("Adam Sandler", "56", 70, "comedian", "black", true, true, "white");
        Celebrities.add(AdamSandler);
        Celebrity OBJ = new Celebrity("OBJ", "30", 71, "athlete", "black", true, true, "black");
        Celebrities.add(OBJ);
        Celebrity KevinHart = new Celebrity("Kevin Hart", "43", 62, "comedian", "black", true, true, "black");
        Celebrities.add(KevinHart);
        Celebrity ZachBryan = new Celebrity("Zach Bryan", "26", 70, "singer", "blonde", true, true, "white");
        Celebrities.add(ZachBryan);
        Celebrity LeonardFournette = new Celebrity("Leonard Fournett", "28", 70, "athlete", null, true, true, "black");
        Celebrities.add(LeonardFournette);
        Celebrity DonaldTrump = new Celebrity("Donald Trump", "76", 75, "formerPresident", "blonde", true, true, "white");
        Celebrities.add(DonaldTrump);
        Celebrity JoeBiden = new Celebrity("Joe Biden", "80", 70, "president", "white", true, true, "white");
        Celebrities.add(JoeBiden);
        Celebrity HillaryClinton = new Celebrity("Hillary Clinton", "75", 65, "politician", "white", true, true, "white");
        Celebrities.add(HillaryClinton);
        Celebrity DariusRucker = new Celebrity("Darius Rucker", "56", 70, "singer", "black", true, true, "black");
        Celebrities.add(DariusRucker);
        Celebrity BarackObama = new Celebrity("Barack Obama", "61", 74, "politician", "black", true, true, "black");
        Celebrities.add(BarackObama);
    }
}


