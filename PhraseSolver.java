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
      System.out.println(game.getSolvedPhrase());
      /* your code here - game logic */
      Scanner sc = new Scanner(System.in);
      System.out.println("Do you want to guess the phrase or a letter?");
      String string = sc.nextLine();
      game.setLetterValue();
      int letterValue = game.getCurrentLetterValue();
      if (string.equals("letter")){
        System.out.println("Enter a letter");
        string = sc.nextLine();
        correct = game.guessLetter(string);
        if (correct) {
          System.out.println("Your guessed letter was in the phrase");
          if (currentPlayer == 1){
            player1.addToPoints(letterValue);
          }else{
            player2.addToPoints(letterValue);
          }
        } else {
          System.out.println("Your guessed letter was not in the phrase");
        }
        solved = game.isSolved(game.getSolvedPhrase());
      }
      else if (string.equals("phrase")){
        System.out.println("Enter a phrase");
        string = sc.nextLine();
        if (string.equals(game.getPhrase())){
          if (currentPlayer == 1){
            player1.addToPoints(1000000);
          }else{
            player2.addToPoints(1000000);
          }
          solved = true;
        }
      }

      /* your code here - determine how game ends */     
      if(currentPlayer == 1 && !correct){
        currentPlayer = 2;
      } else if (currentPlayer == 2 && !correct){
        currentPlayer = 1;
      }
    } 
   
  }
  
}