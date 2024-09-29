//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package main;

import models.AbstractClass.LibraryItem;
import models.Items.Book.Book;
import models.Items.Book.EBook;
import models.Items.CD;
import models.Items.DVD;
import models.Items.Newspaper;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    // 도서관 항목(LibraryItem)을 생성하고 리스트로 반환하는 메서드
    public List<LibraryItem> createLibraryItems() {
        // LibraryItem을 저장할 리스트 생성
        List<LibraryItem> libraryItemList = new ArrayList<>();

        // Book 객체를 생성하고 리스트에 추가
        libraryItemList.add(new Book("자바 ORM 표준 JPA 프로그래밍", "김영한"));

        // DVD 객체를 생성하고 리스트에 추가
        libraryItemList.add(new DVD("범죄도시2", "이상용", 106));

        // CD 객체를 생성하고 리스트에 추가
        libraryItemList.add(new CD("How Sweet", "뉴진스 (NewJeans)"));

        // EBook 객체를 생성하고 리스트에 추가
        libraryItemList.add(new EBook("삼체", "류츠신"));

        // Newspaper 객체를 생성하고 리스트에 추가
        libraryItemList.add(new Newspaper("조선일보", "45년 만에 내 나라에서 ... 입양인의 첫 추석"));

        // 생성된 항목 리스트를 반환
        return libraryItemList;
    }
}
