package cafe.income;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class CoffeeOrder {

    private LocalDate dateTime;
    private List<Coffee> coffeeList;

    public CoffeeOrder(LocalDate dateTime, List<Coffee> coffeeList) {
        this.dateTime = dateTime;
        this.coffeeList = coffeeList;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public List<Coffee> getCoffeeList() {
        return Collections.unmodifiableList(coffeeList);
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }


}
