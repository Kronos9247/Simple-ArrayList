package com.kronos9247.list.test;

import java.util.Iterator;

import com.kronos9247.list.ArrayList;

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
public class Test {
	
	public static void main(String[] args) {
		ArrayList<Integer> 	list = new ArrayList<Integer>();
//							list = new ArrayList<Integer>(10);
							list = new ArrayList<Integer>(1,4,564,645);
							
		ArrayList<Integer> list2 = new ArrayList<Integer>(6,8,3,2,4);
		
		print(list);
		
		Iterator<Integer> iterator = list.iterator();
		for(int i = 0; i < 4; i++) iterator.next();
		
		list.add(10);
		print(list);
		
		for(int i = 0; i < 10; i++) {
			list.add((int)(Math.random() * 100.0));
		}
		print(list);
		
		list.forEach((element) -> {
			System.out.print(element + " ");
		});
		System.out.println();
		
		System.out.println();
		list.addAll(list2);
		print(list);
		
		System.out.println();
		list.add(list.size() - 1, 10000);
		print(list);
		
		ArrayList<Integer> list3 = new ArrayList<Integer>(-999, -999, -999, -999);
		System.out.println();
		list.addAll(3, list3);
		print(list);
		
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		System.out.println();
		list.addAll(3, list4);
		print(list);
		
		list.remove(list.size() - 1);
		print(list);
		
		list.remove(list.size() - 5);
		print(list);
		
		list.remove(0);
		print(list);
		
		list.remove(5);
		print(list);
		
//		list.addAll(-3, list4);
	}
	
	public static <T> void print(ArrayList<T> list) {
		for(T element : list) System.out.print(element + " ");
		System.out.println();
	}

}
