/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board(){
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
    System.out.println("Phrase: " + phrase);
  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  /**
   * returns true if guess is in the phrase else returns false
   * 
   * Preconditiion:
   *  guess is a letter and a string
   *  phrase exists and is a string
   * 
   * Postcondition:
   *  solvedPhrase now includes the guessed letter in place of _'s depending on where the guess occurs in the phrase
   *  foundLetter is assigned either true or false depending on if the guess was in the phrase or not
   */
  public boolean guessLetter(String guess) //creates method called guessLetter
  {
    boolean foundLetter = false; //initializes boolean foundLetter as false
    String newSolvedPhrase = ""; //initializes newSolvedPhrase as an empty string
    
    for (int i = 0; i < phrase.length(); i++) //iterates through all characters in phrase
    {
      if (phrase.substring(i, i + 1).equals(guess)) //checks if each letter in phrase equals the guessed letter
      {
        newSolvedPhrase += guess + " "; //adds guessed letter followed by space to newSolvedPhrase
        foundLetter = true; //sets foundLetter to true
      }
      else //executes if letter in phrase doesn't equal the guessed letter
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  //adds an underscore followed by a space to newSolvedPhrase
      } 
    }
    solvedPhrase = newSolvedPhrase; //reassigns solvedPhrase to newSolvedPhrase
    return foundLetter; //returns boolean foundLetter
  } 
} 