package np.com.lostfound.service;

import lombok.extern.slf4j.Slf4j;
import np.com.lostfound.model.Item;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ItemServiceImpl implements ItemService {
    private List<Item> items = new ArrayList<>();

    @Override
    public Item saveItem(Item item) {
        items.add(item);
        log.info(item.toString() + " created!");
        return item;
    }

    @Override
    public List<Item> getAllItems() {
        log.info("items fetched!");
        return items;
    }

    @Override
    public Item getItemsById(String itemId) {
        Item itemFound = null;

        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                itemFound = item;
                break;
            }
        }

        if (itemFound != null) {
            log.info("item fetched regarding id!");
            return itemFound;
        } else {
            log.info("item couldn't fetch because item doesn't exit!");
            return null;
        }
    }

    @Override
    public Item updateItem(String itemId, Item updatedItem) {
        Item itemToUpdate = null;

        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                itemToUpdate = item;
                break;
            }
        }

        if (itemToUpdate != null) {
            itemToUpdate.setCategory(updatedItem.getName());
            itemToUpdate.setDescription(updatedItem.getDescription());
            itemToUpdate.setCategory(updatedItem.getCategory());
            itemToUpdate.setColor(updatedItem.getColor());
            itemToUpdate.setBrand(updatedItem.getBrand());
            itemToUpdate.setLostDate(updatedItem.getLostDate());
            itemToUpdate.setFoundDate(updatedItem.getFoundDate());
            itemToUpdate.setLostLocation(updatedItem.getLostLocation());
            log.info("Item with ID " + itemId + "  updated");
            return itemToUpdate;
        } else {
            log.info("Item with ID " + itemId + " not found!");
            return null;
        }
    }

    @Override
    public void deleteItem(String id) {
        Item itemToDelete = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                itemToDelete = item;
                break;
            }
        }
        if (itemToDelete != null) {
            items.remove(itemToDelete);
            log.info("Item with ID " + id + " deleted");
        } else {
            log.info("Item with ID " + id + " not found!");
        }
    }
}
