export interface Identifiable<Tid> {
    getId: () => Tid;
    setId: (id: Tid) => void;
}