/**
 * Used to create a linked list of HNode objects
 * implimnets functions to changes the list such as 
 * add, get, remove, legth
 * @author David Pavlicek
 */
public class HList {
    private static int count;
    private HNode first = null;
    private HNode last = null;

    public HList() {
        count = 0;
    }

    public void add(House h) {
        HNode n = new HNode();
        n.setHouse(h);
        if (count == 0) {
            first = n;
            last = n;
        } else {
            last.setNext(n);
            last = n;
        }
        count++;
    }

    public boolean remove(int MLS) {
        HNode lagger = first;
        HNode currentNode = first;
        if (first != null) { //If the list is empty the node can't be removed so no point in checking
            if (count == 1) { //Special handling for list of size 1
                first = null;
                last = null;
                count--;
                return true;
            } else {
                for (int i = 1; i <= count; i++) {
                    if (currentNode.getHouse().getMls() == MLS) {
                        if (i == 1) {//Special handling for first node
                            first = currentNode.getNext();
                            count--;
                            return true;
                        } else {
                            lagger.setNext(currentNode.getNext());
                            count--;
                            return true;
                        }
                    }
                    lagger = currentNode;
                    currentNode = currentNode.getNext();
                }
            }
        }
        return false;
    }

    public void prinAllHouses() {
        int i = 1;
        if (count < 1) {
            System.out.println("The list is empty");
            return;
        } else {
            HNode cursor = first;
            while (cursor != null) {
                System.out.println("\n\nHouse " + (i) + ":");
                System.out.println(cursor.toString());
                cursor = cursor.getNext();
                i++;
            }
        }
    }

    public void printHousesLessThan(double price) {
        if (count < 1) {
            System.out.println("The list is empty");
            return;
        } else {
            for (int i = 0; i < count; i++) {
                if (this.get(i).getHouse().getPrice() < price) {
                    System.out.println("\n\nHouse " + (i + 1) + ":");
                    System.out.print(this.get(i).getHouse().toString());
                }
            }
        }
    }

    // Added to get the length of the list
    public int length() {
        return count;
    }

    // Easy method for getting a linked list node
    public HNode get(int index) {
        HNode currentNode = first;
        // If index is bigger / smaller than Linked List size throw IndexOutOfBounds
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        // Index Less than size and is not the first or last node.
        if (index < count && index > 0) {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }

        // If the Linked List is empty + Index = 0 return null
        if (first == null && index == 0) {
            return null;
        }

        // If Linked List is not empty and index = 0 return first value
        if (index == 0) {
            return currentNode;
        }
        // Return null if not found.
        return null;
    }
}