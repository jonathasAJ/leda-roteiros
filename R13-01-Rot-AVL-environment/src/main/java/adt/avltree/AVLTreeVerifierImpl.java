package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		return this.isBST() && (this.getAVLTree().isEmpty() || this.isAVLTree(this.avlTree.getRoot()));
	}

	private boolean isAVLTree(BSTNode<T> node) {
		boolean result = true;
		if (node != null && !node.isEmpty()) {
			if (Math.abs(this.getAVLTree().calculateBalance(node)) <= 1) {
				result = this.isAVLTree((BSTNode<T>) node.getLeft()) && this.isAVLTree((BSTNode<T>) node.getRight());
			} else {
				result = false;
			}
		}
		return result;
	}
}
