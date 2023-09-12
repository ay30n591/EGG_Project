package com.example.Final_Project.Repository;

import com.example.Final_Project.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//  엔티티와 관련된 기본적인 CRUD 작업을 자동으로 수행
// JpaRepository를 상속받아 Article 엔티티와 상호작용할 Repository를 정의
public interface ArticleRepository extends JpaRepository<Article, String> {

    // 여러 검색 조건을 지원하기위해 @Query 어노테이션을 사용하여 사용자 정의 쿼리 작성
    @Query("SELECT a FROM Article a WHERE " +
            "(:searchkeyword IS NULL OR " +
            "a.abstract_en LIKE %:searchkeyword% OR " +
            "a.abstract_ko LIKE %:searchkeyword% OR " +
            "a.author_name LIKE %:searchkeyword% OR " +
            "a.institution LIKE %:searchkeyword% OR " +
            "a.journal_name LIKE %:searchkeyword% OR " +
            "a.keyword LIKE %:searchkeyword% OR " +
            "a.major LIKE %:searchkeyword% OR " +
            "a.title_en LIKE %:searchkeyword% OR " +
            "a.title_ko LIKE %:searchkeyword%)")

    // "findByKeyword" 메서드는 JPA 쿼리 메서드로, 데이터베이스에서 키워드를 포함하는 항목을 대소문자 구분 없이 검색하기 위해 사용
    List<Article> findByKeyword(String searchkeyword);
}
