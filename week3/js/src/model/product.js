class Product {
    #id;
    #description;
    #price;
    #count;

    constructor(id = "", description = "", price = 0.00, count = 0){        this.#id = id;
        this.#description = description;
        this.#price = price;
        this.#count = count;
    }

    get id() {
        return this.#id;
    }

    set id(id) {
        this.#id = id;
    }

    get description() {
        return this.#description;
    }

    set description(description) {
        this.#description = description;
    }

    get price() {
        return this.#price;
    }

    set price(price) {
        this.#price = price;
    }

    get count() {
        return this.#count;
    }

    set count(count) {
        this.#count = count;
    }

    toString() {
        return `|${this.#id}| ${this.#description}; ${this.#price}$; ${this.#count} pieces;`
    }
}

module.exports = Product;