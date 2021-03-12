package game.poker.card;

import game.poker.Card;
import game.poker.BaseJudge;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class EstraightJudge extends BaseJudge {

    public static final String TYPE_NAME = "Straight";
    private static final int TYPE_CARD_LEN = 5;

    @Override
    public List<Card> getCardType(List<Card> cards) {
        Map<String, List<Card>> collect = cards.stream().collect(groupingBy(Card::getName));
        //没有5个分组，说明有牌都一样
        if (collect.size() != TYPE_CARD_LEN) {
            return null;
        }
        int code = cards.get(0).getCode();
        for (Card card : cards) {
            if (code != card.getCode()) {
                return null;
            }
            code++;
        }
        return cards;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
