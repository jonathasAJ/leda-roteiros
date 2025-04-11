package adt.bst.questoes;

import adt.bt.BTNode;

public class SymetricBT extends BTNode<Integer> {

    protected BTNode<Integer> root;


	public SymetricBT() {
		root = new BTNode<Integer>();
	}

    public boolean isSymetric() {
        
        boolean result = true;

        if (!getRoot().isEmpty()) {
            result = isSymetric(root.getLeft(), root.getRight());
        }

        return result;
    }

    private boolean isSymetric(BTNode<Integer> nodeLeft, BTNode<Integer> nodeRight) {

        boolean result = true;
        
        if (nodeLeft != null && nodeRight != null) {

        } else {
            if (nodeLeft.getData().compareTo(nodeRight.getData()) == 0) {
                boolean r1 = isSymetric(nodeLeft.getLeft(), nodeRight.getRight());
                boolean r2 = isSymetric(nodeLeft.getRight(), nodeRight.getLeft());
                result =  r1 && r2;
            }
        }

        return result;
    }


	public BTNode<Integer> getRoot() {
		return root;
	}
}
