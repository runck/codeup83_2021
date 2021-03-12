package game.poker;

import java.util.List;


public abstract class BaseJudge{
    private static final String TIE = "tie";
    private static final int ZERO = 0;
    private static final String PLAY1 = "player1";
    private static final String PLAY2 = "player2";
    private static final String WIN_SAME_TYPE = "%s wins - high card:%s";
    private static final String WIN_NOT_SAME_TYPE = "%s wins - %s";

    /**
     * 裁判
     *
     * @param cards1 玩家1的牌
     * @param cards2 玩家2的牌
     * @return 返回不为空表示有结果了
     */
    public String judge(List<Card> cards1, List<Card> cards2) {
        List<Card> cardType1 = getCardType(cards1);
        List<Card> cardType2 = getCardType(cards2);
        if (cardType1 != null && cardType2 != null) {
            CompareResult compare = compare(cardType1, cardType2);
            if (compare.getCompare() == ZERO) {
                return TIE;
            }
            return String.format(WIN_SAME_TYPE, compare.getCompare() > ZERO ? PLAY1 : PLAY2, compare.getName());
        }
        if (cardType1 != null) {
            return String.format(WIN_NOT_SAME_TYPE, PLAY1, getTypeName());
        }
        if (cardType2 != null) {
            return String.format(WIN_NOT_SAME_TYPE, PLAY2, getTypeName());
        }
        return null;
    }


    /**
     * 获取一副牌的牌型，如果没有就返回null
     *
     * @param cards 一副牌
     * @return 匹配到牌型后，从小到大返回剩余的比较点数
     */
    public abstract List<Card> getCardType(List<Card> cards);


    /**
     * 获取牌型名字
     *
     * @return 返回牌型名字
     */
    public abstract String getTypeName();


    /**
     * 按照点数大小匹配牌型，先比列表后面的牌
     */
    private CompareResult compare(List<Card> cards1, List<Card> cards2) {
        for (int i = cards1.size() - 1; i >= 0; i--) {
            Card card1 = cards1.get(i);
            Card card2 = cards2.get(i);
            int compare = card1.compareTo(card2);
            if (compare != ZERO) {
                return new CompareResult(compare, compare > ZERO ? card1.getName() : card2.getName());
            }
        }
        return new CompareResult(ZERO, null);
    }

    /**
     * 比较结果，并返回判断一副牌大小的那一张牌
     */
    static class CompareResult {
        private final int compare;
        private final String name;

        public CompareResult(int compare, String name) {
            this.compare = compare;
            this.name = name;
        }

        public int getCompare() {
            return compare;
        }

        public String getName() {
            return name;
        }
    }
}
