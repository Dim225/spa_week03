package com.example.spa_week03.entity;

import com.example.spa_week03.dto.MemoRequestDto;
import com.example.spa_week03.dto.MemosRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity

public class Memo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    public Memo(String title, String name, String content, String password) {
        this.title = title;
        this.name = name;
        this.content = content;
        this.password = password;
    }

    public Memo(MemoRequestDto memoRequestDto) {
        this.title = memoRequestDto.getTitle();
        this.name = memoRequestDto.getName();
        this.content = memoRequestDto.getContent();
        this.password = memoRequestDto.getPassword();
    }

    public Memo(MemosRequestDto memosRequestDto) {
        this.title = memosRequestDto.getTitle();
        this.name = memosRequestDto.getName();
        this.content = memosRequestDto.getContent();

    }
        public void update (MemoRequestDto memoRequestDto){
            this.title = memoRequestDto.getTitle();
            this.name = memoRequestDto.getName();
            this.content = memoRequestDto.getContent();
            this.password = memoRequestDto.getPassword();
    }
}