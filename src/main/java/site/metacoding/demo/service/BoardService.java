package site.metacoding.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.demo.domain.Board;
import site.metacoding.demo.domain.BoardRepository;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }
}
