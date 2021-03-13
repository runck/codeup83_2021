package game.comparator.cardset;

import game.comparator.Card;
import game.comparator.BaseCardSet;

import java.util.*;
import static java.util.stream.Collectors.groupingBy;

public class FthreeOfAkindSet extends BaseCardSet {
    public FthreeOfAkindSet(){
        setType = "ThreeOfAKind";
    }
    private static final int TYPE_CARD_TYPE_COUNT = 3;
    private static final int TYPE_CARD_NAME_COUNT_3 = 3;
    private static final int TYPE_CARD_NAME_COUNT_1 = 1;

    @Override
    public List<Card> tryForm(List<Card> cards) {
        Map<String, List<Card>> collect = cards.stream().collect(groupingBy(Card::getNumStr));
        if (collect.size() != TYPE_CARD_TYPE_COUNT) {
            return null;
        }
        List<Integer> counts = new ArrayList<>();
        counts.add(TYPE_CARD_NAME_COUNT_3);
        counts.add(TYPE_CARD_NAME_COUNT_1);
        counts.add(TYPE_CARD_NAME_COUNT_1);
        Collection<List<Card>> values = collect.values();
        for (List<Card> value : values) {
            if (counts.isEmpty()) {
                return null;
            }
            counts.remove(Integer.valueOf(value.size()));
        }
        if (!counts.isEmpty()) {
            return null;
        }
        List<Card> triple = new ArrayList<>();
        List<Card> point = new ArrayList<>();
        for (List<Card> value : collect.values()) {
            if (value.size() == TYPE_CARD_NAME_COUNT_3) {
                triple.add(value.get(0));
            } else {
                point.add(value.get(0));
            }
        }
        Collections.sort(triple);
        Collections.sort(point);
        point.addAll(triple);
        return point;
    }
}
