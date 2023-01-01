package org.prgrms.japexample.lecture.domain.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Table(name = "item")
public abstract class Item extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int price;
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "orderItem_id",referencedColumnName = "id")
    private OrderItem orderItem;

    public void setOrderItem(OrderItem orderItem){
        if(Objects.nonNull(this.orderItem)){
            this.orderItem.getItems().remove(this);
        }
        this.orderItem = orderItem;
        orderItem.getItems().add(this);
    }
}
