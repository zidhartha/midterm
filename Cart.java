import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Cart <T extends MarketItem> {
    private HashMap<Integer, ArrayList<T>> cart = new HashMap<>();

    public void addItem(T item,int n) throws IllegalArgumentException{
      if(item == null || n<=0){
          throw new IllegalArgumentException("Item can not be equal to null");
      }
        ArrayList<T> shoppingCart = cart.get(item.hashCode());
        shoppingCart.add(item);
        cart.put(item.hashCode(), shoppingCart);
        addItem(item,n-1);
    }

    public boolean removeItem(T item, int n) throws IllegalArgumentException{
        if(item == null || !cart.containsKey(item) || n <=0){
            throw new IllegalArgumentException("this item doesnt exist or is not in the cart");
        }
        ArrayList<T> shoppingCart = cart.get(item.hashCode());
        shoppingCart.remove(item);
        removeItem(item,n-1);
        return true;
        }

    public int calculatePrice(){
        return cart.entrySet().stream().mapToInt(e -> e.getValue().size() * e.getValue().get(0).getPrice()).sum();
    }
    public int checkOut(int money) throws IllegalArgumentException{
        if(money - calculatePrice() < 0){
            throw new IllegalArgumentException("not enough money in the bank account");
        }
        money = money - calculatePrice();
        cart.clear();
        return money;
    }
}
