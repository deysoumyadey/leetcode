package DS2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomHashMap {
	List<List<Integer>> hashMap;

	public CustomHashMap() {
		hashMap = new ArrayList<>();
	}

	public void put(int key, int value) {
		if (hashMap.isEmpty())
			hashMap.add(Arrays.asList(key, value));
		else {
			int unique = 0, index = 0;
			for (List<Integer> entry : hashMap) {
				if (entry.get(0) == key) {
					hashMap.get(index).set(1, value);
					unique++;
					break;
				}
				index++;
			}
			if (unique == 0) {
				hashMap.add(Arrays.asList(key, value));
			}
		}
	}

	public int get(int key) {
		for (List<Integer> entry : hashMap) {
			if (entry.get(0) == key) {
				return entry.get(1);
			}
		}
		return -1;
	}

	public void remove(int key) {
		int index = 0;
		for (List<Integer> entry : hashMap) {
			if (entry.get(0) == key) {
				hashMap.remove(index);
				break;
			}
			index++;
		}
		/*
		 * for (Iterator<List<Integer>> iterator = hashMap.iterator();
		 * iterator.hasNext(); ) { List<Integer> value = iterator.next(); if
		 * (value.get(1) == key) { iterator.remove(); } }
		 */
	}

	public static void main(String[] args) {
		CustomMap1 map = new CustomMap1();
		map.put(1000000, 1);
		System.out.println(map.get(1000000));
		map.put(0, 2);
		map.put(1, 1);
		map.put(2, 2);
		System.out.println(map.get(0));
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		map.put(2, 1);
		System.out.println(map.get(2));
		map.remove(2);
		System.out.println(map.get(2));
	}
}

class CustomMap1 {
	int[] map;

	CustomMap1() {
		map = new int[1000001];
		Arrays.fill(map, -1);
	}

	public void put(int key, int value) {
		map[key] = value;
	}

	public int get(int key) {
		return map[key];
	}

	public void remove(int key) {
		map[key] = -1;
	}
}
