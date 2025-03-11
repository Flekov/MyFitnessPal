package Items;

public class Food extends Item {
    private String name;
    private int servingSize;
    private int numberOfServings;
    private int calories;
    private double carbs;
    private double fat;
    private double protein;

    public Food(){}

    public Food(String name , int servingSize, int numberOfServings, int calories, double carbs, double fat, double protein) {
        this.name = name;
        this.servingSize = servingSize;
        this.numberOfServings = numberOfServings;
        this.calories = calories;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public int getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    @Override
    public String toString() {
        return name +
                "\n Per Serving(" + servingSize + "g; " + calories + " kcal; " + protein + "g, " + fat + "g, " + carbs + "g)" +
                "\n Per Container(" + numberOfServings * servingSize + "g; " + numberOfServings * calories + " kcal; " + (numberOfServings * protein) + "g, " + numberOfServings * fat + "g, " + numberOfServings * carbs + "g)";
    }
}
