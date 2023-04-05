package com.example.demo.service;

import com.example.demo.domain.Item;
import com.example.demo.domain.ItemStatus;
import com.example.demo.domain.Member;
import com.example.demo.domain.MemberProduct;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.MemberProductRepository;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberProductService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final MemberProductRepository memberProductRepository;

    @Transactional
    public void saveMemberProduct(MemberProduct memberProduct){
        memberProductRepository.save(memberProduct);
    }

    @Transactional
    public void setDb(Long memberId, Long itemId){
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        MemberProduct memberProduct = MemberProduct.createMemberProduct(member,item);
        memberProduct.getItem().setItemStatus(ItemStatus.DONE);
        member.getMemberProducts().add(memberProduct);
        item.getMemberProducts().add(memberProduct);
        memberProductRepository.save(memberProduct);
    }

    @Transactional
    public List<Item> findAll(Long memberId){
        return memberProductRepository.recommend(memberId);
    }

}
