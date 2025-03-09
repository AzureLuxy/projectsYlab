package domain;

public class Goal {
    private String name;
    private double sum;
    private String description;

    public Goal(String name, double sum, String description) {
        this.name = name;
        this.sum = sum;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
