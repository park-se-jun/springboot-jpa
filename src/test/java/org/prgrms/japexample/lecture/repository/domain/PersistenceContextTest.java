package org.prgrms.japexample.lecture.repository.domain;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PersistenceContextTest {

    @Autowired
    CustomerRepository repository;

    @PersistenceUnit
    EntityManagerFactory emf;

    @BeforeEach
    void setUp(){
        repository.deleteAll();
    }
    @Test
    void 저장(){
        var entityManager = emf.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();

        var customer = new CustomerEntity();//비영속 상태
        customer.setId(1L);
        customer.setFirstName("honggu");
        customer.setLastName("kang");

        entityManager.persist(customer);//비영속 -> 영속

        transaction.commit(); //중간에 entitiManager.flush() 일어남

    }
    @Test
    void 조회_DB조회(){
        var entityManager = emf.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();

        var customer = new CustomerEntity();//비영속 상태
        customer.setId(1L);
        customer.setFirstName("honggu");
        customer.setLastName("kang");

        entityManager.persist(customer);//비영속 -> 영속

        transaction.commit(); //중간에 entitiManager.flush() 일어남
        entityManager.detach(customer);//영속 -> 준영속

        var selected = entityManager.find(CustomerEntity.class, 1L);
        log.info("{} {}",selected.getFirstName(),selected.getLastName());
    }

    @Test
    void 조회_1차캐시_이용(){
        var entityManager = emf.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();

        var customer = new CustomerEntity();//비영속 상태
        customer.setId(1L);
        customer.setFirstName("honggu");
        customer.setLastName("kang");

        entityManager.persist(customer);//비영속 -> 영속

        transaction.commit(); //중간에 entitiManager.flush() 일어남

        var selected = entityManager.find(CustomerEntity.class, 1L);
        log.info("{} {}",selected.getFirstName(),selected.getLastName());
    }
    @Test
    public void 삭제(){
        var entityManager = emf.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();

        var customer = new CustomerEntity();//비영속 상태
        customer.setId(1L);
        customer.setFirstName("honggu");
        customer.setLastName("kang");

        entityManager.persist(customer);//비영속 -> 영속

        transaction.commit(); //중간에 entitiManager.flush() 일어남

        transaction.begin();
        entityManager.remove(customer);
        transaction.commit();
    }

}
