import java.util.Objects;

public class CarPart implements MarketItem {
    private final String name;
    private final int price;

    public CarPart(String name, int price) throws IllegalArgumentException {
        if (name == null || price < 0) {
            throw new IllegalArgumentException("name can not be nonexistent and price can not be below 0");
        }
        this.price = price;
        this.name = name;
    }

    @Override
    public int getPrice() {

        return price;
    }

    public String getName() {

        return name;
    }

    public int hashCode() {

        return Objects.hash(this.getName());
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        CarPart x = (CarPart) o;
        return x.getName().equals(((CarPart) o).getName());
    }
}


