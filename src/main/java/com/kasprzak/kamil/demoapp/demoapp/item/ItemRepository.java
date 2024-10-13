package com.kasprzak.kamil.demoapp.demoapp.item;

import com.kasprzak.kamil.demoapp.demoapp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
