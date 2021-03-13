package game.comparator.cardset;

import game.comparator.Card;
import game.comparator.BaseCardSet;

import java.util.List;

public class IhighCardSet extends BaseCardSet {
    public IhighCardSet(){
        setType = "HighCard";
    }

    @Override
    public List<Card> tryForm(List<Card> cards) {
        return cards;
    }
}
