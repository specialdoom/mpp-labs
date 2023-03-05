package repository;
import java.util.Collection;

public interface Repository<T, BarCode> {
    void add(T elem);
    void delete(T elem);
    void update (T elem, BarCode id);
    T findByBarCode (BarCode id);
    Iterable<T> findAll();
    Collection<T> getAll();

}
