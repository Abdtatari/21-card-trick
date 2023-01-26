import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] Args){

        Scanner input= new Scanner(System.in);
        log gameLog = new log();

        cardDeck cards =cardDeck.getInstance();
        card [] twentyOneCard = cards.getRandomCards(21);

        for (card c : twentyOneCard)
        {
            System.out.println(c);
            gameLog.write(c.toString());
        }

        System.out.println("\n\t\t~~~~~~ Please choose one of these cards and memorize it ~~~~~~");
        System.out.println();
        System.out.println("Press any key to start");
        input.next();

        Stack<card> first = new Stack<>();
        Stack<card> second = new Stack<>();
        Stack<card> third = new Stack<>();

        boolean gameOver=false;
        int round=0;
        while (!gameOver) {

            gameLog.write("\n\nRound " + (round + 1) + "\n");

            if(round == 2)
            {
                gameOver = true;
            }
            gameFunctions.spiltToThreeStack(twentyOneCard,first, second, third);
            gameFunctions.printThreeStacks(first, second, third);

            gameLog.write("Group A : "+first.toString()+"\n");
            gameLog.write("Group B : "+second.toString()+"\n");
            gameLog.write("Group C : "+third.toString()+"\n");

            System.out.println("Which group contain your card");
            String userChoice = input.next();
            userChoice = userChoice.toLowerCase();

            gameLog.write("\nuser input : " + userChoice+"\n");

            while (!userChoice.equals("a") && !userChoice.equals("b") && !userChoice.equals("c")) {
                System.out.println("Wrong choice");
                userChoice = input.next();
                userChoice = userChoice.toLowerCase();
                gameLog.write("System output : Wrong choice\nuser input : " + userChoice );
            }
            switch (userChoice) {
                case "a" -> gameFunctions.mergeStacksInOrder(twentyOneCard, second, first, third);
                case "b" -> gameFunctions.mergeStacksInOrder(twentyOneCard, first, second, third);
                case "c" -> gameFunctions.mergeStacksInOrder(twentyOneCard, first, third, second);
            }
            round++;
        }
        System.out.println("Your card is : " + twentyOneCard[10]);

        gameLog.write("System output : Your card is : " + twentyOneCard[10]);
        gameLog.close();
    }
}
