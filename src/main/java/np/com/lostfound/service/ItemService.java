package np.com.lostfound.service;

import np.com.lostfound.model.Item;
import np.com.lostfound.model.vo.ItemStatus;
import java.util.List;

public interface ItemService {
    Item saveItem(Item item);
    List<Item> getAllItems();
    Item getItemsById(String itemID);
    Item updateItem(String itemId, Item item);
    void deleteItem(String itemId);
    ItemStatus getStatusById(String itemId);
    void changeStatusById(String itemId, ItemStatus itemStatus);
}
