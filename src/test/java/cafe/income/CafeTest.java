package cafe.income;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CafeTest {

    @org.junit.jupiter.api.Test
    void getTotalIncome() {
        List<Coffee> coffeeList1=List.of(new Coffee(1),new Coffee(2),new Coffee(3));
        List<Coffee> coffeeList2=List.of(new Coffee(4),new Coffee(5),new Coffee(6));

        CoffeeOrder coffeeOrder1=new CoffeeOrder(LocalDate.now(),coffeeList1);
        CoffeeOrder coffeeOrder2=new CoffeeOrder(LocalDate.now(),coffeeList2);

        CoffeeOrder coffeeOrder3=new CoffeeOrder(LocalDate.now().minusDays(1),coffeeList2);
        CoffeeOrder coffeeOrder4=new CoffeeOrder(LocalDate.now().plusDays(1),coffeeList1);


        List<CoffeeOrder> coffeeOrders=List.of(coffeeOrder1,coffeeOrder2,coffeeOrder3,coffeeOrder4);

        Cafe cafe=new Cafe(coffeeOrders);
        assertEquals(cafe.getTotalIncome(LocalDate.now()), 21);
        assertEquals(cafe.getTotalIncome(LocalDate.parse("2022-06-26")), 21);
        assertEquals(cafe.getTotalIncome(LocalDate.now().minusDays(1)), 15);
        assertEquals(cafe.getTotalIncome(LocalDate.now().plusDays(1)), 6);
        assertEquals(cafe.getTotalIncome(LocalDate.now().plusDays(2)), 0);
    }
}