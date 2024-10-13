package Products;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductData productData;

    public ProductData handle(String id) throws CustomException {
        log.info("ProductService: inside handle method");
        try{
            productData = productRepository.findByData(id);
            if(ObjectUtils.isEmpty(productData)){
                log.info("no data found, returning empty list");
                return productData;
            }
        }catch(Exception e){
            log.error("error occurred during fetching the data from db");
            throw new CustomException("",HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return productData;
    }
}
