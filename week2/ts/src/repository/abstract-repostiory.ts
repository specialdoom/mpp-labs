import { Identifiable } from "../model/identifiable.model";
import { Repository } from "./repository";

export class AbstractRepository<T extends Identifiable<String>, String> implements Repository<T, String> {
    elements: Map<String, T>;

    constructor(){
        this.elements = new Map<String, T>();
    }

    add(item: T) {
        if (this.elements.has(item.getId())) {
            throw new Error("Element already exists!");
        }

        this.elements.set(item.getId(), item);
    }

    delete(item: T) {
        this.elements.delete(item.getId())
    }

    update(item: T) {
        if (!this.elements.has(item.getId())) {
            throw new Error("Element does not exist!");
        }

        this.elements.set(item.getId(), item);
    }

    findById(id: String): T {
        if (!this.elements.has(id)) {
            throw new Error("Element does not exist!");
        }

        return this.elements.get(id) as T;
    }

    findAll() {
        return this.elements.values();
    }

    getAll() {
       return Array.from(this.elements.values());
    }
}