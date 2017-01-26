import java.util.*;
public class Monster
{
    private String name;
    private int meleeDMG;
    private int magicDMG;
    private int health;
    private int speed;



    Monster()
    {
        name = randName();
        meleeDMG = (int)((Math.random()*20)+1);
        magicDMG = (int)((Math.random()*20)+1);;
        for(int i = 0; i<1;)
        {
            int gen = (int)((Math.random()*200)+1);;
            if(gen>70)
            {
                health=gen;
                i++;
            }
        }

        speed = (int)((Math.random()*100)+1);
    }

    public void printStats()
    {
       System.out.println("Name: " + name);
       System.out.println("Melee Damage: " + meleeDMG);
       System.out.println("Magic Damage: " + magicDMG);
       System.out.println("Health: " + health);
       System.out.println("Speed: " + speed);
    }

    public void printVisibleStats()
    {
    System.out.println("Name: " + name);
    System.out.println("Health: " + health);
   }
    public String name()
    {
        return name;
    }
    public int meleeDMG()
    {
        return meleeDMG;
    }
    public int magicDMG()
    {
        return magicDMG;
    }
     public int health()
    {
        return health;
    }
     public int speed()
    {
        return speed;
    }

    private static String randName()
    {
      String charToString;
      String StringName = "";
      int random = (int)(5 * Math.random() + 5);
      for(int i = 0; i < random; i++)
      {
        int rand = (int)(26 * Math.random() + 65);
        char name = (char)rand;
        charToString = String.valueOf(name);
        StringName += charToString;
      }
      return StringName;
    }
}
