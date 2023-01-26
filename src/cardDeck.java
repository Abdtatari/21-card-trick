import java.util.*;
public class cardDeck implements Iterable<card>{
    private static cardDeck deckObject =null;
    private static card[] deckCards=null;
    private cardDeck() {

        deckCards = new card[52]; //no jokers
        char[] types ={'♣','♥','♠','♦'};

        int index=0;

        for(int i=0;i<4;i++)
        {
            for (int j=0;j<13;j++)
            {
                deckCards[index] = new card();
                deckCards[index].setType(types[i]);

                switch (j + 1) {
                    case 11 -> deckCards[index].setValue("J");
                    case 12 -> deckCards[index].setValue("Q");
                    case 13 -> deckCards[index].setValue("K");
                    default -> deckCards[index].setValue(String.valueOf(j + 1));
                }
                index++;
            }
        }
    }

    //return instance of cardDeck ~singleton design~
    public static cardDeck getInstance()
    {
        if (deckObject == null)
        {
            deckObject = new cardDeck();
        }
        return deckObject;
    }

    //return N cards randomly
    public card[] getRandomCards(int n)
    {
        card[] randomCards = new card[n];

        List<card> temp = Arrays.asList(deckCards);
        Collections.shuffle(temp);

        try{
            for (int i=0;i<n;i++) {
            randomCards[i] = temp.get(i);
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("number of requested cards bigger than 52");
        }
        catch (Exception e){
            System.out.println("Something went wrong! Error msg :"+e);
        }
        return  randomCards;
    }

    /* iterator internal implementor*/
    private class InternalImplementor implements Iterator<card>
    {
        private int nextIndex = 0;
        private int lastIndex = -1;

        public boolean hasNext ()
        {
            return nextIndex != deckCards.length;
        }

        public card next ()
        {
            lastIndex = nextIndex;
            nextIndex++;

            return deckCards[lastIndex];
        }
    }

    @Override
    public Iterator<card> iterator() {
        return new InternalImplementor ();
    }

}
