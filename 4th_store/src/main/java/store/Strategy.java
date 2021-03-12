package store;

/**
* @author tiger
* @date 2021/1/1
*/
public interface Strategy {

    /**
     * ��ϸ������ʲôѽ��Ҫд�ܶ�����
     * @author tiger
     * @date 2021/1/1
     * @param sellIn ����ʱ��
     * @param value ��ֵ
     * @return �¼�ֵ
     * @Description: ���¼�ֵ
     */
    public int updateValue(int sellIn, int value);

    /**
     * ��ϸ������ʲôѽ��Ҫд�ܶ�����
     * @author tiger
     * @date 2021/1/1
     * @author tiger
     * @date 2021/1/1
     * @param sellIn ����ʱ��
     * @param value ��ֵ
     * @return ������ʱ��
     * @Description: ����ʱ��
     */
    public int updateSellIn(int sellIn, int value);
}
