package dev.yeowon.crud.post;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceSimple implements PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;
    // 얘 뒤에 구현이 어떤 식으로 되든 상관하지 않겠다

    // 2.
    // SpringIOC 에서 해주는 부분인데..
    // interface 를 요구해도 PostRepository <-얘가 만족되는 interface 클래스를 가져다가
    // 현재 구현된 것 중에서 가장 우선적으로(순서를 정의해줄 수도 있긴 함)
    // (우선순위로) 구현되어 있는 클래스, 구현체를 가져와 준다.
    // 지금은 PostRepository(interface) 를 구현한 것이 PostRepositoryInMemory 밖에 없기 때문
    // 따라서 당연히 @Autowired PostRepository postRepository 의 구현체가
    // PostRepositoryInMemory 라고 예상할 수 있다.

    public PostServiceSimple(
            @Autowired PostRepository postRepository
    ){
        this.postRepository = postRepository;
    }

    // 1.
    // 생성자 호출할 때, postRepository 를 전달을 해줘라
    // postRepository 생성자가 호출되는 과정이 PostRepositoryInMemory 가 담당
    // postRepository 의 interface 를 기준으로 Service 에서 사용을 하고 있음

    // 3.
    // @Autowired <- 얘가 붙으면
    // PostRepository, 인터페이스를 만족하는 클래스를 IOC Container에서 제공해줌
    // postRepository <- 얘 멤버명이..? 인자로 자동으로 주입을 해줌(Dependency Injection - 의존관계 주입)
    // 이런 것이 스프링의 가장 큰 특징

    @Override
    public void createPost(PostDto dto) {
        // TODO
        if (!this.postRepository.save(dto)) {
            throw new RuntimeException("save failed");
            // (2)
            // boolean 을 사용한 이유
            // postRepository 구현의 응답의 형태가 문제가 생겼을 때
            // Exception 을 던질 수 있도록 하기 위해 boolean 사용
            // PostRepositoryInMemory 에 가면 boolean 사용한 것을 확인 가능
        }
    }
    // (1)
    // 게시글이 어떠한 게시판에 작성이 될 것인데
    // 어떤 사용자가 그 게시판에 대해서 권한이 충분한지
    // 이러한 부분을  //TODO check validity <- 이런 곳에다 넣을 수가 있다
    // 지금은 명백한 서비스의 구현이 되지 않았기 때문에 투두만 작성

    @Override
    public List<PostDto> readPostAll() {
        return this.postRepository.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, PostDto dto) {
    this.postRepository.update(id, dto);
    }

    @Override
    public void deletePost(int id) {
    this.postRepository.delete(id);
    }

    @Override
    public PostDto get(int id) {
        return null;
    }
}
