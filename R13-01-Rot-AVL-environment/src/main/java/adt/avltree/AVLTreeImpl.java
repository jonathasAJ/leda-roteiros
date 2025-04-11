package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	@Override
	public void insert(T element) {
		insert(element, getRoot());
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
			rebalance(node);
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> auxNode = search(element);
		if (auxNode != null) {
			remove(auxNode);
		}
	}

	private void remove(BSTNode<T> auxNode) {
		if (!auxNode.isEmpty()) {

			if (auxNode.isLeaf()) {
				auxNode.setData(null);
				rebalanceUp(auxNode);
			
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
					rebalanceUp(auxNode);
				} else {
					BSTNode<T> sucessor = this.sucessor(auxNode.getData());
					auxNode.setData(sucessor.getData());
					remove(sucessor);
			}
		}
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
	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		return height(((BSTNode<T>) node.getLeft())) - height(((BSTNode<T>) node.getRight()));
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {

		if (node != null) {
			int balance = calculateBalance(node);
			BSTNode<T> newRoot = null;

			if (balance > 1)  {
				if (this.calculateBalance(((BSTNode<T>) node.getLeft())) >= 0) {
					
				} else {
					Util.leftRotation(((BSTNode<T>) node.getLeft()));
				}
				newRoot = Util.rightRotation(node);

			} else {
				if (balance < -1) {
					if (this.calculateBalance(((BSTNode<T>) node.getRight())) <= 0) {

					} else {
						Util.rightRotation(((BSTNode<T>) node.getRight()));
						
					}
					newRoot = Util.leftRotation(node);
				}
			}
			if (this.getRoot().equals(node) && newRoot != null) {
				this.root = newRoot;
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node !=  null) {
			BSTNode<T> parent = ((BSTNode<T>) node.getParent());
			while (parent != null) {
				rebalance(parent);
				parent  =  ((BSTNode<T>) parent.getParent());
			}
		}
	}	
}
