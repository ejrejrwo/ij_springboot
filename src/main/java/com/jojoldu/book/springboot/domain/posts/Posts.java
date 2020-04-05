package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 롬복의 어노테이션
@NoArgsConstructor // 롬복의 어노테이션 - 기본 생성자 자동 추가 ex) public Posts() { }
@Entity // JPA 어노테이션 테이블과 링크될 클래스임을 나타냄
public class Posts {

    @Id // 해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙을 나타냄
    private Long id;

    /*
        @Column 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됩니다.
        사용이유 : 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
        ex) 기본값 varchar(255) 사이즈를 늘릴때, 타입을 TEXT로 변경 등
    */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 롬복의 어노테이션 - 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
