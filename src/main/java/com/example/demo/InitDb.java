package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.service.ItemService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;


    @PostConstruct
    public void init(){
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;
        private final ItemService itemService;


        public void dbInit1(){
            Member member1 = new Member();
            member1.setName("aaa");
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("bbb");
            em.persist(member2);

            Member member3 = new Member();
            member3.setName("ccc");
            em.persist(member3);

            Item book1 = createBook("bible",1920,"jesus",ItemStatus.YET);
            Item book2 = createBook("capitalism",1942,"marx",ItemStatus.YET);
            Item book3 = createBook("buddhism",1944,"buddha",ItemStatus.YET);
            em.persist(book1);
            em.persist(book2);
            em.persist(book3);

            Item album1 = createAlbum("discovery",1940,ItemStatus.YET,"daftPunk");
            Item album2= createAlbum("thriller",1980,ItemStatus.YET,"michaelJackson");
            Item album3 = createAlbum("morningGlory",1993,ItemStatus.YET,"oasis");
            em.persist(album1);
            em.persist(album2);
            em.persist(album3);

            Item movie1 = createMovie("lady",2002,ItemStatus.YET,"park","netflix");
            Item movie2 = createMovie("oldBoy",2003,ItemStatus.YET,"camel","netflix");
            Item movie3 = createMovie("parasite",2020,ItemStatus.YET,"bong","disney");
            em.persist(movie1);
            em.persist(movie2);
            em.persist(movie3);

        }

        private Book createBook(String name, long years, String author, ItemStatus itemStatus){
            Book book = new Book();
            book.setName(name);
            book.setYears(years);
            book.setAuthor(author);
            book.setItemStatus(ItemStatus.YET);
            return book;
        }

        private Album createAlbum(String name, long years, ItemStatus itemStatus, String artist){
            Album album = new Album();
            album.setName(name);
            album.setYears(years);
            album.setItemStatus(ItemStatus.YET);
            album.setArtist(artist);
            return album;
        }

        private Movie createMovie(String name, long years, ItemStatus itemStatus, String director, String platForm){
            Movie movie = new Movie();
            movie.setName(name);
            movie.setYears(years);
            movie.setItemStatus(ItemStatus.YET);
            movie.setDirector(director);
            movie.setPlatForm(platForm);
            return movie;
        }



    }


}
