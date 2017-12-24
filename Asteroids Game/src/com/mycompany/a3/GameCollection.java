package com.mycompany.a3;

import java.util.Vector;

public class GameCollection implements ICollection {
	private Vector collection;
	
	public GameCollection() {
		collection = new Vector();
	}
	
	public void add(Object newObj) {
		collection.addElement(newObj);
	}
	
	public void remove(Object newObj) {
		collection.removeElement(newObj);
	}

	public IIterator getIterator() {
		return new GameCollectionIterator();
	}
	
	public int getSize() {
		return collection.size();
	}
	
	private class GameCollectionIterator implements IIterator {
		private int currIndex;
		
		public GameCollectionIterator() {
			currIndex = -1;
		}
		
		public boolean hasNext() {
			if (collection.size() <= 0) {
				return false;
			}
//			if (currIndex == (collection.size() - 1)) {
//				return false;
//			}
//			return true;
			return currIndex != collection.size() - 1;
		}
		
		public Object getNext() {
			currIndex++;
			return collection.elementAt(currIndex);
		}
	}
	
	public String toString() {
		String sum = "";
		for (int i = 0; i < collection.size(); i++) {
			sum += collection.elementAt(i) + "\n";
		}
		return sum;
	}

}
