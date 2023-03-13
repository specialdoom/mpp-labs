const config = require("./config");
const ProductDBRepository = require("./repository/product.repo.js");
const Product = require("./model/product.js");

const url = config.db.url;

const products = new ProductDBRepository({ url });

// products.add(new Product("2", "test 2", 70.52, 56));

for (let product of products.findAll()) {
    console.log(product.toString());
}

products.update("1", new Product("1", "test 1", 80.52, 52));

for (let product of products.findAll()) {
    console.log(product.toString());
}