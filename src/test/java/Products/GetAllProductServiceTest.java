package Products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetAllProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    GetAllProductService getAllProductService;

    @Test
    void testProductHandle() throws CustomException {
        List<ProductData> mockNameList = Mockito.mock(List.class);

        when(productRepository.getAllData()).thenReturn(mockNameList);
        Assertions.assertNotNull(getAllProductService.handle());
    }

}
