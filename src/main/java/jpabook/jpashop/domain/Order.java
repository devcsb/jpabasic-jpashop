package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    /*
    * 현재 방식은 객체 설계를 테이블 설계에 맞춘 방식
    * 테이블의 외래키를 객체에 그대로 가져옴.
    * 객체 그래프 탐색이 불가능
    * */

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @Column(name = "member_id")  //객체지향스럽지 않다!
    private Long memberId;

    //JPA를 직접 쓰면 기본 설정이 orderDate가 그대로 나가지만, 스프링 부트로 JPA를 걸어서 올리면, 스프링 부트 기본설정에 의해서
    // CamelCase를 snake_case로 바꿔주는 설정이 적용되어, 컬럼 이름이 order_date로 create 된다.
    //JPA 단독으로 쓸 때는 따로  <property name="hibernate.physical_naming_strategy" value="org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy"/>
    //설정을 추가해주면 스프링을 걸어서 쓸 때 처럼 자동으로 변환된다.
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
