package com.example.demo.repository;


import com.example.demo.domain.Album;
import com.example.demo.domain.Book;
import com.example.demo.domain.Item;
import com.example.demo.domain.Movie;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        if(item.getId() ==null){
            em.persist(item);
        }else{
            em.merge(item);
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i")
                .getResultList();
    }

    public List<Album> findAlbums(){
        return em.createQuery("select i from Album i ")
                .getResultList();
    }

    public List<Movie> findMovies(){
        return em.createQuery("select i from Movie i")
                .getResultList();
    }

    public List<Book> findBooks(){
        return em.createQuery("select i from Book i")
                .getResultList();
    }


}
