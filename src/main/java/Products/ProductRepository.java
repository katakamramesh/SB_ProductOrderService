package Products;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends Repository{

    @Query
    List<ProductData> getAllData();

    @Query("{'id':?0}")
    ProductData getSpecificData(String id);
}
