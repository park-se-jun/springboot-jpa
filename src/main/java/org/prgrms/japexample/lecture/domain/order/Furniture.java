package org.prgrms.japexample.lecture.domain.order;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("Furniture")
public class Furniture extends Item{
    private int width;
    private int height;
}
