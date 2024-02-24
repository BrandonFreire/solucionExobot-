package DataAccess;

import java.util.List;

public interface IDAO <T>{
    public T readBy(Integer id)throws Exception ;  //leer solo uno
    public List<T> readAll() throws Exception ; //leer todo
    public boolean create(T entity) throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(Integer id)throws Exception;
}
