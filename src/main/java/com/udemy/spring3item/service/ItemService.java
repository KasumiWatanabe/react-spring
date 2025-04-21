package com.udemy.react-spring.service;

import com.udemy.react-spring.model.HelloMessage;
import com.udemy.react-spring.model.Item;
import com.udemy.react-spring.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    private RestTemplate restTemplate;

    public  ItemService (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Cacheable("getItems")
    public List<Item> getAllItems(){
        List<Item> allItems = new ArrayList<>();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        itemRepository.findAll().forEach(allItems::add);
        return allItems;
    }

    @Cacheable(value = "getItem", key = "#p0")
    public Optional<Item> getItem(Long itemId){

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemRepository.findById(itemId);
    }

    @CacheEvict(value = "getItems", allEntries = true)
    public void addItem(Item item){
        itemRepository.save(item);
    }

    @Caching(evict = {
            @CacheEvict(value = "getItem", key = "#p0"),
            @CacheEvict(value = "getItems", allEntries = true)
    })
    public void updateItem(Long itemId, Item item) {
        if(itemRepository.findById(itemId).get() != null) {
            itemRepository.save(item);
        }
    }

    @Caching(evict = {
            @CacheEvict(value = "getItem", key = "#p0"),
            @CacheEvict(value = "getItems", allEntries = true)
    })
    public void deleteItem(Long itemId){
        itemRepository.deleteById(itemId);
    }

    public HelloMessage getHelloResponse() {
        String URL = "http://localhost:8081/hello";
        String hello = restTemplate.getForObject(URL, String.class);

        HelloMessage retHello = new HelloMessage(hello);

        return retHello;
    }
}
