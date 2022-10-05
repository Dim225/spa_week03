package com.example.spa_week03.controller;

import com.example.spa_week03.dto.MemoRequestDto;
import com.example.spa_week03.dto.PasswordRequestDto;
import com.example.spa_week03.entity.Memo;
import com.example.spa_week03.repository.MemoRepository;
import com.example.spa_week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    // 전체 게시글 불러오기
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    // 게시글 작성하기
    @PostMapping("/api/memos")
    public Memo createPost(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    // 상세 게시글 불러오기
    @GetMapping("/api/post/{id}")
    public Memo getPost(@PathVariable Long id) {
        return memoService.getPost(id);
    }

    // 게시글 수정을 위한 비밀번호 확인
    @PostMapping("/ape/post/{id}")
    public Boolean checkPassword(@PathVariable Long id, @RequestBody PasswordRequestDto requestDto) {
        return memoService.checkPassword(id, requestDto);
    }

    // 게시글 수정하기
    @PutMapping("/api/memos/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.updatePost(id, requestDto);
    }

    // 게시글 삭제하기
    @DeleteMapping("/api/post/{id}")
    public Long deletePost(@PathVariable Long id) {
        return memoService.deletePost(id);
    }
}
