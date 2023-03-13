const DBUtils = require("../utils/db.utils.js");
const Product = require("../model/product.js");

class ProductDBRepository {
  #dbUtils;

  constructor(config) {
    this.#dbUtils = new DBUtils(config);
  }

  add(element) {
    const sql = "INSERT INTO Products(id, description, price, count) VALUES(?,?,?,?)";

    try {
      const preparedStatement = this.#dbUtils.getConnection().prepare(sql);

      preparedStatement.run(element.id, element.description, element.price, element.count);
    } catch (e) {
      console.log("Error while adding product!", e);
    }
  }

  update(id, element) {
    const sql = "UPDATE Products SET description = ? ,"
      + "price = ? , "
      + "count = ? "
      + "WHERE id = ?";

    try {
      const preparedStatement = this.#dbUtils.getConnection().prepare(sql);

      preparedStatement.run(element.description, element.price, element.count, id);
    } catch (e) {
      console.log("Error while updating product!", e);
    }
  }

  findAll() {
    const sql = "SELECT * FROM Products";

    let products = [];

    try {
      const preparedStatement = this.#dbUtils.getConnection().prepare(sql);

      products = preparedStatement.all().map(x => new Product(x.id, x.description, x.price, x.count));
    } catch (e) {
      console.log("Error while getting products!", e);
    }

    return products;
  }
}

module.exports = ProductDBRepository;