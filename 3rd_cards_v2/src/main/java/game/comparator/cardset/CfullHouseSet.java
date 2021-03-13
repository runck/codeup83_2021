package game.comparator.cardset;

import game.comparator.Card;
import game.comparator.BaseCardSet;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import static java.util.stream.Collectors.groupingBy;

public class CfullHouseSet extends BaseCardSet {
    public CfullHouseSet(){
        setType = "FullHouse";
    }
    public static final int TYPE_CARD_TYPE_COUNT = 2;
    public static final int TYPE_CARD_COUNT_LESS = 2;
    public static final int TYPE_CARD_COUNT_MORE = 3;

    @Override
    public List<Card> tryForm(List<Card> cards) {
        Map<String, List<Card>> collect = cards.stream().collect(groupingBy(Card::getNumStr));
        if (collect.size() != TYPE_CARD_TYPE_COUNT) {
            return null;
        }
        List<String> names = new ArrayList<>(collect.keySet());
        String name1 = names.get(0);
        String name2 = names.get(1);

        List<Card> resultCards = new ArrayList<>();
        if ((collect.get(name1).size() == TYPE_CARD_COUNT_LESS && collect.get(name2).size() == TYPE_CARD_COUNT_MORE)) {
            resultCards.add(collect.get(name1).get(0));
            resultCards.add(collect.get(name2).get(0));
            return resultCards;
        }
        if ((collect.get(name1).size() == TYPE_CARD_COUNT_MORE && collect.get(name2).size() == TYPE_CARD_COUNT_LESS)) {
            resultCards.add(collect.get(name2).get(0));
            resultCards.add(collect.get(name1).get(0));
            return resultCards;
        }
        
        return null;
    }
}
