package dev.yeowon.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PostRepositoryInMemory implements PostRepository {
    private static final Logger logger = LoggerFactory.getLogger(PostRepositoryInMemory.class);
    private final List<PostDto> postList;

    public PostRepositoryInMemory() {
        this.postList = new ArrayList<>();
    }

    @Override
    public boolean save(PostDto dto) {
        return this.postList.add(dto);
    }

    @Override
    public List<PostDto> findAll() {
        return this.postList;
    }

    @Override
    public PostDto findById(int id) {
        return this.postList.get(id);
    }

    // 여기에서 굳이 Repository 의 Boolean 값을 돌려주느냐면..
    // 지금은 성공하는 경우만 가정하고 있어서 ..
    // 나중에는 성공X 등 더 정교하게 만들어야 함

    @Override
    public boolean update(int id, PostDto postDto) {
        PostDto targetPost = this.postList.get(id);
        if (postDto.getTitle() != null) {
            targetPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            targetPost.setContent(postDto.getContent());
        }
        this.postList.set(id, targetPost);
        return true;
    }

    // 여기서 if 문은 true 가 아니라면의 조건을 상정하기 위한 것

    @Override
    public boolean delete(int id) {
        this.postList.remove(id);
        return true;
    }
}
