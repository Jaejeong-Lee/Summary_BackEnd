package org.scoula.board.mapper;

import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
        List<BoardVO> getList();

        public BoardVO get(long no);

        public int create(BoardVO board);

        public int update(BoardVO board);

        public int delete(long no);
}
