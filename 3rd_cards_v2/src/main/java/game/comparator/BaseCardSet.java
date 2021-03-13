package game.comparator;

import java.util.List;


public abstract class BaseCardSet{
    private static final int ZERO = 0;
    private static final String PLAYER1 = "player1";
    private static final String PLAYER2 = "player2";
    private static final String WIN_SAME_TYPE = "%s wins - high card:%s";
    private static final String WIN_NOT_SAME_TYPE = "%s wins - %s";
    private static final String TIE = "tie";
    
    protected String setType;
        /**
     * 获取牌型名字
     *
     * @return 返回牌型名字
     */
    public String getSetType() {
        return this.setType;
    }


    /**
     * 获取一副牌的牌型，如果没有就返回null
     *
     * @param cards 一副牌
     * @return 匹配到牌型后，返回压缩后的牌组，之后先比右侧
     */
    public abstract List<Card> tryForm(List<Card> cards);


    /**
     * 裁判
     *
     * @param cards1 玩家1的牌
     * @param cards2 玩家2的牌
     * @return 返回不为空表示有结果了
     */
    public String tryCompareAs(List<Card> cards1, List<Card> cards2) {
        List<Card> formedSet1 = tryForm(cards1);
        List<Card> formedSet2 = tryForm(cards2);
        if (formedSet1 != null && formedSet2 != null) {
            for (int i = formedSet1.size() - 1; i >= 0; i--) {
                Card card1 = formedSet1.get(i);
                Card card2 = formedSet2.get(i);
                int res = card1.compareTo(card2);
                if (res > ZERO){
                    return String.format(WIN_SAME_TYPE, PLAYER1, card1.getNumStr());
                }
                if (res < ZERO){
                    return String.format(WIN_SAME_TYPE, PLAYER2, card2.getNumStr());
                }
                if (res == ZERO){
                    return TIE;
                }
            }
        }
        if (formedSet1 != null) {
            return String.format(WIN_NOT_SAME_TYPE, PLAYER1, getSetType());
        }
        if (formedSet2 != null) {
            return String.format(WIN_NOT_SAME_TYPE, PLAYER2, getSetType());
        }
        return null;
    }
    
}
