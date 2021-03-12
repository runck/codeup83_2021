package game.poker.card;

import game.poker.Card;
import game.poker.BaseJudge;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class CfullHouseJudge extends BaseJudge {
    public static final int TYPE_CARD_TYPE_COUNT = 2;
    public static final int TYPE_CARD_COUNT_LESS = 2;
    public static final int TYPE_CARD_COUNT_MORE = 3;

    public static final String TYPE_NAME = "FullHouse";

    @Override
    public List<Card> getCardType(List<Card> cards) {
        Map<String, List<Card>> collect = cards.stream().collect(groupingBy(Card::getName));
        if (collect.size() != TYPE_CARD_TYPE_COUNT) {
            return null;
        }
        List<String> names = new ArrayList<>(collect.keySet());
        String name1 = names.get(0);
        String name2 = names.get(1);
        //一个是4张，一个是1张
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

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
