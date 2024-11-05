import java.util.Scanner;
import java.util.ArrayList;

public class DataRunner {
  public static void main(String[] args) {
    // Initializes a new UserStory object named player
    UserStory player = new UserStory("top3ptpercentage.txt", "threeptpercentage.txt", "top3ptmakes.txt", "3ptmakes.txt");
    String choice = "y";
    Scanner input = new Scanner(System.in);
    
    /* While loop that runs until choice equals n
     * Records input and makes decisions on functions to call
     * based on the input given
     */
    while (!choice.equals("n")) {
      int option = player.promptUserWithOption();

      if (option == 1) {
        /* Outputs the players by 3pt percentage
         * The amount of players displayed from the top is 
         * determined by the integer inputted
         */
        System.out.println("How many players would you like to search through? ");
        String[] top3ptPlayers = player.getHighest3ptPercentagePlayers(input.nextInt());
        System.out.println("Finding players...");
        for (String topPlayer : top3ptPlayers) {
          System.out.println(topPlayer);
        }
      }

      if (option == 2) {
         /* Outputs the players by 3pt shots made
         * The amount of players displayed from the top is 
         * determined by the integer inputted
         */
        System.out.println("How many players would you like to search through? ");
        String[] top3ptPlayers = player.getTopShotsMadePlayers(input.nextInt());
        
        System.out.println("Finding players...");
        for (String topPlayer : top3ptPlayers) {
          System.out.println(topPlayer);
        }
      }

      if (option == 3) {
        /* Outputs the players by 3pt shots made and 3pt percentage
         * The amount of players displayed from the top is 
         * determined by the integer inputted
         */
        System.out.println("How many players would you like to search through? ");
        ArrayList<String> topPlayerList = player.findBestShooters(input.nextInt());
        System.out.println("Finding players...");
        for (String plr : topPlayerList) {
          System.out.println(plr);
        }
      }

      if (option == 4) {
        /* Outputs the average of statistics based on the integer inputted
         * Like the Average 3pt Percentage (option 1)
         * And Average 3pt Shots Made (option 2)
         */
        System.out.println("What would you like to find the average of? \n 1. Percentage \n 2. Shots Made");
        int subOption = input.nextInt();
        if (subOption == 1) {
          System.out.println("Average 3pt Percentage: " + player.getAverage3ptPercentage() + "%");
        } else {
          System.out.println("Average 3pt Shots Made: " + player.getAverageShotsMade());
        }
      }
      
      choice = player.promptUserToContinue();
    }
    System.out.println(player.toString());
  }
}