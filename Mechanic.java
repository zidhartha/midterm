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
        int moneyAfter = super.getCart().calculatePrice() - super.getCart().calculatePrice() *(reduction/100);
        if(super.getMoney() < moneyAfter){
            return false;
        }
        super.setMoney(super.getMoney()- moneyAfter);
        super.getCart().checkOut(moneyAfter);
        return true;
    }
}
