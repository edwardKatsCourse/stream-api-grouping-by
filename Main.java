package com.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var customer_case_1 = DiscountAssignee.builder()
                .customer(Customer.builder().id(1).build())
                .discount(Discount.builder().id(1).build())
                .build();

        var customer_case_2 = DiscountAssignee.builder()
                .customer(Customer.builder().id(1).build())
                .discount(Discount.builder().id(2).build())
                .build();

        var customer_case_3 = DiscountAssignee.builder()
                .customer(Customer.builder().id(1).build())
                .discount(Discount.builder().id(3).build())
                .build();



        // toMap(
        //  1-  KEY,
        //  2-  VALUE,
        //  3-  что делать, если дубликат
        //  4-  какую Map (TreeMap)
        // )

        // groupingBy (когда ключ дублируется, как "собирать" значения)

        // groupingBy (
        //  1- KEY
        //  2-
        //  Collectors.counting()    Map<Customer, Long>
        //  Collectors.mapping(List из каких VALUE ты хочешь)   Map<Customer, List<Discount>>
        // )

        // groupingBy(
        //  1-  KEY
        //  2-
        // )

        List<DiscountAssignee> customerDiscounts = List.of(customer_case_1, customer_case_2, customer_case_3);



        customerDiscounts.stream()
        // SOLUTION #1 - Map<Customer, List<Discount>>
//                .collect(Collectors.groupingBy(
//                        DiscountAssignee::getCustomer,
//                        Collectors.mapping(
//                                DiscountAssignee::getDiscount,
//                                Collectors.toList()
//                        )
//                ))
//                .entrySet()
//                .stream()
//                .anyMatch(x -> x.getValue().size() <= 2)

        // SOLUTION #2 - Map<Customer, Long>
//                .collect(Collectors.groupingBy(
//                        DiscountAssignee::getCustomer,
//                        Collectors.counting()
//                ))
//                .entrySet()
//                .stream()
//                .anyMatch(x -> x.getValue() >= 2)
        ;
    }
}

@AllArgsConstructor
@Data
@Builder
class DiscountAssignee {
    private Customer customer;
    private Discount discount;
}

@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
class Discount {
    private Integer id;
}

@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
class Customer {
    private Integer id;
}