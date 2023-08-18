package dev.thoourh.jpa.repository;

import dev.thoourh.jpa.entity.BoardEntity;
import dev.thoourh.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
