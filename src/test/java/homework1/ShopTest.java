package homework1;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Shop shop;
    private String[] titles;

    private Integer[] cost;

    @BeforeAll
    static void setup() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    void init() {
        shop = new Shop();
        titles = new String[]{"Coffee", "Tea", "Milk", "Juice", "Shake"};
        cost = new Integer[]{100, 400, 150, 230, 80};
        List<Product> productList = new ArrayList<Product>();
        for (int i = 0; i < titles.length; i++){
            Product product = new Product();
            product.setTitle(titles[i]);
            product.setCost(cost[i]);
            productList.add(product);
        }
        shop.setProducts(productList);
    }

    @AfterEach
    void cleanup() {
        shop = null;
    }

    @AfterAll
    static void teardown() {
        System.out.println("After all tests");
    }

    @Test
    @DisplayName("Test correct number of products")
    void testGetProducts(){
        List<Product> result = shop.getProducts();
        assertEquals(5, result.size(), "The size of the product's list must equal 5" );
    }

    @Test
    @DisplayName("Test content of the shop")
    void testContentShop(){
        List<Product> result = shop.getProducts();
        String[] resultTitles = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultTitles[i] = result.get(i).getTitle();
        }
        assertArrayEquals(resultTitles, titles, "The names in the arrays must match");
    }

    @Test
    @DisplayName("Test sort product by min value")
    void testMinValue() {
        List<Product> result = shop.sortProductsByPrice();
        List listCost = Arrays.asList(cost);
        assertEquals(result.get(0).getCost(), Collections.min(listCost), "The first member of the " +
                "sorted array must be equal to 80");
    }

    @Test
    @DisplayName("Test sort product by max value")
    void testMaxValue() {
        List<Product> result = shop.sortProductsByPrice();
        int len = result.size() - 1;
        List listCost = Arrays.asList(cost);
        assertEquals(result.get(len).getCost(), Collections.max(listCost), "The last member of the " +
                "sorted array must be equal to 400");
    }

    @Test
    @DisplayName("Test get most expensive product")
    void test(){
        Product expensiveProduct = shop.getMostExpensiveProduct();
        List listCost = Arrays.asList(cost);
        assertEquals(expensiveProduct.getCost(), Collections.max(listCost), "The cost of the most expensive " +
                "product should be equal to 400");
    }
}