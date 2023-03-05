import model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ProductTest {
    @Test
    @DisplayName("DefaultConstructor")
    public void WhenCallingDefaultContructor_ShouldCreateEmptyProduct(){
        Product product = new Product();

        assertEquals("", product.getId());
        assertEquals("", product.getDescription());
        assertEquals(0.00, product.getPrice());
        assertEquals(0, product.getCount());
    }

    @Test
    @DisplayName("ParamsConstructor")
    public void WhenCallingParamsConstructor_ShouldCreateProductWithSpecifiedDetails(){
        Product product = new Product("1234","Description",2.56,5);

        assertEquals("1234", product.getId());
        assertEquals("Description", product.getDescription());
        assertEquals(2.56, product.getPrice());
        assertEquals(5, product.getCount());
    }
}
