package Products;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.List;

@Service
@Slf4j
public class GetAllProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductData> handle() throws CustomException {
        log.info("GetAllProductService: inside the handle method of get all products");
        List<ProductData> list;
        try{
            list = productRepository.getAllData();
            if(ObjectUtils.isEmpty(list)){
                log.info("GetAllProductService: no data found in db");
                return list;
            }
        }catch(Exception e){
            log.error("GetAllProductService: exception to hit the db for get all products");
            throw new CustomException("Oops we hit an error",HttpStatus.EXPECTATION_FAILED.value());
        }
        return list;
    }

}
