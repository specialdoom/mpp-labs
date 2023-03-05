import { Product } from "./model/product.model";
import { ProductRepository } from "./repository/product-repository";

const products = new ProductRepository();

products.add(new Product("6420387582007", "Notebook", 1.25, 10));
products.add(new Product("5942328200135", "Vitamin Aqua", 1.0, 10));

for (let product of products.findAll()) {
  console.log(product.toString());
}
