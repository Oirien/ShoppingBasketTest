import org.example.Goods;
import org.example.ShoppingCart;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class ShoppingCartTests {
    private ShoppingCart cart;

    /* Need to be able to do the following
    * Add items to the basket
    * Remove items from the basket
    * empty the basket
    * Calculate the total price
    *   When calculating the total price apply discounts
    *   buy-one-get-one-free offers
    *   10% off totals greater than 20£
    *   2% off on total for customers with loyalty card */

    @Before
    public void before(){
        cart = new ShoppingCart();
    }

    @Test
    public void basketStartsEmpty(){
        assertEquals(0, cart.getContents().size());
    }

    @Test
    public void canAddItemToBasket(){
        cart.addGood(Goods.POTATO);
        assertEquals(1, cart.getContents().size());
    }

    @Test
    public void canRemoveItemFromBasket(){
        cart.addGood(Goods.POTATO);
        cart.removeGood(Goods.POTATO);
        assertEquals(0, cart.getContents().size());
    }

    @Test
    public void canEmptyBasket(){
        cart.addGood(Goods.POTATO);
        cart.addGood(Goods.CHEESE);
        cart.emptyContents();
        assertEquals(0, cart.getContents().size());
    }

    @Test
    public void canCalculateTotalPrice(){
        cart.addGood(Goods.BREAD);
        cart.addGood(Goods.MUSTARD);
        cart.addGood(Goods.POTATO);
        cart.addGood(Goods.CHEESE);
        cart.addGood(Goods.CHEESE);
        cart.addGood(Goods.CHEESE);
        cart.addGood(Goods.POTATO);
        cart.addGood(Goods.POTATO);
        cart.addGood(Goods.POTATO);
        cart.addGood(Goods.BREAD);
        cart.addGood(Goods.BREAD);
        cart.addGood(Goods.BREAD);

        assertEquals(19.1, cart.calculatePrice(), 0.0);
    }

}
