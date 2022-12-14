package org.prgrms.japexample.lecture.repository.domain.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.prgrms.japexample.lecture.domain.order.Member;
import org.prgrms.japexample.lecture.domain.order.Order;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.prgrms.japexample.lecture.domain.order.OrderStatus.OPENED;

@Slf4j
@SpringBootTest
public class OrderPersistenceTest {

    @PersistenceUnit
    EntityManagerFactory emf;

    @Test
    void member_insert(){
        Member member = new Member();
        member.setName("parksejun");
        member.setAddress("부천시");
        member.setAge(24);
        member.setNickName("paaaark");
        member.setDescription("not developer");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(member);

        transaction.commit();
    }

    @Test
    void 잘못된_설계(){
        Member member = new Member();
        member.setName("kanghonggu");
        member.setAddress("서울시 동작구(만) 움직이면 쏜다.");
        member.setAge(33);
        member.setNickName("guppy.kang");
        member.setDescription("백앤드 개발자에요.");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(member);
        Member memberEntity = entityManager.find(Member.class, 1L);

        Order order = new Order();
        order.setUuid(UUID.randomUUID().toString());
        order.setOrderDatetime(LocalDateTime.now());
        order.setOrderStatus(OPENED);
        order.setMemo("부재시 전화주세요.");
        order.setMemberId(memberEntity.getId()); // 외래키를 직접 지정

        entityManager.persist(order);
        transaction.commit();

        Order orderEntity = entityManager.find(Order.class, order.getUuid());
        // FK 를 이용해 회원 다시 조회
        Member orderMemberEntity = entityManager.find(Member.class, orderEntity.getMemberId());
        // orderEntity.getMember() // 객체중심 설계라면 객체그래프 탐색을 해야하지 않을까?
        log.info("nick : {}", orderMemberEntity.getNickName());
    }

    @Test
    void 연관관계_테스트(){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Member member = new Member();
        member.setName("세준박");
        member.setNickName("paak");
        member.setAddress("부천시");
        member.setAge(24);

        entityManager.persist(member);

        Order order = new Order();
        order.setUuid(UUID.randomUUID().toString());
        order.setOrderStatus(OPENED);
        order.setMemo("부제시 연락 주세요.");
        order.setMember(member);

        entityManager.persist(order);
        transaction.commit();

        entityManager.clear();
        var entity = entityManager.find(Order.class, order.getUuid());

        log.info("{}", entity.getMember().getName());

        log.info("{}",entity.getMember().getOrders().size());
        log.info("{}",order.getMember().getOrders());//잘 가져오지 못한다. (영속성 컨텍스트에서 setOrders를 안해주기 때문에
        //그래서 일반적으로 연관관계 편의 메소드를 만들어서 잘 설정되도록 한다.
    }
}
