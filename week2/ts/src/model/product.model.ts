import type { Identifiable } from "./identifiable.model";

export class Product implements Identifiable<string> {
    private _barCode: string;
    private _description: string;
    private _price: number;
    private _count: number;

    constructor(barCode: string = "", description: string = "", price: number = 0.00, count: number = 0) {
        this._barCode = barCode;
        this._description = description;
        this._price = price;
        this._count = count;
    }

    get description() {
        return this._description;
    }

    set description(description: string) {
        this._description = description;
    }

    get price() {
        return this._price;
    }

    set price(price: number) {
        this._price = price;
    }

    get count() {
        return this._count;
    }

    set count(count: number) {
        this._count = count;
    }

    getId() {
        return this._barCode;
    }

    setId(id: string) {
        this._barCode = id;
    }

    toString() {
        return `|${this._barCode}| ${this._description}; ${this._price}$; ${this._count} pieces;`
    }
}
