package dev.yeowon.crud.post;

import java.util.List;

// 현재 레포랑 서비스랑 간단해서 큰 차이 없음
// 추후에 서비스가 단순히 CRUD 뿐만 아니라 create, read 를 할 때
// 현재 요청을 보낸 사용자가 PostRepository <- 얘를 읽을 권한이 있는지 없는지를 측정할 수 있음
// 나중에 이러한 부분들이 서비스에 구현이 되고, 데이터를 회수해서 확인하는 건 레포
// 정확히는 데이터 회수 자체를 하는 것은 레포가 함
// 회수된 데이터를 비교해서 사용 가능한 데이터인지 검증하는 것을 서비스가 함

public interface PostRepository {
    boolean save(PostDto dto);
    List<PostDto> findAll();
    PostDto findById(int id); //id 를 주면 postDto 가 돌아와야 한다.
    boolean update(int id, PostDto dto);
    boolean delete(int id);
}

// 이 interface 자체는 뒤 쪽에 어떤 식으로 구현이 되어 있든
// 어떠한 데이터, 특히 PostDto 를 다루기 위한 interface

