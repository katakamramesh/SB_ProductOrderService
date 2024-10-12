package Products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.http.HttpHeaders;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    @GetMapping("/products")
    public ResponseEntity<List<ProductData>> getAllProductList() throws CustomException {
        GetAllProductService getAllProductService = new GetAllProductService();
        List<ProductData> productData = getAllProductService.handle();
        return new ResponseEntity<>(productData, HttpStatus.OK);
    }


    @GetMapping("/products/Id")
    public ResponseEntity<ProductData> getSpecific(@PathVariable String id) throws CustomException {
        ProductService productService = new ProductService();
        ProductData productData = productService.handle(id);
        return new ResponseEntity<>(productData, HttpStatus.OK);
    }

}
