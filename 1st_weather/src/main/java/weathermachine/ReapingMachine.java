package weathermachine;

/**
 * @author tiger
 * @date 2021/3/11
 */
public class ReapingMachine extends BaseMachine{


    /**
     * ������ʼ��ת
     * @param temp  �¶�
     * @param humidity ʪ��
     * @param windPower ���
     * @return ״̬
     */
    @Override
    public boolean tryStart(int temp, int humidity, int windPower) {
        //�ջ�
        return temp > NUM_5 && humidity > NUM_65;
    }
}