import java.util.*;
import java.io.*;

public class playGame
{


    public static void main (String[] args)throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Boss Fight!");
        System.out.println("Are you a new player or a returning player? Press 1 for new, press 2 for returning: ");
        int playerType = input.nextInt();
        Character myCharacter;


       if(playerType==2)
        {
            myCharacter = new Character();
            loadSave(myCharacter);
        }

        else
        {
            myCharacter = genCharacter();
        }

       int repeat = 1;
       while(repeat == 1){
        Battle.battleStart(myCharacter);
        System.out.println("Press 1 to continue your quest, press 2 to save and quit");
        repeat = input.nextInt();
        myCharacter.printStats();
       }

       System.out.println("Press 1 to continue your quest, press 2 to save and quit");


    }

    public static Character genCharacter()
    {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter your character's name: ");
      Character myCharacter= new Character(input.next());
      myCharacter.printStats();
      return myCharacter;
    }

    public static void createSave()throws IOException
    {


    }

    public static void loadSave(Character myCharacter)throws IOException
    {
       Scanner input= new Scanner(System.in);
       String fileName = input.nextLine();
       System.out.println("Enter file name: ");
       File saveFile = new File(fileName);


       for(int i = 0; i==0;)
       {
          if(!saveFile.exists())
          {
            System.out.println("Error: " + fileName + " not found");
            System.out.println("Enter file name: ");
            fileName= input.nextLine();
            saveFile = new File(fileName);
          }

          else
          {
              i++;
          }
        }

        Scanner fileInput = new Scanner(saveFile);
        //Declare all values to be copied

        String name=fileInput.nextLine();
        int meleeDMG= fileInput.nextInt();
        int magicDMG= fileInput.nextInt();
        int health= fileInput.nextInt();
        int speed= fileInput.nextInt();
        int xp= fileInput.nextInt();
        int level= fileInput.nextInt();

        myCharacter.importSave(name, meleeDMG, magicDMG, health, speed, xp, level);




    }
}
