package com.kasprzak.kamil.demoapp.demoapp.post;

import com.kasprzak.kamil.demoapp.demoapp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
