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
            listFile();
            loadSave(myCharacter);
        }

        else
        {
            myCharacter = genCharacter();
        }

       int repeat = 1;
       while(repeat == 1)
       {
        Battle.battleStart(myCharacter);
        System.out.println("Press 1 to continue your quest, press 2 to save and quit");
        repeat = input.nextInt();
        myCharacter.printStats();
       }

       listFile();
       saveGame(myCharacter);

    }

    public static Character genCharacter()
    {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter your character's name: ");
      Character myCharacter= new Character(input.next());
      myCharacter.printStats();
      return myCharacter;
    }

    public static void listFile()
    {
      File folder = new File("./Saves");
      File[] listOfFiles = folder.listFiles();

      System.out.println("\n\n\tSaved Files");
      System.out.println("-----------------------------");
      for(int i = 0; i < listOfFiles.length; i++)
      {
        if(listOfFiles[i].isFile())
        {
          System.out.println("\t" + (i + 1) + ". " + listOfFiles[i].getName());
        }
      }
      System.out.println("-----------------------------\n");
    }

    public static void saveGame(Character myCharacter)throws IOException
    {
      Scanner in = new Scanner(System.in);
      int userIn;
      int i = 0;
      String saveName;

      while(i == 0)
      {
        System.out.println("\nSave files should end with .txt\n");
        System.out.print("Save Title: ");
        saveName = in.next();
        File saveFile = new File("./Saves/" + saveName);
        if(!saveFile.exists())
        {
          saveFile.createNewFile();
          FileOutputStream oFile = new FileOutputStream(saveFile, false);
          i++;
        }
        else
        {
          System.out.println("\n\nSave file already exist. Do you want to overwrite?");
          System.out.println("1. Yes\t2. No");
          userIn = in.nextInt();
          if(userIn == 1)
          {
            //FileWriter saveWriter = new FileWriter(saveFile, false);
            PrintStream saveStream = new PrintStream(saveFile);
            saveStream.println(myCharacter.name());
            saveStream.println(myCharacter.meleeDMG());
            saveStream.println(myCharacter.magicDMG());
            saveStream.println(myCharacter.health());
            saveStream.println(myCharacter.speed());
            saveStream.println(myCharacter.experience());
            saveStream.println(myCharacter.level());
            //saveWriter.close();
            i++;
          }
        }
      }
    }

    public static void loadSave(Character myCharacter)throws IOException
    {
      Scanner input= new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = input.nextLine();
      File saveFile = new File("./Saves/" + fileName);


      for(int i = 0; i==0;)
      {
        if(!saveFile.exists())
        {
          System.out.println("\nError: " + fileName + " not found");
          System.out.print("\nEnter file name: ");
          fileName= input.nextLine();
          saveFile = new File("./Saves/" + fileName);
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
        myCharacter.printStats();
        System.out.println("\n");




    }
}
