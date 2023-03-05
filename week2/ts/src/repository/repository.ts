export interface Repository<T, Tid> {
    add: (item: T) => void;
    delete: (item: T) => void;
    update: (item: T, id: Tid) => void;
    findById: (id: Tid) => T;
    findAll: () => Iterable<T>;
    getAll: () => Array<T>;
}