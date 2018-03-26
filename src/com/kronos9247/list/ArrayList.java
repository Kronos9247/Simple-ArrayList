package com.kronos9247.list;

/*
 *  A simple example implementation of a ArrayList
 *  
 *  Copyright (C) 2017  Rafael Orman
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
public class ArrayList<T> implements List<T> {
	
	private Object[] content;
	
	public ArrayList(int initialCapacity) {
		content = new Object[initialCapacity];
	}
	
	public ArrayList() {
		this(0);
	}
	
	@SafeVarargs
	public ArrayList(T...elements) {
		content = elements;
	}
	
	protected Object[] newInternalArray(int length) {
		if(length > 0 && length > size()) {
			Object[] dest = new Object[length];
			System.arraycopy(content, 0, dest, 0, size());
			
			return dest;
		}
		else throw new IndexOutOfBoundsException();
	}
	
	protected Object[] newInternalArray(int position, int size) {
		final int length = size() + size;
		if((length > 0 && position <= size() && position >= 0)) {
			Object[] dest = new Object[length];
			System.arraycopy(content, 0, dest, 0, position);
			System.arraycopy(content, position, dest, position + size, size() - position);
			
			return dest;
		}
		else throw new IndexOutOfBoundsException();
	}

	@Override
	public int size() {
		return content.length;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T) content[index];
	}

	@Override
	public T set(int index, T element) {
		if(index >= 0 && index < size()) {
			@SuppressWarnings("unchecked")
			final T preValue = (T) content[index];
			
			content[index] = element;
			
			return preValue;
		}
		else throw new IndexOutOfBoundsException();
	}
	
	@Override
	public void remove(int index) {
		Object[] dest = null;
		
		if(index >= 0) {
			if(index < size() - 1) dest = newInternalArray(index + 1, -1);
			else {
				dest = new Object[size() - 1];
				
				System.arraycopy(content, 0, dest, 0, size() - 1);
			}
		}
		else throw new IndexOutOfBoundsException();
		
		content = dest;
	}

	@Override
	public void add(T element) {
		Object[] dest = newInternalArray(size() + 1);
		dest[size()] = element;
		
		content = dest;
	}

	@Override
	public void add(int index, T element) {
		Object[] dest = newInternalArray(index, 1);
		dest[index] = element;
		
		content = dest;
	}

	@Override
	public void addAll(List<T> list) {
		if(list.size() >= 0) {
			Object[] dest = newInternalArray(size() + list.size());
			
			for(int i = 0; i < list.size(); i++)
				dest[size() + i] = list.get(i);
			
			content = dest;
		}
		else throw new IndexOutOfBoundsException();
	}

	@Override
	public void addAll(int index, List<T> list) {
		if(list.size() >= 0) {
			Object[] dest = newInternalArray(index, list.size());
			
			for(int i = 0; i < list.size(); i++)
				dest[index + i] = list.get(i);
			
			content = dest;
		}
		else throw new IndexOutOfBoundsException();
	}

}
