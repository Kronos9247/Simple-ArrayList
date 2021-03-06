package com.kronos9247.list;

import java.util.Iterator;
import java.util.function.Consumer;

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
public interface List<T> extends Collection<T>, Iterable<T> {
	
	public void addAll(List<T> list);
	
	public void addAll(int index, List<T> list);
	
	public default Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}
	
	public default void forEach(Consumer<? super T> consumer) {
		for(T element : this) consumer.accept(element);
	}
	
	public default boolean isEmpty() {
		return size() == 0;
	}
	
}
