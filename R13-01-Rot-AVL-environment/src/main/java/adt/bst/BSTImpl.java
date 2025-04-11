package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BSTNode<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = 1 + Math.max(height(((BSTNode<T>) node.getLeft())), height(((BSTNode<T>) node.getRight())));
		}
		return result;
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, root);
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> auxNode = new BSTNode<>();
		
		if (!node.isEmpty() && element != null) {
			if (node.getData().compareTo(element) == 0) {
				auxNode = node;
			}

			if (node.getData().compareTo(element) > 0) {
				auxNode = search(element, ((BSTNode<T>) node.getLeft()));
			}

			if (node.getData().compareTo(element) < 0) {
				auxNode = search(element, ((BSTNode<T>) node.getRight()));
			}
		}
		return auxNode;
	}

	@Override
	public void insert(T element) {
		BSTNode<T> auxNode = this.root;
		insert(element, auxNode);
	}

	private void insert(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (node.getData().compareTo(element) > 0) {
				insert(element,((BSTNode<T>) node.getLeft()));
			} else {
				insert(element, ((BSTNode<T>) node.getRight()));
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {

		BSTNode<T> auxNode = node;
		BSTNode<T> result = null;

		while(!auxNode.isEmpty() && !auxNode.getRight().isEmpty()) {
			auxNode = ((BSTNode<T>) auxNode.getRight());
		}
		
		if (!auxNode.isEmpty()) {
			result = auxNode;
		}
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimun(this.root);
	}

	private BSTNode<T> minimun(BSTNode<T> node) {
		BSTNode<T> auxNode = node;
		BSTNode<T> result = null;

		while(!auxNode.isEmpty() && !auxNode.getLeft().isEmpty()) {
			auxNode = ((BSTNode<T>) auxNode.getLeft());
		}
		
		if (!auxNode.isEmpty()) {
			result = auxNode;
		}
		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;

		BSTNode<T> auxNode = search(element);

		if (!auxNode.isEmpty()) { 
			if (!auxNode.getRight().isEmpty()) {
				result = minimun(((BSTNode<T>) auxNode.getRight()));

			} else {
				BSTNode<T> node = ((BSTNode<T>) auxNode.getParent());
				while (node != null && node.getRight().equals(auxNode)) {
					auxNode = node;
					node = ((BSTNode<T>) node.getParent());
				}
				result = node;	
			}
		}
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;

		BSTNode<T> auxNode = search(element);

		if (!auxNode.isEmpty()) {
			if (!auxNode.getLeft().isEmpty()) {
				result = maximum(((BSTNode<T>) auxNode.getLeft()));
			} else {
				BSTNode<T> node = ((BSTNode<T>) auxNode.getParent());
				while (node != null && node.getLeft().equals(auxNode)) {
					auxNode = node;
					node = ((BSTNode<T>) node.getParent());
				}
				result = node;
			}
		}
		return result;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> auxNode = search(element);
		remove(auxNode);
	}

	private void remove(BSTNode<T> auxNode) {
		if (auxNode != null && !auxNode.isEmpty()) {

			if (auxNode.isLeaf()) {
				auxNode.setData(null);
			
			} else 
				if (auxNode.getLeft().isEmpty() && !auxNode.getRight().isEmpty()
				|| !auxNode.getLeft().isEmpty() && auxNode.getRight().isEmpty()) {

					if (auxNode.getParent() != null && !auxNode.getParent().isEmpty()) {
							if (auxNode.getParent().getData().compareTo(auxNode.getData()) > 0) {
								if (!auxNode.getLeft().isEmpty()) {
									auxNode.getParent().setLeft(auxNode.getLeft());
									auxNode.getLeft().setParent(auxNode.getParent());
								} else {
									auxNode.getParent().setLeft(auxNode.getRight());
									auxNode.getRight().setParent(auxNode.getParent());
								}
							} else {
								if (!auxNode.getLeft().isEmpty()) {
									auxNode.getParent().setRight(auxNode.getLeft());
									auxNode.getLeft().setParent(auxNode.getParent());
								} else {
									auxNode.getParent().setRight(auxNode.getRight());
									auxNode.getRight().setParent(auxNode.getParent());
								}
							}
					} else {
						if (auxNode.getLeft().isEmpty()) {
							this.root = (BSTNode<T>) auxNode.getRight();
							this.getRoot().setParent(null);
						} else {
							this.root = (BSTNode<T>) auxNode.getLeft();
							this.getRoot().setParent(null);
						}
					}
				} else {
					BSTNode<T> sucessor = this.sucessor(auxNode.getData());
					auxNode.setData(sucessor.getData());
					remove(sucessor);
			}
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> result = new ArrayList<>();

		preOrder(result, this.root);

		return (T[]) result.toArray(new Comparable[size()]);
	}

	private void preOrder(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			array.add(node.getData());
			preOrder(array, (BSTNode<T> )node.getLeft());
			preOrder(array, (BSTNode<T> )node.getRight());
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> result = new ArrayList<>();

		order(result, this.root);

		return (T[]) result.toArray(new Comparable[size()]);
	}

	private void order(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			order(array, (BSTNode<T> )node.getLeft());
			array.add(node.getData());
			order(array, (BSTNode<T> )node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> result = new ArrayList<>();

		postOrder(result, this.root);

		return (T[]) result.toArray(new Comparable[size()]);
	}

	private void postOrder(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			postOrder(array, (BSTNode<T> )node.getLeft());
			postOrder(array, (BSTNode<T> )node.getRight());
			array.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
