import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        ArrayList<Celebrity> Celebrities = new ArrayList<Celebrity>();
        Scanner sc = new Scanner(System.in);
        addCelebrity(Celebrities);

        int random = (int)(Math.random() * 10);
        Celebrity randomCeleb = Celebrities.get(random);
        int guessCount = 0;

        rules();
        
        while (guessCount <= 15){
            
            String input = sc.nextLine();
            traitResponses(input, randomCeleb, guessCount);
            celebResponse(input, randomCeleb, guessCount);


            if (guessCount == 14){
                System.out.println("Be careful, this is your last guess!");
            }
            guessCount++;

            if (guessCount > 20){
                break;

            }
        }

        if (guessCount == 15){
            System.out.print("You ran out of guesses, you lose.");
        }

        sc.close();
    }





    public static String traitType(String input){
        if (input.contains("age") || input.contains("younger") || input.contains("older") || input.contains("years old")){ // for age related inquiries
            return "age";
        }
        else if (input.contains("height") || input.contains("tall") || input.contains("taller") || input.contains("shorter")){

            return "height";
        }

        else if (input.contains("profession") || input.contains("job") || input.contains("actor") || input.contains("athlete") || input.contains("politician") || input.contains("artist") || input.contains("comedian") || input.contains("musician")){

            return "profession";
        }
        else if ((input.contains("blonde") || input.contains("black") || input.contains("brown") || input.contains("red") || input.contains("ginger")) && input.contains("hair")){

            return "hairColor";
        }
        else if (input.contains("male") || input.contains("female") || input.contains("man") || input.contains("girl") || input.contains("boy") || input.contains("girl")){

            return "gender";
        }
        else if (input.contains("alive") || input.contains("dead") || input.contains("living") || input.contains("deceased") || input.contains("passed")){

            return "alive";
        }
        else if ((input.contains("black") || input.contains("white") || input.contains("brown")) && !(input.contains("hair"))){

            return "race";
        }
        else{
            return "";
        }

    }




    public static boolean celebGuess(String input){
        if (input.contains("Adam Sandler") || input.contains("OBJ") || input.contains("Kevin Hart") || input.contains("Zach Bryan") || input.contains("Leonard Fournett") || input.contains("Donald Trump") || input.contains("Joe Biden") || input.contains("Hillary Clinton") || input.contains("Darius Rucker") || input.contains("Barack Obama")){
            return true;
        }
        else{

            return false;
        }
    }




    public static void celebResponse(String input, Celebrity randomCeleb, int guessCount){
        if (celebGuess(input) == true){
            if (input.contains(randomCeleb.getName())){
                System.out.println("Yes! " + randomCeleb.getName() + " is the mystery celebrity!");
                guessCount += 25;
            }

            else{
                System.out.println("No, they are not the mystery celebrity.");
            }
           
        }

    }





    public static void traitResponses(String input, Celebrity randomCeleb, int guessCount){
        int guessedAge = 0;
        int guessedHeight = 0;
        

            if (traitType(input).equals("age")){

                int celebAge = Integer.parseInt(randomCeleb.getAge());

                    for (int i = 0; i < input.length(); i++){
                        if (input.substring(i, i+1).equals("1") || input.substring(i, i+1).equals("2")||input.substring(i, i+1).equals("3")||input.substring(i, i+1).equals("4")||input.substring(i, i+1).equals("5")||input.substring(i, i+1).equals("6")||input.substring(i, i+1).equals("7")||input.substring(i, i+1).equals("8")||input.substring(i, i+1).equals("9")||input.substring(i, i+1).equals("0")){
                            guessedAge = Integer.parseInt(input.substring(i, i+2));
                            break;
                        }

                    }

                    if(input.contains("younger")){
                        if (celebAge < guessedAge)
                            System.out.println("Yes! This celebrity is younger than " + guessedAge);
                        else{
                            System.out.println("No, this celebrity is not younger than " + guessedAge);
                        }
                    }

                    else if (input.contains("older")){
                        if (celebAge > guessedAge){
                            System.out.println("Yes! This celebrity is older than " + guessedAge);
                        }
                        else{
                            System.out.println("No, this celebrity is not older than " + guessedAge);
                        } 
                    }

                    else if (input.contains("years old") && !(input.contains("older")) && !(input.contains("younger"))){
                        if (celebAge == guessedAge){
                            System.out.println("Yes! This celebrity is " + guessedAge + " years old");
                        }
                        else{
                            System.out.println("No, this celebrity is not " + guessedAge + " years old");
                        }
                    }
                
                }

            else if (traitType(input).equals("height")){

                int celebHeight = Integer.parseInt(randomCeleb.getHeight());

                for (int i = 0; i < input.length(); i++){
                    if (input.substring(i, i+1).equals("1") || input.substring(i, i+1).equals("2")||input.substring(i, i+1).equals("3")||input.substring(i, i+1).equals("4")||input.substring(i, i+1).equals("5")||input.substring(i, i+1).equals("6")||input.substring(i, i+1).equals("7")||input.substring(i, i+1).equals("8")||input.substring(i, i+1).equals("9")||input.substring(i, i+1).equals("0")){
                        guessedHeight = Integer.parseInt(input.substring(i, i+2));
                        break;
                    }

                }

                if (input.contains("taller")){
                    if(celebHeight > guessedHeight){
                        System.out.println("Yes! This celebrity taller than " + guessedHeight + " inches tall");
                    }

                    else{
                        System.out.println("No, this celebrity is not taller than " + guessedHeight + " inches tall");
                    }

                }
                else if (input.contains("shorter")){
                    if (celebHeight < guessedHeight){
                        System.out.println("Yes! This celebrity is shorter than" + guessedHeight + " inches tall");
                    }

                    else{
                        System.out.println("No, this celebrity is not shorter than " + guessedHeight + " inches tall");
                    }
                    
                }
                else if ((input.contains("tall") || input.contains("inches") || input.contains("in")) && !(input.contains("older")) && !(input.contains("younger"))){
                    if (celebHeight == guessedHeight){
                        System.out.println("Yes! This celebrity is " + guessedHeight + " inches tall");
                    }
                    
                    else{
                        System.out.println("No, this celebrity is not " + guessedHeight + " inches tall");
                    }
                }
                
            }

            else if (traitType(input).equals("profession")){
                if (input.contains(randomCeleb.getProfession())){
                    System.out.println("Yes, this celebrity is a(n) " + randomCeleb.getProfession());
                }
                else{
                    System.out.println("No, this celebrity does not do that.");
                }
                
            }

            else if (traitType(input).equals("hairColor")){
                if (input.contains(randomCeleb.getHairColor()) && input.contains("hair")){
                    System.out.println("Yes, this celebrity has " + randomCeleb.getHairColor() + " hair");
                }
                else{
                    System.out.println("No, this celebrity does not have that hair color.");
                }
                
            }

            else if (traitType(input).equals("gender")){
                if (input.contains(" " + randomCeleb.getGender())){
                    System.out.println("Yes, this celebrity is a " + randomCeleb.getGender());
                }
                else{
                    if (randomCeleb.getGender().equals("male")){
                        System.out.println("No, this celebrity is not female");
                    }
                    else if (randomCeleb.getGender().equals("female")){
                        System.out.println("No, this celebrity is not male");
                    }
                }
                
            }

            else if (traitType(input).equals("alive")){
                if (input.contains(randomCeleb.getAlive())){
                    System.out.println("Yes, this celebrity is " + randomCeleb.getAlive());
                }
                else{
                    if (randomCeleb.getAlive().equals("alive")){
                        System.out.println("No, this celebrity is not dead");
                    }
                    else {
                        System.out.println("No, this celebrity is not alive");
                    }
                    
                }
                

            }

            else if (traitType(input).equals("race")){
                if (input.contains(randomCeleb.getRace()) && !(input.contains("hair"))){
                    System.out.println("Yes, this celebrity has " + randomCeleb.getRace() + " skin");
                }
                else{
                    System.out.println("No, this celebrity does not have that skin color.");
                }

            }

    }

 



    public static void rules(){
        System.out.println("");
        System.out.println("");
        System.out.println("Guessable Traits: age, height, profession, hairColor, gender, alive, and race");
    }






    public static void addCelebrity(ArrayList<Celebrity> Celebrities){
        Celebrity AdamSandler = new Celebrity("Adam Sandler", "56", "70", "comedian", "black", "male", "alive", "white");
        Celebrities.add(AdamSandler);
        Celebrity OBJ = new Celebrity("OBJ", "30", "71", "athlete", "black", "male", "alive", "black");
        Celebrities.add(OBJ);
        Celebrity KevinHart = new Celebrity("Kevin Hart", "43", "62", "comedian", "black", "male", "alive", "black");
        Celebrities.add(KevinHart);
        Celebrity ZachBryan = new Celebrity("Zach Bryan", "26", "70", "musician", "blonde", "male", "alive", "white");
        Celebrities.add(ZachBryan);
        Celebrity LeonardFournette = new Celebrity("Leonard Fournett", "28", "70", "athlete", "null", "male", "alive", "black");
        Celebrities.add(LeonardFournette);
        Celebrity DonaldTrump = new Celebrity("Donald Trump", "76", "75", "politician", "blonde", "male", "alive", "white");
        Celebrities.add(DonaldTrump);
        Celebrity JoeBiden = new Celebrity("Joe Biden", "80", "70", "politician", "white", "male", "alive", "white");
        Celebrities.add(JoeBiden);
        Celebrity HillaryClinton = new Celebrity("Hillary Clinton", "75", "65", "politician", "white", "female", "alive", "white");
        Celebrities.add(HillaryClinton);
        Celebrity DariusRucker = new Celebrity("Darius Rucker", "56", "70", "musician", "black", "male", "alive", "black");
        Celebrities.add(DariusRucker);
        Celebrity BarackObama = new Celebrity("Barack Obama", "61", "74", "politician", "black", "male", "alive", "black");
        Celebrities.add(BarackObama);
    }
}


