package store;
import java.util.HashMap;
import java.util.Map;

// Please don't modify the class name.
public class Item {

    public String name;
    public int sellIn;
    public int value;

    private Strategy strategy;
    
    private static Map<String, Strategy> strategyMap;
    static {
        strategyMap = new HashMap<>();
        strategyMap.put("Aged Wine", new AgedWineStrategy());
        strategyMap.put("Show Ticket", new ShowTicketStrategy());
        strategyMap.put("Cure", new CureStrategy());
        strategyMap.put("Sulfuras", new SulfurasStrategy());
    }

    // Please don't modify the signature of this method.
    public Item(String name, int sellIn, int value) {
        this.name = name;
        this.sellIn = sellIn;
        this.value = value;
        if (strategyMap.containsKey(name)){
            strategy = strategyMap.get(name);
        } else {
            strategy = new DefaultStrategy();
        }
    }


    // Please don't modify the signature of this method.
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.value;
    }
    
    public void update(){
        value = strategy.updateValue(sellIn, value);
        sellIn = strategy.updateSellIn(sellIn, value);
    }
    
    
}
