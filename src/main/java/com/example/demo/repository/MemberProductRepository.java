package com.example.demo.repository;

import com.example.demo.domain.Item;
import com.example.demo.domain.Member;
import com.example.demo.domain.MemberProduct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberProductRepository {

    private final EntityManager em;

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;


    public void save(MemberProduct memberProduct){
        em.persist(memberProduct);
    }

    public List<Item> recommend(Long MemberId){
        List<Item> items= em.createQuery("select m.item from MemberProduct m where m.member.id =: MemberId ")
                .setParameter("MemberId",MemberId)
                .getResultList();
        return items;
    }


}
