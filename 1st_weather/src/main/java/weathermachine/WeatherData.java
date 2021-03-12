package weathermachine;

import java.util.List;

/**
 * @author tiger
 * @date 2021/3/11
 */
public class WeatherData {

    List<BaseMachine> machineList = null;

    public WeatherData(List<BaseMachine> machineList){
        this.machineList = machineList;
    }

    /**
     *
     * @param temp �¶�
     * @param humidity ʪ��
     * @param windPower ��
     */
    public void measurementsChanged(int temp, int humidity, int windPower){
        //����Ҫ������������ÿһ����ע����û�
        //һ�ѻ����ڿ����㣬������ÿһ��������Ҫ���߸�һ�������б�
        for (BaseMachine baseMachine : machineList) {
            baseMachine.watch(temp,humidity,windPower);
        }

    }
}
