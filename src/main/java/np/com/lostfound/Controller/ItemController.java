package np.com.lostfound.Controller;

import lombok.AllArgsConstructor;
import np.com.lostfound.model.Item;
import np.com.lostfound.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/items")
public class ItemController {

    private final ItemService itemService;

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
