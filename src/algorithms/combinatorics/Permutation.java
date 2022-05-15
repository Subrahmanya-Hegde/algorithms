package algorithms.combinatorics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algorithms.combinatorics.algos.PermutationAlgorithm;

public class Permutation<T> {

	/**
	 * Generates permutations of all the elements of list using,
	 * <ol>
	 * <li>{@link #getPermutationsByHeapsMethod(list, list, int) HEAP_S} method.</li>
	 * </ol>
	 * 
	 * @param array
	 * @param algorithmType
	 * @return permutation of all the elements of the array
	 */
	public List<List<T>> getPermutations(List<T> list, PermutationAlgorithm algorithmType) {
		List<List<T>> permutations = new ArrayList<>();
		switch (algorithmType) {
		case HEAP_S:
			getPermutationsByHeapsMethod(permutations, list, list.size());
			break;
		default:
			System.out.println("No such Algorithm!");
			break;
		}
		return permutations;
	}

	/**
	 * Generates all the permutations that end with the last element. Then the
	 * (n-1)! permutations of the first n-1 elements are adjoined to this last
	 * element. While looping over the n-1 elements,
	 * <ol>
	 * <li>If n is odd, then swap the first and last element.</li>
	 * <li>If n is even, then swap the i-th element (in the loop).</li>
	 * </ol>
	 * 
	 * @see {@link https://en.wikipedia.org/wiki/Heap%27s_algorithm#cite_note-3}
	 * @param permutations
	 * @param permutation
	 * @param size
	 */
	private static final <T> void getPermutationsByHeapsMethod(List<List<T>> permutations, List<T> permutation,
			int size) {
		if (size == 1) {
			permutations.add(new ArrayList<>(permutation));
		}
		for (int i = 0; i < size; i++) {
			getPermutationsByHeapsMethod(permutations, permutation, size - 1);
			if (size % 2 == 1) {
				Collections.swap(permutation, 0, size - 1);
			} else {
				Collections.swap(permutation, i, size - 1);
			}
		}
	}

}
