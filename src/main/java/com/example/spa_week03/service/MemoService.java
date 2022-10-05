package com.example.spa_week03.service;

import com.example.spa_week03.dto.MemoRequestDto;
import com.example.spa_week03.dto.MemosRequestDto;
import com.example.spa_week03.dto.PasswordRequestDto;
import com.example.spa_week03.entity.Memo;
import com.example.spa_week03.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo getPost(Long id) {
        return memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    @Transactional
    public Long updatePost(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }

    @Transactional
    public Boolean checkPassword(Long id, PasswordRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (memo.getPassword().equals(requestDto.getPassword())) {
            return true;
        } else {
            return false;
        }
    }


    @Transactional
    public Long deletePost(Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
