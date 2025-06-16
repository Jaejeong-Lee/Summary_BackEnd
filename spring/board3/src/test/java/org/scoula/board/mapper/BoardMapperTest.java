package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ContextConfiguration(classes = RootConfig.class)
@ExtendWith(SpringExtension.class)
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    void getList() {
        List<BoardVO> list = mapper.getList();
        for (int i = 0; i < list.size(); i++) {
            log.info(list.get(i));
        }
    }


    @Test
    void get() {
        // 존재하는 게시물 번호로 테스트
        BoardVO board = mapper.get(1L);
        log.info(board);
    }

    @Test
    void create() {
        BoardVO board = new BoardVO();

        board.setTitle("New 작성하는 글");
        board.setContent("new 작성하는 내용");
        board.setWriter("new user");

        mapper.create(board);
        log.info(board);

    }

    @Test
    void update() {
        BoardVO board = new BoardVO();

        board.setNo(4L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("User04");

        int count = mapper.update(board);

        assertEquals(1, count);
        log.info("Update Result Int : {}",count);

    }

    @Test
    void delete() {
        int count = mapper.delete(4L);

        assertEquals(1, count);
        log.info("Delete Result Int : { " + count + "}");

    }
}