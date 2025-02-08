package com.kasprzak.kamil.demoapp.post;

import com.kasprzak.kamil.demoapp.user.UserRepository;
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
        final var post = new PostEntity(user, content);
        postRepository.save(post);
    }

    public List<PostEntity> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void addComment(long postId, long userId, String content) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent(content);
        commentEntity.setPostEntity(postEntity);

        commentRepository.save(commentEntity);

        postEntity.getCommentEntities().add(commentEntity);
        postRepository.save(postEntity);
    }
}
