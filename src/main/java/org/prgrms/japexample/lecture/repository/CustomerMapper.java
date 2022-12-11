package org.prgrms.japexample.lecture.repository;

import org.apache.ibatis.annotations.Mapper;
import org.prgrms.japexample.lecture.repository.domain.Customer;

import java.util.List;

@Mapper
public interface CustomerMapper {
    void save(Customer customer);
    void update(Customer customer);
    Customer findById(long id);
    List<Customer> findAll();

}
