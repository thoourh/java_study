package dev.thoourh.mybatis.mapper;

import dev.thoourh.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
