package org.prgrms.japexample.lecture.repository.domain.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.prgrms.japexample.lecture.domain.order.Food;
import org.prgrms.japexample.lecture.domain.order.Order;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ImproveMappingTest {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void inheritance_test(){
        EntityManager entityManager =emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Food food = new Food();
        food.setPrice(1000);
        food.setStockQuantity(100);
        food.setChef("백종원");

        entityManager.persist(food);
        transaction.commit();
    }

    @Test
    void mapped_super_class_table(){
        EntityManager entityManager =emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Order order = new Order();
//        order.s


        entityManager.persist(order);
        transaction.commit();
    }
}
