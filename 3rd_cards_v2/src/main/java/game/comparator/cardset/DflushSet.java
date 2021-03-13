package game.comparator.cardset;

import game.comparator.Card;
import game.comparator.BaseCardSet;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class DflushSet extends BaseCardSet {
    public DflushSet(){
        setType = "Flush";
    }
    private static final int TYPE_CARD_TYPE_COUNT = 1;

    @Override
    public List<Card> tryForm(List<Card> cards) {
        Map<String, List<Card>> collect = cards.stream().collect(groupingBy(Card::getType));
        //只有一种花色
        if (collect.size() == TYPE_CARD_TYPE_COUNT) {
            return cards;
        }
        return null;
    } 
}
