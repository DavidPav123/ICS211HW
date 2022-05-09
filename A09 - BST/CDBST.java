/**
 * Implmientation of the CD Binary Search Tree interface
 * adds nodes from left to right based on the price of the cd object in each
 * node
 * 
 * @author David Pavlicek
 */
public class CDBST implements CDBSTI {
    private BSTNode root;
    boolean flag = false;

    CDBST() {
        root = null;
    }

    public boolean addNode(CD cd) {
        BSTNode newNode = new BSTNode(cd);
        BSTNode x = this.root;
        BSTNode y = null;

        if (root == null) {
            root = newNode;
            System.out.println("A root has been set");
            return true;
        }

        while (x != null) {
            y = x;
            if (x.getCD().compareTo(newNode.getCD()) == 1) {
                x = x.getLeftChild();
            } else if (x.getCD().compareTo(newNode.getCD()) == -1) {
                x = x.getRightChild();
            } else {
                return false;
            }
        }

        if (y.getCD().compareTo(newNode.getCD()) == 1) {
            y.setLeftChild(newNode);
        } else if (y.getCD().compareTo(newNode.getCD()) == -1) {
            y.setRightChild(newNode);
        }
        return true;
    }

    public boolean findNode(CD cd) {
        flag = false;
        searchNode(root, cd);
        return flag;
    }

    public void printBSTree(BSTNode root) {
        if (root != null) {
            printBSTree(root.getLeftChild());
            System.out.println(root.toString());
            printBSTree(root.getRightChild());
        }
    }

    public void printBSTree() {
        if (root != null) {
            printBSTree(root.getLeftChild());
            System.out.println(root.toString());
            printBSTree(root.getRightChild());
        }
    }

    // This method basically replaces the findNode function as I couldn't figure out
    // a way to make
    // the funciton recursive without having an extra inclusion of being able to say
    // which node to start from
    public boolean searchNode(BSTNode temp, CD cd) {
        // Check whether tree is empty
        if (root == null) {
            return false;
        } else {
            // If value is found in the given binary tree then, set the flag to true
            if (temp.getCD().compareTo(cd) == 0) {
                flag = true;
                return true;
            }
            // Search in left subtree
            if (flag == false && temp.getLeftChild() != null) {
                searchNode(temp.getLeftChild(), cd);
            }
            // Search in right subtree
            if (flag == false && temp.getRightChild() != null) {
                searchNode(temp.getRightChild(), cd);
            }
        }
        return false;
    }
}