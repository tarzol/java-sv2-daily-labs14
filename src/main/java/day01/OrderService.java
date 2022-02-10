package day01;

import java.text.Collator;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }


    public List<Order> findOrderByStatus(String status) {
        return orders.stream().
                filter(o->o.getStatus().equals(status)).
                collect(Collectors.toList());
    }


    public Long countOrderByStatus(String status) {
        return orders.stream().
                filter(o -> o.getStatus().equals(status))
                .count();
    }

    public List<Order> getOrdersBetweenDate(LocalDate localDate1, LocalDate localDate2) {
        return orders.stream().
                filter(o -> (o.getOrderDate().isBefore(localDate1) && localDate2.isAfter(o.getOrderDate())))
                .collect(Collectors.toList());
    }

//    public List<Order> getOrdersBetweenDates(LocalDate start, LocalDate end) {
//        return orders.stream()
//                .filter(o -> o.getOrderDate().isAfter(start) )
//                .filter(o -> o.getOrderDate().isBefore(end))
//                .collect(Collectors.toList());
//    }

    public boolean isOrderWithLessProduct(int number) {
        return !orders.stream()
                .filter(o -> o.getProducts().size() < number)
                .collect(Collectors.toList()).isEmpty();
    }


//    public boolean isOrderWithLessProductThan(int number){
//        return  orders.stream()
//                .mapToInt(o->o.getProducts().size())   //mapToInt hozzárendelem o-hoz a listát
//                .anyMatch(i->i<number);                  //Mappel új stream jön létre
//    }


    public Order getOrderWithMostProducts() {
        return orders.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(o ->o.getProducts().size())))
                .findFirst().orElseThrow(()->new IllegalStateException("No products"));
    }

//    public Order getOrderWithMaxNumberOfProducts(){
//        return orders.stream()
//                .sorted(Collections.reverseOrder(Comparator.comparing(o->o.getProducts().size())))
//                .findFirst().orElseThrow(()->new IllegalStateException("Empty List"));
//    }

    public List<Order> getOrdersWithProductInCategory(String category) {
        return orders.stream()
                .filter(o -> o.getProducts()
                        .stream().anyMatch(p -> p.getCategory().equals(category)))
                .collect(Collectors.toList());
    }

//    public List<Order> getOrdersWithProductInCategory(String category){

//        return orders.stream()
//                .filter(o->o.getProducts().
//                        stream().anyMatch(p->p.getCategory().equals(category)))
//                .collect(Collectors.toList());
//    }

}
