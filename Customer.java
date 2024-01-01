public class Customer {
    String name;
    int money;
    public Customer(String name,int money) throws IllegalArgumentException{
        if( name == null || money< 0){
            throw new IllegalArgumentException("This customer either does not exist or does not have any money");
        }
        this.name = name;
        this.money = money;
    }

    public void addItemToCart(MarketItem item, int n) throws IllegalArgumentException{
        if(item == null){
            throw new IllegalArgumentException("this item cant be added to the cart");
        }
        addItemToCart(item,n);
    }

    public boolean removeItemFromCart(MarketItem item, int n) throws IllegalArgumentException{
        if(item == null){
            throw new IllegalArgumentException("this item does not exist, therefore can not be removed from the cart");
        }
        removeItemFromCart(item,n);
        return true;
    }
    public boolean buyItemsFromCart(){
     Cart cart = new Cart();
     if(money - cart.calculatePrice() <= 0){
         return false;
     }
     money = money - cart.calculatePrice();
     cart.clear;
     return true;
    }
}
