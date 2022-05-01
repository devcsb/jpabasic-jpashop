package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // xml의 <persistence-unit name> 값을 넣어줌.

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member findMember = order.getMember(); // 이렇게 바로 객체를 탐색할 수 있어야 한다!

            Order order = em.find(Order.class, 1L); // 현재 데이터중심 Entity 매핑으로는 이런 식으로 가져올 수 밖에 없음.
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId);  //객체지향스럽지 않다!


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();


    }
}
