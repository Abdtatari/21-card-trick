import java.util.Stack;

public class gameFunctions {
    static public void printThreeStacks(Stack<card> first, Stack<card> second, Stack<card> third)
    {
        System.out.println("Group (A)"+"\t\t\t\t\t"+"Group (B)"+"\t\t\t\t\t"+"Group(C)");

        for (int i=0;i<7;i++){
            System.out.println("\t"+first.elementAt(i)+"\t\t\t\t\t\t\t"+second.elementAt(i)+"\t\t\t\t\t\t\t"+third.elementAt(i));
        }
    }
    static public void mergeStacksInOrder(card[] twentyOneCard,Stack<card> first,Stack<card> second,Stack<card> third)
    {
        int i=0;//index

        while (!first.isEmpty())
        {
            twentyOneCard[i]=first.pop();
            i++;
        }

        while (!second.isEmpty())
        {
            twentyOneCard[i]=second.pop();
            i++;
        }

        while (!third.isEmpty())
        {
            twentyOneCard[i]=third.pop();
            i++;
        }
    }
    public static void spiltToThreeStack(card[] Cards, Stack<card> first, Stack<card> second, Stack<card> third){
        for(int i = 0; i < Cards.length; i += 3)
        {
            first.push(Cards[i]);
            second.push(Cards[i+1]);
            third.push(Cards[i+2]);
        }
    }

}
