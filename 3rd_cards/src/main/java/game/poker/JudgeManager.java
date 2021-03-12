package game.poker;

import game.poker.card.*;

import java.util.ArrayList;
import java.util.List;

public class JudgeManager {
    private static final String TIE = "tie";
    private List<BaseJudge> judges = new ArrayList<>();
    private static JudgeManager sInstance;

    private JudgeManager() {
        judges.add(new AstraightFlushJudge());
        judges.add(new BfourOfAkindJudge());
        judges.add(new CfullHouseJudge());
        judges.add(new DflushJudge());
        judges.add(new EstraightJudge());
        judges.add(new FthreeOfAkindJudge());
        judges.add(new GtwoPairJudge());
        judges.add(new HonePairJudge());
        judges.add(new IhighCard());
    }

    public static JudgeManager getInstance() {
        if (sInstance == null) {
            sInstance = new JudgeManager();
        }
        return sInstance;
    }

    /**
     * 裁判2个玩家的输赢
     */
    public String judge(String player1, String player2) {
        List<Card> cards1 = CardFactory.createCards(player1);
        List<Card> cards2 = CardFactory.createCards(player2);
        for (BaseJudge judge : judges) {
            String result = judge.judge(cards1, cards2);
            if (result != null) {
                return result;
            }
        }
        //平手
        return TIE;
    }


}
