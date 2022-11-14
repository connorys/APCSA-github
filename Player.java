/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int points;
  /* your code here - constructor(s) */ 
  public Player(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a player name.");
    name = sc.nextLine();
    points = 0;
    System.out.println("Welcome to the game " + name);
  }

  public Player (String inputName) {
    name = inputName;
    points = 0;
    System.out.println("Welcome " + name + " to the game.");
  }
  /* your code here - accessor(s) */ 
  public int getPoints(){
    return points;
  }
  
  public String getName(){
    return name;
  }
  /* your code here - mutator(s) */ 
  void setName(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a new player name.");
    name = sc.nextLine();
    System.out.println("name has been changed to "+ name);
  }
  void addToPoints (int value){
    points += value;
  }
}