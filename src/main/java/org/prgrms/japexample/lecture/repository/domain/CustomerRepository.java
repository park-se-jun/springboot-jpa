package org.prgrms.japexample.lecture.repository.domain;

import org.prgrms.japexample.lecture.repository.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//jpaRepository를 상속받아서 해당 엔티티의 레포지토리를 만든다.
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
