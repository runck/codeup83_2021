package store;

/**
* @author tiger
* @date 2021/1/1
*/
public interface Strategy {

    /**
     * 详细描述是什么呀，要写很多字吗
     * @author tiger
     * @date 2021/1/1
     * @param sellIn 卖出时间
     * @param value 价值
     * @return 新价值
     * @Description: 更新价值
     */
    public int updateValue(int sellIn, int value);

    /**
     * 详细描述是什么呀，要写很多字吗
     * @author tiger
     * @date 2021/1/1
     * @author tiger
     * @date 2021/1/1
     * @param sellIn 卖出时间
     * @param value 价值
     * @return 新卖出时间
     * @Description: 更新时间
     */
    public int updateSellIn(int sellIn, int value);
}
