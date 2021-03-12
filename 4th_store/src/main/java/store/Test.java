package store;

public class Test{
    Item[] items;
    items.add(new Item("Aged Wine",5,10));
    items.add(new Item("normal",5,10));
    
    public static void main(String[] args){        
        store = new Store(items);
        for(i=0; i<50;i++){
            for (Item item: store.items){
                System.out.println(item);
            }
            store.updateValue();
        }
    }
}