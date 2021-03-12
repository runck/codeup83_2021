package game;

import java.util.*;
import game.poker.JudgeManager;

// Please don't modify the class name.
public class Poker {

    // Please don't modify the signature of this method.
    // Please keep the result output format.
    public String compairResult(String player1, String player2) {
        return JudgeManager.getInstance().judge(player1, player2);
    }
 
}
