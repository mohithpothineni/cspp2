import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for item.
 */
class Item {

    /**
     * productname.
     */
    private String productname;

    /**
     * quantity of product.
     */
    private int quantity;

    /**
     * unitprice of product.
     */
    private int unitprice;

    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      quant   The quant
     * @param      uprice  The uprice
     */
    Item(final String name, final int quant, final int uprice) {
        this.productname = name;
        this.quantity = quant;
        this.unitprice = uprice;
    }

    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      quant  The quant
     */
    Item(final String name, final int quant) {
        this.productname = name;
        this.quantity = quant;
    }

    /**
     * Gets the productname.
     *
     * @return     The productname.
     */
    String getProductname() {
        return this.productname;
    }

    /**
     * Gets the quantity.
     *
     * @return     The quantity.
     */
    int getQuantity() {
        return this.quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param      quantinp  The quantinp
     */
    void setQuantity(final int quantinp) {
        this.quantity = quantinp;
    }

    /**
     * Gets the unitprice.
     *
     * @return     The unitprice.
     */
    int getUnitprice() {
        return this.unitprice;
    }

    /**
     * Sets the unitprice.
     *
     * @param      upricee  The upricee
     */
    void setUnitprice(final int upricee) {
        this.unitprice = upricee;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.productname + " " + this.quantity
        + " " + (double) this.unitprice;
    }

    /**
     * similar to tostring.
     *
     * @return     representation of object.
     */
    String represent() {
        return this.productname + " " + this.quantity;
    }



}

/**
 * Class for shopping cart.
 */
class ShoppingCart {

    /**
     * catalog array.
     */
    private ArrayList<Item> catalog = new ArrayList<Item>();

    /**
     * cart array.
     */
    private ArrayList<Item> cart = new ArrayList<Item>();

    /**
     * to check doublecoupon usage.
     */
    private boolean flag = true;

    /**
     * to keep track of discount amount.
     */
    private double discount = 0;

    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    void addToCatalog(final Item item) {
        catalog.add(item);
    }

    /**
     * Adds to cart.
     *
     * @param      item  The item
     */
    void addToCart(final Item item) {
        for (Item i : catalog) {
            if (i.getProductname().equals(item.getProductname())) {
                item.setUnitprice(i.getUnitprice());
                Item tmp = null;
                for (Item j : cart) {
                    if (j.getProductname().equals(item.getProductname())) {
                        j.setQuantity(j.getQuantity() + item.getQuantity());
                        tmp = j;
                        break;
                    }
                }
                if (tmp == null) {
                    cart.add(item);
                }
                break;
            }
        }

    }

    /**
     * Removes a from cart.
     *
     * @param      item  The item
     */
    void removeFromCart(final Item item) {
        for (Item i : cart) {
            if (i.getProductname().equals(item.getProductname())) {
                i.setQuantity(i.getQuantity() - item.getQuantity());
                if (i.getQuantity() == 0) {
                    cart.remove(i);
                }
                break;
            }
        }
    }

    /**
     * Shows the cart.
     */
    void showCart() {
        for (Item item : cart) {
            System.out.println(item.represent());
        }
    }

    /**
     * Shows the catalog.
     */
    void showCatalog() {
        for (Item item : catalog) {
            System.out.println(item);
        }
    }

    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    double getTotalAmount() {

        double amnt = 0;

        for (Item item : cart) {
            amnt += (item.getQuantity() * item.getUnitprice());
        }

        return amnt;
    }

    /**
     * applies discount.
     *
     * @param      discountt  The discountt
     */
    void applyCoupon(final int discountt) {
        //System.out.println("discounttt " +discountt);
        final int ten = 10;
        final int twenty = 20;
        final int thirty = 30;
        final int fifty = 50;

        if (discountt != ten && discountt != twenty
                && discountt != thirty && discountt != fifty) {
            System.out.println("Invalid coupon");
            return;
        }
        if (this.flag) {
            double amount = this.getTotalAmount();
            final double denom = 100;
            this.discount = (amount * discountt) / denom;
            //System.out.println(this.discount);
            this.flag = false;
        }

    }

    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    double getPayableAmount() {
        //tax.
        final double taxx = 1.15;
        return (getTotalAmount() - this.discount) * taxx;
    }

    /**
     * prints bill.
     */
    void printInvoice() {
        System.out.println("Name   quantity   Price");

        for (Item item : cart) {
            System.out.println(item);
        }

        double tmp = this.getTotalAmount();


        System.out.println("Total:" + tmp);

        System.out.println("Disc%:" + this.discount);

        double tmp2 = tmp - this.discount;

        final double taxx = 0.15;

        System.out.println("Tax:" + (tmp2 * taxx));

        System.out.printf("Payable amount: %.1f\n", this.getPayableAmount());

    }

}






/**
 * Solution class.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        //copy from prev works
        //chng the function calls

        ShoppingCart scart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().replace(" ", ",").split(",");
            //System.out.println(Arrays.toString(tokens));
            switch (tokens[0]) {
            case "Item":
                final int three = 3;
                scart.addToCatalog(new Item(tokens[1],
                                            Integer.parseInt(tokens[2]),
                                            Integer.parseInt(tokens[three])));
                break;
            case "catalog":
                scart.showCatalog();
                break;
            case "show":
                scart.showCart();
                break;
            case "add":
                scart.addToCart(new Item(tokens[1],
                                         Integer.parseInt(tokens[2])));
                break;
            case "remove":
                scart.removeFromCart(new Item(tokens[1],
                                              Integer.parseInt(tokens[2])));
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + scart.getTotalAmount());
                break;
            case "payableAmount":
                //String movienaam, String timings, String mobilenum
                //System.out.println(Arrays.toString(tokens));
                System.out.printf("Payable amount: %.1f\n",
                                  scart.getPayableAmount());
                break;
            case "print":
                scart.printInvoice();
                break;
            case "coupon":
                scart.applyCoupon(Integer.parseInt(
                                      tokens[1].replace("IND", "")));
            //scart.applyCoupon()
            default:
                break;

            }
        }
    }
}


