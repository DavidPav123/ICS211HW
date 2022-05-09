/**
 * Creating HNode objects that go into a HNode List
 * HNode objects contain house objects and impliment functionality
 * to make the HNode Linked list work such as having a pointer
 * to the next node in the list
 * @author David Pavlicek
 */
public class HNode {
    private House house;
    private HNode nextHouse = null;

    public HNode() {

    }

    public void setNext(HNode n) {
        this.nextHouse = n;
    }

    public HNode getNext() {
        return this.nextHouse;
    }

    public void setHouse(House h) {
        this.house = h;
    }

    public House getHouse() {
        return this.house;
    }

    public String toString() {
        return house.toString();
    }
}