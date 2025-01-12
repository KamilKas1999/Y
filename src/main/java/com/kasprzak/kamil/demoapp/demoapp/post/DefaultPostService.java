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

    private final CommentRepository commentRepository;


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

    @Override
    public void addComment(long postId, long userId, String content) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);

        commentRepository.save(comment);

        post.getComments().add(comment);
        postRepository.save(post);
    }
}
