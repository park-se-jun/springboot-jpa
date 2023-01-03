package org.prgrms.japexample.lecture.domain.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//jpa 는 default constructor 와 getter setter를 사용한다.
@Entity //실제 테이블과 매핑된다는 뜻
@Table(name = "customers")//연결되는 테이블
@AllArgsConstructor
@NoArgsConstructor//(access = AccessLevel.PROTECTED)
public class CustomerEntity {
    @Id
    @NotNull
    @GeneratedValue
    private long id;

    @NotBlank(message = "이름에 값을 입력해야 합니다.")
    @Size(min = 1, max = 22, message = "이름은 1 ~ 22자 이내로 입력해야 합니다.")
    @Pattern(regexp = "^[가-힣]*$",message = "이름은 한글만 허용됩니다.")
    private String firstName;

    @NotBlank(message = "성에 값을 입력해야 합니다.")
    @Size(min = 1, max = 2, message = "성은 1 ~ 2자 이내로 입력해야 합니다.")
    @Pattern(regexp = "^[가-힣]*$",message = "성은 한글만 허용됩니다.")
    private String lastName;

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

}
