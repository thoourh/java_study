package dev.yeowon.crud.post;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// "post"로 위치를 지정하고, 그 자원에다가 어떠한 일을 할지 Method를 통해서 방법을 전달
// 그거에 따라서 좀 더 명확한 형태, 어떤 상태로 진행이 되는지를
// @ResponseStatus(HttpStatus.~) 를 통해 알려줄 수 있다
// 특정한 자원에 조건을 줌으로써 수행하고 싶을 때는
// @RequestParameter를 사용

// @RestController 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어 준다.
// 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 됌!

// @Deprecated 쓰는 이유..
// 임의의 특정한 시점에서 PostController 를 만들어서 클라이언트까지 작성 완료 했음
// 근데 이 CRUD 형태는 restful 하지 않습니다.. 뭐래
// 그래서 그걸 대체하기 위해서 PostRestController 를 만들었음
// 하지만 클라이언트들의 적응 기간이 필요함 !!
// 그래서 @Deprecated 사용함, @Deprecated <- 얘가 붙으면..
// 더 이상 사용을 하지 않을 예정이라 라는 뜻 !'
// 따라서, 당장은 사용 가능하지만, 미래에는 쓸 수 없을 것을 알려줌

@Deprecated
@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger((PostRestController.class));
    private final PostService postService;
    //private final List<PostDto> postList;

    // 더 이상 변경할 필요 없다는 것을 알려주는 final
    // final이 들어가면 더 이상 새로운 변수 값이 들어갈 수 없다는 뜻

    public PostRestController(
            @Autowired PostService postService
    ) {
        this.postService = postService;
    }

    // http://localhost:8080/post
    // post가 들어가면 -> 나는 게시글에 대한 정보를 볼 거야
    // Post 경로에 /post 요청이 들어오면 안쪽에 있을 Request_Body에 따라서 Post 게시글을 만들어 내야함
    // 따라서, 아래의 @PostMapping() 의 괄호 안에는 아무것도 들어가지 않음
    // 뭔가 새로운 정보, 데이터를 전달할 때는 @RequestBody

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto, HttpServletRequest request) {
        logger.info(postDto.toString());
        request.getHeader("Content-Type");
        this.postService.createPost(postDto);
    }

    // http://localhost:8080/post
    // GET /post <- 이러한 요청을 받았다
    // Read에서 사용되기 권장하는 매소드는 @GetMapping

    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
        return this.postService.readPostAll();
    }

    // GET /post/0/ (이후) <- path를 사용
    // GET /post/?id=0 (이전) <- query를 사용

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        logger.info("in read post");
        return this.postService.readPost(id);
    }

    // @PostMapping 은 없었던 자원을 새로 생성해서 만드는 것
    // @PutMapping 은 현재 보내고 있는 데이터를 그 위치에 다시 넣어주라는 뜻
    // 따라서, 새로운 것을 만들 때는 @PostMapping, 대체를 할 때는 @PutMapping


    // PUT /post/0/
    //@ResponseStatus(HttpStatus.ACCEPTED) <- 도 가능

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ) {
        logger.info("target id: " + id);
        logger.info("update content" + postDto);
        this.postService.updatePost(id, postDto);
    }

    // DELETE /post/0/

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }
}


    // 정리 (지금 컨트롤러에 만들어져 있는 Mapping 5가지)

    // POST /post
    // GET /post/0/
    // GET /post
    // PUT /post/0/
    // DELETE /post/0/

    // 게시글 자원들에 대한 모든 요청들이 post라는 경로로 가고 있음
    // 특정한 자원에 대한 요청을 확인하고 싶다면, 그 경로에 그 자원에 대한 id를 제공하면 됌
    // 그 자원에서 어떤 작업을 하고 싶은 지는 Method로 표현이 되어 있음

    // if (게시판에 대한 내용)

    // POST /board
    // GET /board/0/
    // GET /board
    // PUT /board/0/
    // DELETE /board/0/

    // 현재 형태와 같은 것이 적응하기 편하다라는 의미

    // SpringFramework 에서 Service, Annotation, Repository 같은 경우는
    // 관리적인 측면에서 사용하는 부분이 크기 때문에 반드시 사용해야 함
    // 특히, Service 는 Business Logic, 실행하기 전의 Business Logic의 결과들을 조합할 때 사용
    // 레포는 데이터를 실제로 주고 받는 파트를 만들 때 사용