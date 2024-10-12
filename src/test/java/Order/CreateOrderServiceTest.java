package Order;

import Products.CustomException;
import Products.ProductData;
import Products.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateOrderServiceTest {

    @Mock
    ProductService productService;

    @InjectMocks
    CreateOrderService createOrderService;

    @Test
    void testOrderHandleEmptyData(){
        Assertions.assertNotNull(createOrderService.handle(Mockito.mock(CreateOrderRequest.class)));
    }

    @Test
    void testOrderHandle() throws CustomException {
        when(productService.handle(anyString())).thenReturn(Mockito.mock(ProductData.class));
        Assertions.assertNotNull(createOrderService.handle(Mockito.mock(CreateOrderRequest.class)));
    }
}
