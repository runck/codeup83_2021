package store;

public class AgedWineStrategy implements Strategy{
    @Override
    public int updateValue(int sellIn, int value){
        value += sellIn <= 0 ? 2 : 1;
        return value < 0 ? 0 : value > 50 ? 50 : value;
    }
    
    @Override
    public int updateSellIn(int sellIn, int value){
        return sellIn-1;
    }
}
