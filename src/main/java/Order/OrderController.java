package Order;

import Products.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class OrderController {

    @PostMapping("/orders")
    public ResponseEntity<CreateOrderResponse> createNewOrder(
            @RequestBody CreateOrderRequest createOrderRequest) throws CustomException {
        CreateOrderService createOrderService = new CreateOrderService();
        createOrderService.handle(createOrderRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
