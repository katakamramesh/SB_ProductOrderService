package Order;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class CreateOrderRequest {
    String id;
    String customerName;
    List<String> productIds;
    LocalDate date;
}
