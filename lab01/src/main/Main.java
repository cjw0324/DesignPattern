//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package main;

import models.AbstractClass.LibraryItem;
import models.Items.Book.EBook;
import models.Items.DVD;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Library 객체 생성
        Library library = new Library();

        // LibraryManager 객체 생성
        LibraryManager manager = new LibraryManager();

        // LibraryManager를 통해 LibraryItem 리스트 생성
        List<LibraryItem> libraryItemList = manager.createLibraryItems();

        // 등록: 모든 항목을 Library에 추가
        for (LibraryItem libraryItem : libraryItemList) {
            library.addItem(libraryItem);  // 각 항목을 도서관에 등록
        }

        // 모든 항목에 대해 첫 번째 체크아웃 시도
        for (LibraryItem item : libraryItemList) {
            library.checkOut(item);  // 각 항목을 체크아웃
        }

        // 모든 항목에 대해 두 번째 체크아웃 시도 (이미 체크아웃된 항목이므로 실패 메시지가 출력됨)
        for (LibraryItem item : libraryItemList) {
            library.checkOut(item);  // 이미 대여된 항목에 대한 체크아웃 시도
        }

        // 리포트 생성: 도서관에 있는 모든 항목에 대한 정보 출력
        library.generateReport();

        // 추가 기능: Ebook 다운로드 및 DVD 스트리밍
        for (LibraryItem item : libraryItemList) {
            if (item instanceof EBook) {
                ((EBook) item).download();  // EBook 항목에 대해 다운로드 수행
            }
            if (item instanceof DVD) {
                ((DVD) item).stream();  // DVD 항목에 대해 스트리밍 수행
            }
        }

        // 모든 항목에 대해 첫 번째 항목 반환 시도
        for (LibraryItem item : libraryItemList) {
            library.returnItem(item);  // 각 항목을 반환
        }

        // 모든 항목에 대해 두 번째 항목 반환 시도 (이미 반환된 항목이므로 실패 메시지가 출력됨)
        for (LibraryItem item : libraryItemList) {
            library.returnItem(item);  // 이미 반환된 항목에 대한 반환 시도
        }
    }
}
