package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean result = false;
		if (tree1 != null && tree2 != null) {
			result = equals(((BSTNode<T>) tree1.getRoot()), ((BSTNode<T>) tree2.getRoot()));
		}
		return result;
	}

	private boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = false;

		if (node1.isEmpty() && node2.isEmpty()) {
			result = true;
		} else {
			if (node1.getData().compareTo(node2.getData()) == 0) {
				boolean resultL = equals(((BSTNode<T>) node1.getLeft()), ((BSTNode<T>) node2.getLeft()));
				boolean resultR = equals(((BSTNode<T>) node1.getRight()), ((BSTNode<T>) node2.getRight()));
				result = resultL && resultR;
			}
		}
		return result;
	}
	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean result = true;
		if (tree1 != null && tree2 != null) {
			result = isSimilar(((BSTNode<T>) tree1.getRoot()), ((BSTNode<T>) tree2.getRoot()));
		}
		return result;
	}

	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = true;

		if (!node1.isEmpty() && node2.isEmpty() || node1.isEmpty() && !node2.isEmpty()) {
			result = false;
		} else {
			if (!node1.isEmpty() && !node2.isEmpty()) {
				boolean resultL = isSimilar(((BSTNode<T>) node1.getLeft()), ((BSTNode<T>) node2.getLeft()));
				boolean resultR = isSimilar(((BSTNode<T>) node1.getRight()), ((BSTNode<T>) node2.getRight()));
				result = resultL && resultR;
			} 
		}
		return result;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T result = null;
		if (tree != null && k > 0 && k <= tree.size()) {
			result = orderStatistic(tree.minimum(), k, 1, tree);
		}
		return result;
	}

	private T orderStatistic(BSTNode<T> node, int k, int index, BST<T> tree)  {
		T result = null;
		if (k == index) {
			result = node.getData();
		} else {
			result = orderStatistic(tree.sucessor(node.getData()), k, ++index, tree);
		}
		return result;
	}

}
