package se.plweb.rest_demo;

import java.util.List;


public interface Repository<T> {

    public void add(T t);

    public List<T> getAll();

    public T get(int i);

}
