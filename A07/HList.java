//import java.util.LinkedList;

/**
 * 
 * @author David Pavlicek
 */
public class HList {
    // LinkedList<HNode> ll = new LinkedList<HNode>();
    private static int count;
    private HNode first = null;
    private HNode last = null;

    public HList() {
        count = 0;
    }

    public void add(House h) {
        HNode n = new HNode();
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
        return false;

    }

    public void prinAllHouses() {
        if (count < 1) {
            System.out.println("The list is empty");
            return;
        } else {
            HNode cursor = first;
            while (cursor != null) {
                System.out.println(cursor.toString());
                cursor = cursor.getNext();
            }
        }
    }

    public void printHousesLessThan(double price) {
        if (count < 1) {
            System.out.println("The list is empty");
            return;
        } else {
            HNode cursor = first;
            while (cursor != null) {
                if (cursor.getHouse().getPrice() < price) {
                    System.out.println(cursor.toString());
                }
                cursor = cursor.getNext();
            }
        }
    }
}