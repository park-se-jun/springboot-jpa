package org.prgrms.japexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.prgrms.japexample.lecture.repository.domain.CustomerRepository;
import org.prgrms.japexample.lecture.repository.domain.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
public class JPATest {

    @Autowired
    CustomerRepository repository;

    @BeforeEach
    void setUp(){}
    @AfterEach
    void tearDown(){
        repository.deleteAll();
    }

    @Test
    void INSERT_TEST(){
        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setFirstName("honggu");
        customer.setLastName("kang");
//        customer.setAge(23);

        //when
        repository.save(customer);

        //then
        var entity = repository.findById(1L).get();
        log.info("{} {}",entity.getFirstName(),entity.getLastName());
//        log.info("{}",customer.getAge());
    }

    @Test
    @Transactional
    void UPDTE_TEST(){
        //given
        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setFirstName("honggu");
        customer.setLastName("kang");
        repository.save(customer);
        //when
        var entity = repository.findById(1L).get();
        entity.setFirstName("quppy");
        entity.setLastName("hong");

        //then
        var updated = repository.findById(1L).get();

        log.info("{} {}",updated.getFirstName(),updated.getLastName());

    }
}
