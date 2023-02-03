import java.util.ArrayList;

public class Celebrity {
    
    String age;
    int height;

    String profession;
    String hairColor;

    boolean isMale;
    boolean alive;
    String race;
    String name;


    Celebrity(){
        
    }

    Celebrity(String name, String age, int height, String profession, String hairColor, boolean isMale, boolean alive, String race){
        this.age = age;
        this.height = height;
        this.profession = profession;
        this.hairColor = hairColor;
        this.isMale = isMale;
        this.alive = alive;
        this.race = race;
        this.name = name;

    }

    public String getAge(){
        return age;
    }
    
    public int getHeight(){
        return height;
    }

    public String getProfession(){
        return profession;
    }

    public String getHairColor(){
        return hairColor;
    }

    public boolean getGender(){
        return isMale;
    }

    public boolean getAlive(){
        return alive;
    }

    public String getRace(){
        return race;

    }

    public String getName(){
        return name;

    }



}
