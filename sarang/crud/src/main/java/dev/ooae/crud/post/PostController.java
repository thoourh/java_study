package dev.ooae.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.ArrayList;

@Controller
@ResponseBody
// 콘트롤러, 리스폰스바디를 붙여놓는 건 클래스 안에 있는 모든 함수들이 레스폰스바디가 붙여있는 형태로 함수선언이 됨
@RequestMapping("post") //클래스에 붙여주면 클래스 내에 있는 리퀘스트매핑에 따라 앞쪽에 포스트 매핑이 붙는다.
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final List<PostDto> postList;

    public PostController(){
        postList = new ArrayList<>();
    }
@PostMapping("create") //body가 필요, 뭔가가 제공 필요
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    @GetMapping("read-all") //사용자가 조회를 하는 요청
    public List<PostDto> readPostAll(){
        logger.info("in read all");
        return this.postList;
    }

    @GetMapping("read-one")
    public PostDto readPostOne(@RequestParam("id") int id){
        logger.info("in read one");
        return  this.postList.get(id);
    }

    @PostMapping("update")
    public void updatePost(@RequestParam("id")int id, //쿼리
                           @RequestBody PostDto postDto) //포스트 요청의 쿼리
    {
        //업데이트를 하기 위한 목적 게시글
         PostDto targetPost = this.postList.get(id); //리스트의 인덱스 값 그대로 사용
        if( postDto.getTitle() != null){
            targetPost.setTitle(postDto.getTitle());
        }
        if( postDto.getTitle() != null){
            targetPost.setContent(postDto.getContent());
        }
        this.postList.set(id, targetPost);
    }

    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id")int id){
        this.postList.remove(id);
    }
}
