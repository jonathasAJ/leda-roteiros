package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		
		boolean result = true;

		if (getBSt() == null || getBSt().isEmpty()) {
			result = isBST(getBSt().getRoot());
		}

		return result;
	}
	
	private boolean isBST(BSTNode<T> node) {


		boolean result = true;
		
		if (node != null && !node.isEmpty()) {

			if (node.getLeft().getData().compareTo(node.getData()) > 0 || node.getRight().getData().compareTo(node.getData()) < 0) {
				result = false;
			}
		}

		return result;
	}
}
