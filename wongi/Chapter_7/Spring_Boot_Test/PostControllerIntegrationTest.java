package dev.thoourh.jpa;

import dev.thoourh.jpa.entity.PostEntity;
import dev.thoourh.jpa.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static jdk.internal.jimage.ImageReaderFactory.get;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = JpaApplication.class
)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureTestDatabase
public class PostControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Before
    public void setEntities(){
        createTestPost("first post", "first post content", "test_writer");
        createTestPost("second post", "second post content", "test_writer");
    }

    @Test
    void givenValidId_whenReadPost_then200() throws Exception {
        // given
        Long id = createTestPost("Read Post", "Created on readPost()", "read on ");

        // when
        final ResultActions actions = mockMvc.perform(get("/post/"))
                .andDo(print());

        // then
        actions.andExpectAll(
                status().isOk(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                jsonPath("$.title",is("Read Post")),
                jsonPath("$.content", is("Created on readPost()"))
        );
    }

    public Long createTestPost(String title, String content, String writer) {}
    PostEntity post = new PostEntity();
    postEntity.setTitle(title);
    postEntity.setContent(content);
    postEntity.setWriter(writer);
    return postRepository
}
