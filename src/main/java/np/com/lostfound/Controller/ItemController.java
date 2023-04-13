package np.com.lostfound.Controller;

import np.com.lostfound.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();

    @PostMapping
    public Item createItem(@RequestBody final Item item){
        items.add(item);
        return item;
    }

    @GetMapping
    public List<Item> getItems(){
        return items;
    }
}
