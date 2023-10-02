package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface CRUDOperation<E> {

	public void create(String... args);

	public void create(Object o);

	public String readOnly();

	public ArrayList<E> read();

	public int update(int index, String... args);

	public int delete(int index);

	public int delete(Object o);
	
	public String readAll();

	public String readByName(String name);
	
	public int updateById(int id, String... args);

	public int deleteById(int id);

}
