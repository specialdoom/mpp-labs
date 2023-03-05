import com.vdurmont.emoji.EmojiParser;
import model.Product;
import repository.ProductRepository;

public class ProductShopMain {
    public static void main(String[] args){
        ProductRepository products = new ProductRepository();

        products.add(new Product("6420387582007", "Notebook", 1.25, 10));
        products.add(new Product("5942328200135", "Vitamin Aqua", 1.00, 10));

        System.out.println(EmojiParser.parseToHtmlDecimal("A product shop :shopping_bags:"));
        for(Product product: products.findAll()){
            System.out.println(product);
        }
    }
}
