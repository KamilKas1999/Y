package com.kasprzak.kamil.demoapp.demoapp.post;

import com.kasprzak.kamil.demoapp.demoapp.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class DefaultPostService implements PostService {

    private final UserRepository userRepository;

    private final PostRepository postRepository;


    public void createPost(final long userId, final String content) {
        final var user = userRepository.findById(userId).orElseThrow();
        final var post = new Post(user, content);
        postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}
