package org.prgrms.japexample.lecture.repository.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//jpa 는 default constructor 와 getter setter를 사용한다.
@Entity //실제 테이블과 매핑된다는 뜻
@Table(name = "customers")//연결되는 테이블
public class CustomerEntity {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
