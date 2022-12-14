package org.prgrms.japexample.lecture.domain.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @Column(name = "id")
    private String uuid;
    @Column(name = "memo")
    private String memo;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    @Column(name = "order_datetime",columnDefinition = "TIMESTAMP")
    private LocalDateTime orderDatetime;

    // member_fk
    @Column(name = "member_id",insertable = false,updatable = false)
    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "member_id",referencedColumnName = "id")
    private Member member;

    public void setMember(Member member){
        if (Objects.nonNull(this.member)){
            member.getOrders().remove(this);
        }

        this.member = member;
        member.getOrders().add(this);
    }
}
