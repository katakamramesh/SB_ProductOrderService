package Products;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductData, String>{

    @Query
    List<ProductData> findAllData();

    @Query("{'id':?0}")
    ProductData findByData(String id);
}
