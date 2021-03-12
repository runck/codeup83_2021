package weathermachine;

/**
 * @author tiger
 * @date 2021/3/11
 */
public class WateringMachine extends BaseMachine {

    /**
     * ������ʼ��ת
     * @param temp  �¶�
     * @param humidity ʪ��
     * @param windPower ���
     * @return ״̬
     */
    @Override
    public boolean tryStart(int temp, int humidity, int windPower){
        return temp > NUM_10 && humidity < NUM_55 && windPower < NUM_4;
    }
}

