package org.prgrms.japexample.lecture.repository.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.prgrms.japexample.lecture.repository.domain.CustomerEntity;
import org.prgrms.japexample.lecture.repository.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    void test(){
        //given
        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setFirstName("honggu");
        customer.setLastName("kang");

        //when
        repository.save(customer);

        //then
        var entity = repository.findById(1L).get();
        log.info("{} {}",entity.getFirstName(),entity.getLastName());
    }
}