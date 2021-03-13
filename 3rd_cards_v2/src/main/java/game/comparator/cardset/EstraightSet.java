package game.comparator.cardset;

import game.comparator.Card;
import game.comparator.BaseCardSet;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class EstraightSet extends BaseCardSet {
    public EstraightSet(){
        setType = "Straight";
    }
    private static final int TYPE_CARD_LEN = 5;

    @Override
    public List<Card> tryForm(List<Card> cards) {
        Map<String, List<Card>> collect = cards.stream().collect(groupingBy(Card::getNumStr));
        //没有5个分组，说明有牌都一样
        if (collect.size() != TYPE_CARD_LEN) {
            return null;
        }
        int code = cards.get(0).getNum();
        for (Card card : cards) {
            if (code != card.getNum()) {
                return null;
            }
            code++;
        }
        return cards;
    }

}
