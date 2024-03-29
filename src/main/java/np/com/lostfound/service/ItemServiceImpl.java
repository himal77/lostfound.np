package np.com.lostfound.service;

import lombok.AllArgsConstructor;
import np.com.lostfound.dao.ItemRepository;
import np.com.lostfound.model.Item;
import np.com.lostfound.model.vo.ItemStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Item getItemsById(String itemID) {
        if (itemRepository.existsById(itemID)) {
            return itemRepository.findById(itemID).get();
        } else {
            return null;
        }
    }

    @Override
    public Item updateItem(String itemId, Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(String itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public ItemStatus getStatusById(String itemId) {
        return itemRepository.findById(itemId).get().getStatus();
    }

    @Override
    public void changeStatusById(String itemId, ItemStatus itemStatus) {
        Item item = itemRepository.findById(itemId).get();
        item.setStatus(itemStatus);
        saveItem(item);
    }
}
