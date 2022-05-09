/**
 * Creates a House object with parameters Mls, Bedrooms, Price, and Seller
 * @author    David Pavlicek
 */
public class House {
    private int mls; //integer ranges between 10001 and 99999  (MLS is a unique listing number for a home when on sale)
    private int bedrooms; //integer ranging from 0 to 5
    private double price; //double ranging from 0 to 1,000,000
    private String seller; //must be at least 2 non-blank characters long

    public House(int mls, int bedrooms, double price,String seller) throws Exception {
        this.setMls(mls);

        this.setBedrooms(bedrooms);

        this.setPrice(price);

        this.setSeller(seller);
    }

    public int getMls() {
        return mls;
    }

    public void setMls(int mls) throws Exception{
        if(mls > 10001 && mls < 99999){
            this.mls = mls;
        }
        else{
            HouseException me = new HouseException();
            me.setMessage("Mls must be between 10001-99999");
            throw(me);
        }
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) throws Exception{
        if(bedrooms >= 0 && bedrooms <= 5){
            this.bedrooms = bedrooms;
        }
        else{
            HouseException me = new HouseException();
            me.setMessage("Bedrooms out of range 0-5");
            throw(me);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception{
        if(price >= 0 && price <= 1000000){
            this.price = price;
        }
        else{
            HouseException me = new HouseException();
            me.setMessage("Price out of range 0-1,000,000");
            throw(me);
        }
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) throws Exception{
        if(seller.trim().length() > 2){
            this.seller = seller;
        }
        else{
            HouseException me = new HouseException();
            me.setMessage("Seller name must be longer than two characters");
            throw(me);
        }
    }

    public String toString() {
        return "Mls: " + getMls() + "\nBedrooms: " + getBedrooms() + "\nPrice: $" + String.format("%.2f", getPrice()) + "\nSeller: " + getSeller();
    }
}



