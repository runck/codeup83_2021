package game.poker.card;

import game.poker.Card;
import game.poker.BaseJudge;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class IhighCard extends BaseJudge {
    public static final String TYPE_NAME = "HighCard";

    @Override
    public List<Card> getCardType(List<Card> cards) {
        return cards;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
