package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
//제약조건도 가급적이면 Entity에 포함하여 작성한다.

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;

    /*
    * 잘못된 연관관계 설정의 예 : Member 엔티티에 Order 엔티티를 참조하는 필드를 만들고 연관관계 역방향을 설계하는 것.
    * 굳이 Member를 바라보면서 member의 orders를 꺼내올 일이 있을까?
    * 필요하면 member를 조회하고 order를 따로 조회하는 식의 설계가 올바르다.
    * 회원 객체에 모든 연관관계를 모아놓는 식의 설계를 항상 조심하자!
    * */
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); // NPE 방지 위하여 관례상 이렇게 초기화한다.


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

