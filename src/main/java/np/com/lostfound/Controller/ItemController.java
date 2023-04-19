package np.com.lostfound.Controller;

import lombok.extern.slf4j.Slf4j;
import np.com.lostfound.model.Item;
import np.com.lostfound.service.ItemService;
import np.com.lostfound.service.ItemServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/items")
public class ItemController {
    private ItemService itemService = new ItemServiceImpl();

    @PostMapping
    private Item createItem(@RequestBody final Item item) {
        return itemService.saveItem(item);
    }

    @GetMapping
    private List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{itemId}")
    private Item findItemById(@PathVariable("itemId") String id) {
        return itemService.getItemsById(id);
    }

    @DeleteMapping("/{itemId}")
    private void deleteItem(@PathVariable("itemId") String id) {
        itemService.deleteItem(id);
    }

    @PutMapping("/{itemId}")
    private Item putItem(@PathVariable String itemId, @RequestBody Item updatedItem) {
        return itemService.updateItem(itemId, updatedItem);
    }
}
