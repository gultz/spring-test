package com.example.demo.web;

import com.example.demo.domain.Album;
import com.example.demo.domain.Book;
import com.example.demo.domain.Item;
import com.example.demo.domain.Movie;
import com.example.demo.service.ItemService;
import com.example.demo.service.MemberProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final ItemService itemService;
    private final MemberProductService memberProductService;


    @GetMapping(value = "/items/{memberId}/itemList")
    public String list(@PathVariable Long memberId, Model model){
        List<Album> albums = itemService.findAlbums();
        List<Movie> movies = itemService.findMovies();
        List<Book> books = itemService.findBooks();
        model.addAttribute("books",books);
        model.addAttribute("movies",movies);
        model.addAttribute("albums",albums);
        model.addAttribute("itemForm",new ItemForm());
        return "/items/itemList";
    }

    @PostMapping(value = "/items/{memberId}/itemList")
    public String checkList(@ModelAttribute ItemForm itemForm, @PathVariable Long memberId ){

        List<Long> itemIds= itemForm.getMemberIds();

        for(Long itemId : itemIds){
            memberProductService.setDb(memberId,itemId);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/items/{memberId}/recommend")
    public String recommend(@PathVariable Long memberId,Model model){
        List<Item> items = memberProductService.findAll(memberId);
        model.addAttribute("items",items);
        return "/items/recommendList";
    }






}
