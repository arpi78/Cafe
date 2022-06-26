package cafe.income;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


public class Cafe {

    List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public List<CoffeeOrder> getCoffeeOrders() {
        return Collections.unmodifiableList(coffeeOrders);
    }

   public void addNewOrder(CoffeeOrder order){
        coffeeOrders.add(order);
   }

    double getTotalIncome(LocalDate date){
        return coffeeOrders
                .stream()
                .filter(order -> order.getDateTime().isEqual(date))
                .flatMap(order -> order.getCoffeeList().stream())
                .mapToLong(coffee -> coffee.getPrice())
                .sum();
    }


}