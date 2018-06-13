package kalah.datastructures;

import java.util.ArrayList;

/**
 * A game object container with cyclic selection
 * @author Abby S
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class CircularList<T> extends ArrayList<T> implements GameObjectContainer<T> {

	public T get(int index){
		return super.get(index % size());
	}
}
