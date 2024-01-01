public class Mechanic extends Customer {
    int reduction;

    public Mechanic(String name, int money,int reduction) throws IllegalArgumentException {
        super(name,money);
        if(name == null || money < 0 || reduction < 0){
            throw new IllegalArgumentException("this customer is not eligible to enter this enterprise");
        }
        this.reduction = reduction;

    }

    @Override
    public boolean buyItemsFromCart() throws IllegalArgumentException {
        Cart cart = new Cart();
        if(money < cart.calculatePrice() * 1-(reduction/100)){
            throw new IllegalArgumentException("this person can NOT buy anything.They are broke af");
        }
        money = money - cart.calculatePrice();
        return true;

    }
}
