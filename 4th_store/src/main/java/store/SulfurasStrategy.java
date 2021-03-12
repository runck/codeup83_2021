package store;

public class SulfurasStrategy implements Strategy{
    @Override
    public int updateValue(int sellIn, int value){
        return value < 0 ? 0 : value > 50 ? 50 : value;
    }
    
    @Override
    public int updateSellIn(int sellIn, int value){
        return sellIn;
    }
}
