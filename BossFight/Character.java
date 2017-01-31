import java.util.*;
public class Character
{
    private String name;
    private int meleeDMG;
    private int magicDMG;
    private int health;
    private int speed;
    private int xp;
    private int level = 1;
    private int maxHealth;

    Character()
    {
        name = "a";
        meleeDMG = 1;
        magicDMG = 1;
        health = 100;
        speed = 100;
        xp = 0;
        level = 1;
    }

    Character(String characterName)
    {
        name = characterName;
        meleeDMG = (int)((Math.random()*20)+1);
        magicDMG = (int)((Math.random()*20)+1);;
        for(int i = 0; i<1;)
        {
            int gen = (int)((Math.random()*200)+1);;
            if(gen>70)
            {
                health=gen;
                maxHealth=health;
                i++;
            }
        }

        speed = (int)((Math.random()*100)+1);
    }

    public void printStats()
    {
       System.out.println("\nName: " + name);
       System.out.println("Level: " + level);
       System.out.println("XP: " + xp);
       System.out.println("Melee Damage: " + meleeDMG);
       System.out.println("Magic Damage: " + magicDMG);
       System.out.println("Health: " + health);
       System.out.println("Speed: " + speed);
    }

    public int experience()
    {
        return xp;
    }

    public void applyEarnedXP(int earnedXP)
    {
        xp+=earnedXP;
        if(xp>=100)
        {
            levelUp();
            xp-=100;
            System.out.println(name() + " leveled up!");
            System.out.println("Apply skill point: Press 1 to increase Melee Damage, Press 2 to increase Magic Damage, Press 3 to increase Health")
            applySkillPoint();
        }
    }

   public void applySkillPoint()
   {
       Scanner input = new Scanner(System.in);
       int skillChoice = input.nextInt();
       
       if(skillChoice==1)
       {
            upgradeMeleeDMG(1);
       }
       
       else if (skillChoice==2)
       {
            upgradeMagicDMG(1);
       }
       
       else if(skillChoice==3)
       {
            upgradeHealth(1);
       }
       return;
    }

        
   
   
   public void upgradeMeleeDMG(int upgrade)
    {
        meleeDMG+=upgrade;
    }

    public void upgradeMagicDMG(int upgrade)
    {
        magicDMG+=upgrade;
    }

     public void upgradeSpeed(int upgrade)
    {
        speed+=upgrade;
    }

     public void upgradeHealth(int upgrade)
    {
        health+=upgrade;
    }

    public void levelUp()
    {
        level++;
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
    public int maxHealth()
    {
      return maxHealth;
    }
     public int speed()
    {
        return speed;
    }


    public void importSave(String importname, int importmeleeDMG, int importmagicDMG, int importhealth, int importspeed, int importxp, int importlevel)
    {
        name = importname;
        meleeDMG = importmeleeDMG;
        magicDMG = importmagicDMG;
        health = importhealth;
        speed = importspeed;
        xp = importxp;
        level = importlevel;

    }

}
