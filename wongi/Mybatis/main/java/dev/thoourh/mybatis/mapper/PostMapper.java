package dev.thoourh.mybatis.mapper;

import dev.thoourh.mybatis.dto.PostDto;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

import java.util.List;

public interface PostMapper {
    int createPost(PostDto dto);
    int createPostAll(List<PostDto> dtoList);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    PostDto readPostQuery(PostDto dto);
    int updatePost(PostDto dto);
    int deletePost(int id);
}
