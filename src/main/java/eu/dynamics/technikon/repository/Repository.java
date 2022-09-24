package eu.dynamics.technikon.repository;

import java.util.List;

public interface Repository<T> {

	boolean add(T t);
	List<T> read();
	
	

}
