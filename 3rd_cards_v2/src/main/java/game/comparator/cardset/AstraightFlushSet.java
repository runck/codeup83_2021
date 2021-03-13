package game.comparator.cardset;

import game.comparator.Card;
import game.comparator.BaseCardSet;

import java.util.List;

public class AstraightFlushSet extends BaseCardSet {
    public AstraightFlushSet(){
        setType = "StraightFlush";
    }

    @Override
    public List<Card> tryForm(List<Card> cards) {
        int point = cards.get(0).getNum();
        String type = cards.get(0).getType();
        for (Card card : cards) {
            if (card.getNum() != point || !type.equals(card.getType())) {
                return null;
            }
            point++;
        }
        return cards;
    }
}
