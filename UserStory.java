import java.util.Scanner;
import java.util.ArrayList;

public class UserStory {
  // Instance variables
  private String[] top3ptPercentPlayers;
  private String[] top3ptMakesPlayers;

  private double[] top3ptPercent;
  private int[] top3ptMakes;

  // No-argument constructor
  public UserStory() {
    this("top3ptpercentage.txt", "threeptpercentage.txt", "top3ptmakes.txt", "3ptmakes.txt");
  }

  /* Parameterized constructor
   * Initliazies and reads the files
   * Then converts them to an array type that can be read by the code
   */ 
  public UserStory(String top3ptPercentPlayers, String top3ptPercent, String top3ptMakesPlayers, String top3ptMakes) {
    this.top3ptPercentPlayers = FileReader.toStringArray(top3ptPercentPlayers);
    this.top3ptPercent = FileReader.toDoubleArray(top3ptPercent);

    this.top3ptMakesPlayers = FileReader.toStringArray(top3ptMakesPlayers);
    this.top3ptMakes = FileReader.toIntArray(top3ptMakes);
  }
  
  /* Scans for input of an integer
   * Then returns the integer input the user entered 
   * and closes the input object
   */
  public int promptUserWithOption() {
    Scanner input = new Scanner(System.in);
    System.out.println("Find the best 3pt shooters by: ");
    System.out.println("1. Percentage");
    System.out.println("2. Shots Made");
    System.out.println("3. Overall");
    System.out.println("4. Average");
    int option = input.nextInt();
    input.nextLine();
    input.close();
    return option;
  }

  /* Allows the user to decide whether to continue or quit the application
   * returns either "y" or "n"
   * and closes the input object
    */
  public String promptUserToContinue() {
    Scanner input = new Scanner(System.in);
    System.out.println("\n Would you like to search for more info?");
    System.out.println("Enter \"y\" to continue or \"n\" to quit");  
    String verdict = input.nextLine();
    input.close();
    return verdict;
  }
  
  /* Gets the average of 3pt shots made
   * Among the players in top 250 of 3pt shots made
   * Adds them all up and divides by the list length (250)
   */
  public double getAverageShotsMade() {
    double total = 0;
    for (int makesIndex = 0; makesIndex < top3ptMakes.length; makesIndex++) {
       total += top3ptMakes[makesIndex];
    }
    double shotsMade = (total / top3ptMakes.length);
    return Math.round(shotsMade);
  }

  /* Gets the average of 3pt percentages
   * Among the players in the top 250 of 3pt percentage
   * Adds them all up and divides by the list length (250)
   */
  public double getAverage3ptPercentage() {
    double total = 0;
    for (int percentIndex = 0; percentIndex < top3ptPercent.length; percentIndex++) {
       total += top3ptPercent[percentIndex];
    }
    double percentage = (total / top3ptPercent.length) * 100.0;
    return Math.round(percentage * 100.0) / 100.0;
  }

  /* Lists the top 3 point shooters names by shots made 
   * in order from greatest to least
   * maxPlayers specifies the amount of players from the top listed
   */
  public String[] getTopShotsMadePlayers(int maxPlayers) {
      if (maxPlayers > top3ptPercent.length) {
        maxPlayers = top3ptPercent.length;
      }
      String[] topPlayers = new String[maxPlayers];
      for (int makesIndex = 0; makesIndex < maxPlayers; makesIndex++) {
          topPlayers[makesIndex] = top3ptMakesPlayers[makesIndex] + ": " + top3ptMakes[makesIndex] + " three point shots made";
      }
      return topPlayers;
  }

  /* Lists the top 3 point shooters names by percentage
   * In order from greatest to least
   * maxPlayers specifies the amount of players from the top listed
   */
  public String[] getHighest3ptPercentagePlayers(int maxPlayers) {
     if (maxPlayers > top3ptPercent.length) {
        maxPlayers = top3ptPercent.length;
      }
      String[] top5players = new String[maxPlayers];
      for (int percentPlayerIndex = 0; percentPlayerIndex < maxPlayers; percentPlayerIndex++) {
          double percentage = top3ptPercent[percentPlayerIndex] * 100.0;
          top5players[percentPlayerIndex] = (percentPlayerIndex + 1) + ". " + top3ptPercentPlayers[percentPlayerIndex] + " 3pt Percentage: " + (Math.round(percentage * 100.0) / 100.0) + "%";
      }
      return top5players;
  }
  /* Uses the ArrayList library, creates a new array
   * and appends items from the 1D array
   * if an item occurs and matches one another in both 1D arrays
   * top3ptPercentagePlayers and top3ptMakesPlayers
   */
  public ArrayList<String> findBestShooters(int maxCount) {
    int count = 0;
    ArrayList<String> bestShooters = new ArrayList<String>();
    for (int makesPlayerIndex = 0; makesPlayerIndex < top3ptMakesPlayers.length; makesPlayerIndex++) {
        for (int percentPlayerIndex = 0; percentPlayerIndex < top3ptPercentPlayers.length; percentPlayerIndex++) {
            if (top3ptPercentPlayers[percentPlayerIndex].equals(top3ptMakesPlayers[makesPlayerIndex])) {
              double percentage = top3ptPercent[percentPlayerIndex] * 100.0;
              count++;
              bestShooters.add(count + ". " + top3ptMakesPlayers[makesPlayerIndex] + "\n 3pt Percentage: " + (Math.round(percentage * 100.0) / 100.0) + "% \n 3pt Shots Made: " + top3ptMakes[makesPlayerIndex]);
              if (count >= maxCount) {
                return bestShooters;
              }
            }
        }
    }
    return bestShooters;
  }

  /* Returns and provides general information
   * about the amount of players in the dataset/1D array
   * aswell as the lowest percentage and lowest shot makes in those arrays
   */
  public String toString() {
    double least3ptPercentage = (top3ptPercent[top3ptPercent.length - 1]) * 100;
    return "Players sampled: " + top3ptMakesPlayers.length + 
      "\n Lowest 3pt percentage sampled: " + (Math.round(least3ptPercentage * 100.0) / 100.0) + 
      "%\n Least 3pt shots made sampled: " + top3ptMakes[top3ptMakes.length - 1];
  }
 
}