package repository;

import model.Identifiable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AbstractRepository <T extends Identifiable<String>, String> implements Repository<T, String> {
    protected Map<String, T> elements;

    public AbstractRepository(){
        elements = new HashMap<>();

    }
    public void add(T el){
        if(elements.containsKey(el.getId()))
        {
            throw new RuntimeException("Element already exists!");
        }
        else
            elements.put(el.getId(),el);
    }

    public void delete(T el){
        elements.remove(el.getId());
    }

    @Override
    public void update(T elem, String barCode) {
        if(elements.containsKey(barCode))
            elements.put(elem.getId(),elem);
        else
            throw new RuntimeException("Element does not exist");
    }

    @Override
    public T findByBarCode(String barCode) {
        if(elements.containsKey(barCode))
            return elements.get(barCode);
        else
            throw new RuntimeException("Element does not exist");
    }

    public Iterable<T> findAll() {
        return elements.values();
    }

    @Override
    public Collection<T> getAll() {
        return elements.values();
    }
}
