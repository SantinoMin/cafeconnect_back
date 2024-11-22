package com.kong.cc.repository;

import com.kong.cc.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kong.cc.entity.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer>{

    Item findByItemCode(String itemCode);

    @Query("select i from Item i where i.itemName like '%:keyword%'")
    Page<Item> findMenuListByKeyword(@Param("keyword") String keyword, Pageable pageable);


}
