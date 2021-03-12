package weathermachine;

/**
 * @author tiger
 * @date 2021/3/11
 */
public abstract class BaseMachine {


    public final static int NUM_4 = 4;
    public final static int NUM_5 = 5;
    public final static int NUM_55 = 55;
    public final static int NUM_10 = 10;
    public final static int NUM_65 = 65;

    protected boolean status;

    /**
     * 获取一个当前机器的状态
     * @return 返回一个值
     */
    public boolean getStatus(){
        return status;
    }

    /**
     * 通知观察者
     * @param temp 温度
     * @param humidity 湿度
     * @param windPower 风度
     */
    public void watch(int temp, int humidity, int windPower){
        this.status = tryStart(temp , humidity , windPower);
    }

    /**
     * 机器开始运转
     * @param temp  温度
     * @param humidity 湿度
     * @param windPower 风度
     * @return 状态
     */
    abstract boolean tryStart(int temp, int humidity, int windPower);

}
