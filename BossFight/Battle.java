import java.util.*;
public class Battle
{
    public static void battleStart(Character myCharacter)
    {
        System.out.println("The battle has begun!\n\n");
        Monster myMonster = new Monster();
        genMonster(myMonster);

        int monsterHealth = myMonster.health();
        int characterHealth = myCharacter.health();

        if (combatManager(myMonster, myCharacter, monsterHealth, characterHealth))
        {
          System.out.println("You have slain the monster! Congratulations!");
          int gainExp = (int)(myCharacter.maxHealth()*0.25);
          myCharacter.applyEarnedXP(gainExp);
          System.out.println("You gained " + gainExp + " XP!");
          return;
        }

        System.out.println("You have died.");
        return;

    }

    public static void genMonster(Monster myMonster)
    {
        System.out.println("A monster appeared!");

        myMonster.printVisibleStats();
        System.out.println("\n\n");

    }

    public static boolean combatManager(Monster myMonster, Character myCharacter, int monsterHealth, int characterHealth)
    {
       while((monsterHealth>0)&&(characterHealth>0))
      {
        if(myMonster.speed()>myCharacter.speed())
        {
            characterHealth = monsterAttack(myMonster, myCharacter, monsterHealth, characterHealth);
           if(characterHealth<=0)
           {
            return false;
           }
            monsterHealth = characterAttack(myMonster, myCharacter, monsterHealth, characterHealth);
           if(monsterHealth<=0)
           {
            return true;
           }
        }

        if(myCharacter.speed()>myMonster.speed())
        {
            monsterHealth = characterAttack(myMonster, myCharacter, monsterHealth, characterHealth);
           if(monsterHealth<=0)
             {
               return true;
             }
            characterHealth = monsterAttack(myMonster, myCharacter, monsterHealth, characterHealth);
           if(characterHealth<=0)
           {
            return false;
           }

        }

      }

      return false;
    }

    public static int monsterAttack(Monster myMonster, Character myCharacter, int monsterHealth, int characterHealth)
    {
        int attackType = (int)((Math.random()*2)+1);
        int crit = (int)((Math.random()*10)+1);

        if(attackType == 1)
        {
            System.out.println("-----------------------\n" + myMonster.name()+ " uses slash!");
            if(crit==6)
            {
              System.out.println("************It's a critical hit!***********");
              System.out.println(myMonster.name()+ " does " + myMonster.meleeDMG()*2 + " damage!\n-----------------------\n");
              characterHealth=characterHealth-(myMonster.meleeDMG()*2);
            }
            else
            {
              System.out.println("It does " + myMonster.meleeDMG() + " damage!");
              characterHealth=characterHealth-(myMonster.meleeDMG());
            }


            System.out.println(myCharacter.name() + " has " + characterHealth + " health!\n-----------------------\n");
        }

        if(attackType == 2)
        {
            System.out.println("-----------------------\n" + myMonster.name()+ " breathes fire!");
            System.out.println("It does " + myMonster.magicDMG() + " damage!");
            characterHealth= characterHealth-(myMonster.magicDMG());
            System.out.println(myCharacter.name() + " has " + characterHealth + " health!\n-----------------------\n");
        }

        return characterHealth;
    }

    public static int characterAttack(Monster myMonster, Character myCharacter, int monsterHealth, int characterHealth)
    {
        System.out.println("================================================================\nIt is your turn to attack. Press 1 for Melee, press 2 for Magic: \n================================================================\n");
        Scanner input = new Scanner(System.in);
        int attackType = input.nextInt();
        int crit = (int)((Math.random()*10)+1);


        if(attackType == 1)
        {
          if(crit==6)
          {
            System.out.println("-----------------------\nYou stab " + myMonster.name() + "!");
            System.out.println("************It's a critical hit!***********");
            System.out.println(myCharacter.name()+ " does " + myCharacter.meleeDMG()*2 + " damage!\n-----------------------\n");
            monsterHealth=monsterHealth-(myCharacter.meleeDMG()*2);
            System.out.println(myMonster.name() + " has " + monsterHealth + " health!\n-----------------------\n");
          }
          else
          {
            System.out.println("-----------------------\nYou stab " + myMonster.name() + "!");
            System.out.println("It does " + myCharacter.meleeDMG() + " damage!");
            monsterHealth = monsterHealth -(myCharacter.meleeDMG());
            System.out.println(myMonster.name() + " has " + monsterHealth + " health!\n-----------------------\n");
          }
        }

        if(attackType == 2)
        {
            System.out.println("--------------------\nYou throw a knife at "  + myMonster.name() + "!");
            System.out.println("It does " + myCharacter.magicDMG() + " damage!");
            monsterHealth= monsterHealth-(myCharacter.magicDMG());
            System.out.println(myMonster.name() + " has " + monsterHealth + " health!\n-----------------------\n");
        }


        return monsterHealth;

    }
}
