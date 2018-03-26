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
public interface Collection<T> extends Cloneable {
	
	public int size();
	
	public T get(int index);
	
	public T set(int index, T element);
	
	public void remove(int index);
	
	public void add(T element);
	
	public void add(int index, T element);
	
	public boolean isEmpty();

}
