import java.util.ArrayList;

public class Celebrity {
    
    String age;
    String height;

    String profession;
    String hairColor;

    String gender;
    String alive;
    String race;
    String name;


    Celebrity(){
        
    }

    Celebrity(String name, String age, String height, String profession, String hairColor, String gender, String alive, String race){
        this.age = age;
        this.height = height;
        this.profession = profession;
        this.hairColor = hairColor;
        this.gender = gender;
        this.alive = alive;
        this.race = race;
        this.name = name;

    }

    public String getAge(){
        return age;
    }
    
    public String getHeight(){
        return height;
    }

    public String getProfession(){
        return profession;
    }

    public String getHairColor(){
        return hairColor;
    }

    public String getGender(){
        return gender;
    }

    public String getAlive(){
        return alive;
    }

    public String getRace(){
        return race;

    }

    public String getName(){
        return name;

    }



}
