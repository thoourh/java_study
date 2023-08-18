package dev.thoourh.jpa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static jdk.internal.jimage.ImageReaderFactory.get;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void readPost() throws Exception {
        // given 어떤 데이터가 준비가 되어있다
        final int id = 10;
        PostDto testDto = new PostDto();
        testDto.setId(id);
        testDto.setTitle("Unit Title");
        testDto.setContent("Unit Content");
        testDto.setWriter("unit");

        given(PostService.readPost(id)).willReturn(testDto);

        // when 어떤 행위가 일어났을때 (함수 호출 등)
        final ResultActions actions = mockMvc.perform(get("/post/{id}", id))
                .andDo(print());
        // then 어떤 결과가 올 것인지
        actions.andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$.title", is("Unit Title")),
                jsonPath("$.content", is("Unit Content")),
                jsonPath("$.writer", is("unit"))
        );
    }

    @Test
    public void readPostAll() throws Exception{
        PostDto post1 = new PostDto();
        post1.setTitle("title 1");
        post1.setContent("test");
        post1.setWriter("test");
        PostDto post2 = new PostDto();
        post2.setTitle("title 2");
        post2.setContent("test2");
        post2.setWriter("test2");

        List<PostDto> readAllPost = Arrays.asList(post1, post2);
        given(PostService.readPostAll()).willReturn(readAllPost);

        //when
        final ResultActions actions = mockMvc.perform(get("/post"))
                .andDo(print());

        // then
        actions.andExpectAll(
                status().isOk(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                jsonPath("$", hasSize(readAllPost.size()))
                );

    }
}