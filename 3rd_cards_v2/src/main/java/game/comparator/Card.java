package game.comparator;

import java.util.Map;
import java.util.HashMap;

public class Card implements Comparable<Card> {

    private static Map<String, Integer> numMap;

    static {
        numMap = new HashMap<>();
        numMap.put("2", 2);
        numMap.put("3", 3);
        numMap.put("4", 4);
        numMap.put("5", 5);
        numMap.put("6", 6);
        numMap.put("7", 7);
        numMap.put("8", 8);
        numMap.put("9", 9);
        numMap.put("T", 10);
        numMap.put("J", 11);
        numMap.put("Q", 12);
        numMap.put("K", 13);
        numMap.put("A", 14);
    }


    /**
     * 点数
     */
    private String numStr;
    /**
     * 编码
     */
    private int num;
    /**
     * 花色
     */
    private String type;

    public Card(String numStr, String type) {
        this.numStr = numStr;
        this.num = numMap.get(numStr);
        this.type = type;
    }

    public String getNumStr() {
        return numStr;
    }

    public int getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(Card o) {
        return num - o.num;
    }
}
