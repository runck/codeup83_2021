package game.comparator;

import game.comparator.cardset.*;

import java.util.ArrayList;
import java.util.List;



public enum Comparator {  
    /**
     * 比较器单例
     * 
     */
    INSTANCE;
    
    private List<BaseCardSet> orderList = new ArrayList<>(); 
    
    private Comparator(){
        orderList.add(new AstraightFlushSet());
        orderList.add(new BfourOfAkindSet());
        orderList.add(new CfullHouseSet());
        orderList.add(new DflushSet());
        orderList.add(new EstraightSet());
        orderList.add(new FthreeOfAkindSet());
        orderList.add(new GtwoPairSet());
        orderList.add(new HonePairSet());
        orderList.add(new IhighCardSet());
    }

    /**
     * 裁判2个玩家的输赢
     */
    public String compare(String player1, String player2) {
        List<Card> cards1 = CardListFactory.createCards(player1);
        List<Card> cards2 = CardListFactory.createCards(player2);
        for (BaseCardSet cardSet : orderList) {
            String result = cardSet.tryCompareAs(cards1, cards2);
            if (result != null) {
                return result;
            }
        }
        return null;
    }


}
