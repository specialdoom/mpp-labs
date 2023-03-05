import { Product } from "../model/product.model";
import { AbstractRepository } from "./abstract-repostiory";

export class ProductRepository extends AbstractRepository<Product, string> {
    constructor() {
        super();
    }
}