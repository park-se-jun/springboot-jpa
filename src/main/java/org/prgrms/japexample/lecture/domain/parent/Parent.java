package org.prgrms.japexample.lecture.domain.parent;

import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@IdClass(ParentId.class)
public class Parent {
    @Id
    private String id1;
    @Id
    private String id2;
}
