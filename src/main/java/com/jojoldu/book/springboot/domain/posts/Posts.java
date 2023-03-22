package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// lombok 어노테이션
@Getter 
@NoArgsConstructor
// jpa 어노테이션 (주요 어노테이션이기 때문에 클래스에 가까이 둠 -> 코틀린 등 새 언어로 전환 시 위에있는 롬복만 삭제하면 됨)
// 테이블과 링크 될 클래스 임을 나타냄
@Entity 
public class Posts {
    @Id // 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타내고 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }



}
