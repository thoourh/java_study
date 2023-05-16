package koo.bonun.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final List<PostDto> postlist;
    public PostController(){
        postlist = new ArrayList<>();
    }
        @PostMapping("create")
        public void createPost(@RequestBody PostDto postDto) {
            logger.info(postDto.toString());
            this.postlist.add(postDto);
        }

        @GetMapping("read-all")
        public List<PostDto> readPostAll(){
            logger.info("in read all");
            return this.postlist;
        }

        @GetMapping("read-one")
        public PostDto readPostOne(@RequestParam("id") int id){
            logger.info("in read one");
            return this.postlist.get(id);
        }
        @PostMapping("update")
        public void updatePost (
                @RequestParam("id")int id,
                @RequestBody PostDto postDto
        ){
            PostDto targetPost = this.postlist.get(id);
            if(postDto.getTitle() != null){
                targetPost.setTitle(postDto.getTitle());
            }
            if(postDto.getContent() != null){
                targetPost.setContent(postDto.getContent());
            }
            this.postlist.set(id, targetPost);
    }

    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id){
        this.postlist.remove(id);
    }

}