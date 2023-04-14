package np.com.lostfound.Controller;

import lombok.extern.slf4j.Slf4j;
import np.com.lostfound.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();

    @PostMapping
    public Item createItem(@RequestBody final Item item) {
        items.add(item);
        log.info(item.toString() + " created!");
        return item;
    }

    @GetMapping
    public List<Item> getItems() {
        log.info("items fetched!");
        return items;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem (@PathVariable ("id") String id){
        Item itemToDelete = null;
        for(Item item: items){
            if(item.getId().equals(id)){
                itemToDelete = item;
                break;
            }
        }
        if(itemToDelete != null){
            items.remove(itemToDelete);
            log.info("Item with ID " + id + " deleted");
            return ResponseEntity.ok().body("Item with ID " + id + " deleted!");
        }else{
            log.info("Item with ID " + id + " not found!");
            return ResponseEntity.notFound().build();
        }
    }
}
