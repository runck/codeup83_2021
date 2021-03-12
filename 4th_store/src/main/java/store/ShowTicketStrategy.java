package store;

public class ShowTicketStrategy implements Strategy{
    @Override
    public int updateValue(int sellIn, int value){
        value += sellIn <= 5  ? 1 : 0;
        value += sellIn <= 10 ? 1 : 0;
        value = sellIn <= 0 ? 0 : value + 1;
        return value < 0 ? 0 : value > 50 ? 50 : value;
    }
    
    @Override
    public int updateSellIn(int sellIn, int value){
        return sellIn-1;
    }
}
