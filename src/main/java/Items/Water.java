package Items;

public class Water extends Item {
    private int amount;

    public Water(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return amount + "";
    }
}
