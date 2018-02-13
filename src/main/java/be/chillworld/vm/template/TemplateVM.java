package be.chillworld.vm.template;

import be.chillworld.model.Item;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;

/**
 *
 * @author chillworld
 */
public class TemplateVM {

    private final ListModelList<Item> items = new ListModelList<>();

    @Init
    public void init() {
        items.add(new Item(20, "Oat Latte Macchiato", "Starbucks", 5));
        items.add(new Item(21, "Almond Latte Macchiato", "Starbucks", 6));
        items.add(new Item(21.5, "Coconut Latte Macchiato", "Starbucks", 7));
        items.add(new Item(22, "Latte Macchiato", "Starbucks", 8));
        items.add(new Item(23, "Caffè Americano", "Starbucks", 9));
        items.add(new Item(23.5, "Caffè Latte", "Starbucks", 4));
        items.add(new Item(24, "Caffè Mocha", "Starbucks", 3));
        items.add(new Item(25, "Cappuccino", "Starbucks", 2));
    }

    public ListModelList<Item> getItems() {
        return items;
    }

}
