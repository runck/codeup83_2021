package game.poker.card;

import game.poker.Card;
import game.poker.BaseJudge;

import java.util.List;

public class AstraightFlushJudge extends BaseJudge {
    public static final String TYPE_NAME = "StraightFlush";

    @Override
    public List<Card> getCardType(List<Card> cards) {
        return isStraightFlush(cards) ? cards : null;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }


    /**
     * 是不是StraightFlush牌型
     */
    private boolean isStraightFlush(List<Card> cards) {
        int code = cards.get(0).getCode();
        String type = cards.get(0).getType();
        for (Card card : cards) {
            if (card.getCode() != code || !type.equals(card.getType())) {
                return false;
            }
            code++;
        }
        return true;
    }
}
