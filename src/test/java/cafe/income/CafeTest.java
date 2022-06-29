package cafe.income;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CafeTest {

    @org.junit.jupiter.api.Test
    void getTotalIncome() {
        List<Coffee> coffeeList1=List.of(new Coffee(1),new Coffee(2),new Coffee(3));
        List<Coffee> coffeeList2=List.of(new Coffee(4),new Coffee(5),new Coffee(6));

        List<Coffee> coffeeList3=List.of(new Coffee(1000),new Coffee(900),new Coffee(1200));



        CoffeeOrder coffeeOrder1=new CoffeeOrder(LocalDate.now(),coffeeList1);
        CoffeeOrder coffeeOrder2=new CoffeeOrder(LocalDate.now(),coffeeList2);

        CoffeeOrder coffeeOrder3=new CoffeeOrder(LocalDate.now().minusDays(1),coffeeList2);
        CoffeeOrder coffeeOrder4=new CoffeeOrder(LocalDate.now().plusDays(1),coffeeList1);

        CoffeeOrder coffeeOrder5=new CoffeeOrder(LocalDate.parse("2022-06-26"),coffeeList3);

        List<CoffeeOrder> coffeeOrders=List.of(coffeeOrder1,coffeeOrder2,coffeeOrder3,coffeeOrder4);
        List<CoffeeOrder> coffeeOrders2=List.of(coffeeOrder5,coffeeOrder4);

        Cafe cafe=new Cafe(coffeeOrders);
        assertEquals(cafe.getTotalIncome(LocalDate.now()), 21);
        assertEquals(cafe.getTotalIncome(LocalDate.now().minusDays(1)), 15);
        assertEquals(cafe.getTotalIncome(LocalDate.now().plusDays(1)), 6);
        assertEquals(cafe.getTotalIncome(LocalDate.now().plusDays(2)), 0);


        Cafe cafe2=new Cafe(coffeeOrders2);
        assertEquals(cafe2.getTotalIncome(LocalDate.parse("2022-06-26")), 3100);





    }
}