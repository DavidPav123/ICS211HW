/**
 * Implmientation of the Binary Search Tree Node interface
 * functions for creating a node, getting the cd of the node,
 * setting and getting the child nodes of the node
 * 
 * @author David Pavlicek
 */
public class BSTNode implements BSTNodeI {
    CD node;
    BSTNode leftNode;
    BSTNode rightNode;

    BSTNode(CD cd) {
        node = cd;
    }

    public void setLeftChild(BSTNode newNode) {
        leftNode = newNode;
    }

    public void setRightChild(BSTNode newNode) {
        rightNode = newNode;
    }

    public BSTNode getLeftChild() {
        return leftNode;
    }

    public BSTNode getRightChild() {
        return rightNode;
    }

    public CD getCD() {
        return node;
    }

    public String toString() {
        return node.toString() + "\n";
    }
}
