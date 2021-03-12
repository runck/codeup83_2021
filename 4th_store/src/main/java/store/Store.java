package store;

// Please don't modify the class name.
public class Store {
    Item[] items;

    // Please don't modify the signature of this method.
    public Store(Item[] items) {
        this.items = items;
    }
    // Please don't modify the signature of this method.
    public void updateValue() {
        // BaseItemStrategy itemStrategy = null;
        // if (items.length == 0){
            // return;
        // }
        for (Item item : items) {
            item.update();
        }
    }
}
