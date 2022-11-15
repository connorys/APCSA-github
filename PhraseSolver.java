/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;
  /* your code here - constructor(s) */ 
  public PhraseSolver(){
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    //Scanner input = new Scanner(System.in);--------------------------------------------------------
    
    boolean correct = true;
    while (!solved) 
    {
      boolean validInput = false;
      System.out.println(game.getSolvedPhrase());
      /* your code here - game logic */
      Scanner sc = new Scanner(System.in);
      System.out.println("Do you want to guess the phrase or a letter?");
      while(!validInput) {
        String string = sc.nextLine();
        game.setLetterValue();
        int letterValue = game.getCurrentLetterValue();
        if (string.equals("letter")){
          validInput = true;
          System.out.println("Enter a letter");
          string = sc.nextLine();
          correct = game.guessLetter(string);
          if (correct) {
            if (game.getSolvedPhrase().indexOf("_")==-1){
              System.out.println("You guessed the phrase");
              solved = true;
            } else {
              System.out.println("Your guessed letter was in the phrase");
            }
            if (currentPlayer == 1){
              player1.addToPoints(letterValue*game.letterCount(string));
            } else{
              player2.addToPoints(letterValue*game.letterCount(string));
            }
          } else {
            System.out.println("Your guessed letter was not in the phrase");
          }
        }
        else if (string.equals("phrase")){
          validInput = true;
          System.out.println("Enter a phrase");
          string = sc.nextLine();
          if (string.equals(game.getPhrase())){
            if (currentPlayer == 1){
              player1.addToPoints(letterValue*game.underscoreCount());
            }else{
              player2.addToPoints(letterValue*game.underscoreCount());
            }
            solved = true;
          }
        } else {
            System.out.println("Type 'letter' or 'phrase'.");
        }
        
      }
      /* your code here - determine how game ends */     
      if(currentPlayer == 1 && !correct){
        currentPlayer = 2;
        System.out.println();
        System.out.println("Begin " + player2.getName() + "'s turn");
      } else if (currentPlayer == 2 && !correct){
        currentPlayer = 1;
        System.out.println();
        System.out.println("Begin " + player1.getName() + "'s turn");
      }
    }
    if (player1.getPoints() > player2.getPoints()){
      System.out.println(player1.getName() + " wins!");
      
    }else if (player2.getPoints() > player1.getPoints()){
      System.out.println(player2.getName() + " wins!");
     
    }else{
      System.out.println("You tied.");
    }
    System.out.println(player1.getName() + ": " + player1.getPoints());
    System.out.println(player2.getName() + ": " + player2.getPoints());
  }
  
  
}