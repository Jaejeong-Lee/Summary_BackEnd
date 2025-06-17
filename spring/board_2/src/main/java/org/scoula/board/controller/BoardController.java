package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor // 생성자 자동 생성해줌.
public class BoardController {

    private final BoardService service;

    @GetMapping("list") // board/list
    public void list(Model model) {
        // Db 가지고 온 것 있어야 함.
        // Controller -> Service -> dao
        log.info("=====================> BoardController /list");
        model.addAttribute("list", service.getList());
        // 요청한 주소와 views의 호출할 파일명이 같으면 Return 안 해도 됨.

    }

    @GetMapping("/create") // board/create(입력화면 보여줘)
    public void create() {
        log.info("create");
    }

    @GetMapping("/update") // board/update(수정 전에 검색 먼저해서 한번 보여줘)
    public void update(@RequestParam("no") Long no, Model model) {
        log.info("/update");
        model.addAttribute("board", service.get(no));
        /* url에 따라 jsp 파일을 "board/update" 반환 */
    }

    @GetMapping("/get") // board/get
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get");
        model.addAttribute("board", service.get(no));
        /* url에 따라 jsp 파일을 "board/get" 반환 */
    }

    @PostMapping("/create") // board/create(입력한 거 db 처리해줘)
    public String create(BoardDTO board) {
        log.info("create: " + board);
        service.create(board);
        return "redirect:/board/list";
    }

    @PostMapping("/update") // board/update(수정한 거 db 처리해줘)
    public String update(BoardDTO board) {
        log.info("update:" + board);
        service.update(board);
        return "redirect:/board/list";
    }


    @PostMapping("/delete") // board/delete(삭제할 거 db 처리해줘)
    public String delete(@RequestParam("no") Long no) {

        log.info("delete..." + no);
        service.delete(no);
        return "redirect:/board/list";

    }

    /**
     * 파일 다운로드 처리
     * @param no 첨부파일 번호
     * @param response HTTP 응답 객체
     * @throws Exception
     */
    @GetMapping("/download/{no}")
    @ResponseBody  // View를 사용하지 않고 직접 응답 데이터 전송
    public void download(@PathVariable("no") Long no,
                         HttpServletResponse response) throws Exception {

        // 첨부파일 정보 조회
        BoardAttachmentVO attach = service.getAttachment(no);

        // 실제 파일 객체 생성
        // (java.io.File)
        File file = new File(attach.getPath());

        // 파일 다운로드 처리
        UploadFiles.download(response, file, attach.getFilename());
    }
}