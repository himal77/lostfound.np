package np.com.lostfound.model;

import lombok.Data;

@Data
public class Item {
    private String id;
    private String name;
    private String description;
    private String category; /*  keys, wallet, phone, jewelry*/
    private String color;
    private String brand;
    private String lostDate;
    private String foundDate;
    private String lostLocation;
}
