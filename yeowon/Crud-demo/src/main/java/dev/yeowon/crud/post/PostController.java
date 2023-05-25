package dev.yeowon.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// @Deprecated <- 설명에 이어서..
// PostController <- 얘는 더 이상 컨트롤러 내부에서 포스트를 관리하지 않을 것임
// 진짜 오롯이 요청을 보내고 응답을 보내는 역할로만 수행할 것임

// @Controller 는 @RequestMapping 을 시용하기 위한 Annotation

@Controller
@ResponseBody
//@RequestMapping("post")
public class PostController{
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(
            @Autowired PostService postService
    ){
        this.postService = postService;
    }


    // @PostMapping Http Method 인 Post 의 요청을 받을 수 있는 API 를 만들어 준다?? 몰라 몰라

    @PostMapping("create")
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    // @GetMapping Http Method 인 Get 의 요청을 받을 수 있는 API 를 만들어 준다.
    // 이전에는 RequestMapping(method = RequestMethod.GET)으로 사용되었다.
    // 이제 이 프로젝트에 read-all 이라는 요청이 오면 수정 또는 삭제 된 요소를 포함해 읽는 기능??

    @GetMapping("read-all")
    public List<PostDto> readPostAll(){
        logger.info("in read all");
        return this.postService.readPostAll();
    }

    @GetMapping("read-one")
    public PostDto readPostOne(@RequestParam("id") int id) {
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    @PostMapping("update")
    public void updatePost (
            @RequestParam("id")int id,
            @RequestBody PostDto postDto
    ){
        logger.info("target id: " + id);
        logger.info("update content" + postDto);
        this.postService.updatePost(id, postDto);
    }
        /* PostDto targetPost = this.postService.get(id);
        if (postDto.getTitle() != null){
            targetPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null){
            targetPost.setContent(postDto.getContent());

            this.postService(id, targetPost);
        }*/

    @DeleteMapping("delete")
    public void deletePost ( @RequestParam("id") int id){
        this.postService.deletePost(id);
    }
}