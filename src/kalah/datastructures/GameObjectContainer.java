package kalah.datastructures;

/**
 * Defines the interface for any data structure used to store game objects
 * 
 * @author Abby S
 *
 * @param <T>
 */
public interface GameObjectContainer<T>{
	
	public boolean add(T gameObject);
	
	public T get(int index);
}
