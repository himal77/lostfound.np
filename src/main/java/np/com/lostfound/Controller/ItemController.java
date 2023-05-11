package np.com.lostfound.Controller;

import lombok.AllArgsConstructor;
import np.com.lostfound.model.Item;
import np.com.lostfound.model.vo.ItemStatus;
import np.com.lostfound.service.ItemService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


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

    @PutMapping("/{itemId}/changeStatus")
    private void changeStatus(@PathVariable String itemId, @RequestBody ItemStatus itemStatus) {
         itemService.changeStatusById(itemId, itemStatus);
    }

    @GetMapping("/{itemId}/status")
    private ItemStatus getStatus(@PathVariable String itemId) {
        return itemService.getStatusById(itemId);
    }
}
