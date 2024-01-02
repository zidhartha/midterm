public class Customer {
     String name;
     int money;
     Cart<MarketItem> cart;
    public Customer(String name,int money) throws IllegalArgumentException{
        if( name == null || money< 0){
            throw new IllegalArgumentException("This customer either does not exist or does not have any money");
        }
        this.name = name;
        this.money = money;
        cart = new Cart();
    }

    public Cart<MarketItem> getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }

    public void addItemToCart(MarketItem item, int n) throws IllegalArgumentException{
        if(item == null || n == 0){
            throw new IllegalArgumentException("this item cant be added to the cart");
        }
        cart.addItem(item,n);

    }

    public boolean removeItemFromCart(MarketItem item, int n) throws IllegalArgumentException{
        if(item == null){
            throw new IllegalArgumentException("this item does not exist, therefore can not be removed from the cart");
        }
        cart.removeItem(item,n);
        return true;
    }
    public boolean buyItemsFromCart(){
     Cart cart = new Cart();
     if(money - cart.calculatePrice() <= 0){
         return false;
     }
     cart.checkOut(money);
     return true;
    }
}
