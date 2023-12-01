package dao;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public void insert(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public T selectedByName(T t);		

}
