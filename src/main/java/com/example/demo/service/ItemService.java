package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.MemberProductRepository;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final MemberProductRepository memberProductRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

    public List<Album> findAlbums(){
        return itemRepository.findAlbums();
    }
    public List<Movie> findMovies(){
        return itemRepository.findMovies();
    }
    public List<Book> findBooks(){
        return itemRepository.findBooks();
    }

    public void update(Long memberId, Long itemId){
        Item item = itemRepository.findOne(itemId);
        Member member = memberRepository.findOne(memberId);
    }

}
