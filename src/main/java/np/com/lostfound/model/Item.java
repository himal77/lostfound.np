package np.com.lostfound.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Items")
@Data
public class Item {
    @Id
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
