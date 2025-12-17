import java.util.Scanner;
import java.util.Random;

class test {

    public static String greeting(Scanner sc, int rating){
        System.out.print("Enter your name: ");
        String player = sc.nextLine();

        System.out.println("Hello, "+ player + "!");
        System.out.println("Current Score: " + rating);
        System.out.println("Lose 3 times and the game will end automatically.");
        System.out.println("Type 'end' to stop manually.");
        
        return player;
    }

    public static String getComputerChoice(){
        String[] computerChoices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        return computerChoices[random.nextInt(computerChoices.length)];
    }

    public static int userWin(String computer){
        System.out.println("You win! Computer chose " + computer);
        return 100;
    }
    
    public static int userLose(String computer){
        System.out.println("You lose! Computer chose " + computer);
        return 0;
    }

    public static int draw(String computer){
        System.out.println("It's a draw! Both chose " + computer);
        return 50;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rating = 0;
        int loseCount = 0;

        greeting(sc, rating);

        while(true){
            System.out.print("\nEnter your choice (Rock, Paper, Scissors): ");
            String user = sc.nextLine();

            if(user.equalsIgnoreCase("end")){
                System.out.println("\nGame ended by player.");
                break;
            }

            if(!user.equalsIgnoreCase("Rock") && 
               !user.equalsIgnoreCase("Paper") && 
               !user.equalsIgnoreCase("Scissors")){
                System.out.println("Invalid input! Try again.");
                continue;
            }

            String computer = getComputerChoice();

            if(user.equalsIgnoreCase(computer)){
                rating += draw(computer);
            } 
            else if( (user.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
                     (user.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
                     (user.equalsIgnoreCase("Scissors") && computer.equals("Paper")) ) {
                rating += userWin(computer);
            }
            else {
                rating += userLose(computer);
                loseCount++;
                System.out.println("Loses: " + loseCount + "/3");
            }

            System.out.println("Current Score: " + rating);

            if(loseCount >= 3){
                System.out.println("\nYou've lost 3 times. Game Over!");
                break;
            }
        }

        System.out.println("Final Score: " + rating);
        sc.close();
    }
}
