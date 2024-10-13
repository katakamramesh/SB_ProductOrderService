package Order;

import Products.CustomException;
import Products.ProductData;
import Products.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class CreateOrderService {

    @Autowired
    ProductService productService;
    @Autowired
    ProductData productData;

    public ResponseEntity<CreateOrderResponse> handle(CreateOrderRequest createOrderRequest) throws CustomException {
        log.info("CreateOrderService: Inside handle method");
        try {
            productData = productService.handle(createOrderRequest.id);
            if(ObjectUtils.isEmpty(productData)){
                log.info("CreateOrderService: data empty in BD");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            log.error("CreateOrderService: exception Occurred while fetching data from db");
            throw new CustomException("Oops an error occurred ",HttpStatus.EXPECTATION_FAILED.value());
        }

    }
}
