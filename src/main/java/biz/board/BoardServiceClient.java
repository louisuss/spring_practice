package biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");
        BoardService boardService = (BoardService)container.getBean("boardService");

        BoardVO vo = new BoardVO();
        vo.setTitle("Temporary Title");
        vo.setWriter("KIM");
        vo.setContent("Temporary Content");
        boardService.insertBoard(vo);
        List<BoardVO> boardList = boardService.getBoardList(vo);
        for (BoardVO boardVO : boardList) {
            System.out.println(boardVO.toString());
        }
        container.close();
    }
}
