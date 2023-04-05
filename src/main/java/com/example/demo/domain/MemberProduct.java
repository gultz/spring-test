package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MemberProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    /**
     * 생성메서드
     *
     */
    public void setMember(Member member){
        this.member = member;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public static MemberProduct createMemberProduct(Member member, Item item){
        MemberProduct memberProduct = new MemberProduct();
        memberProduct.setMember(member);
        memberProduct.setItem(item);
        return memberProduct;
    }

}
