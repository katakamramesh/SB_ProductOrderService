package Products;

import lombok.Data;

@Data
public class ProductData{
    String id;
    String name;
    String description;
    int price;
    String imageUrl;
}
