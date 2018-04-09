package com.kronos9247.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 *  A simple example implementation of a ArrayList
 *  
 *  Copyright (C) 2018  Rafael Orman
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
public final class ListIterator<T> implements Iterator<T> {
	
	private final List<T> list;
	protected int cursor = -1;
	
	public ListIterator(List<T> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return cursor + 1 < list.size();
	}

	@Override
	public T next() {
		if(hasNext()) {
			cursor++;
			
			return list.get(cursor);
		}
		else throw new NoSuchElementException();
	}
	
	@Override
	public void remove() {
		if(cursor == -1) throw new IllegalStateException();
		else {
			list.remove(cursor);
			
			cursor--;
		}
	}

}
