//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package main;

import models.AbstractClass.LibraryItem;
import services.CheckoutManager;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // LibraryItem을 저장할 리스트
    private List<LibraryItem> items = new ArrayList<>();

    // 항목의 대여 상태를 관리하는 CheckoutManager 객체
    private CheckoutManager checkoutManager = new CheckoutManager();

    // 도서관에 항목 추가
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    // 항목을 대여하는 메서드
    public void checkOut(LibraryItem item) {
        // 항목이 대여 중이 아닌 경우에만 대여 가능
        if (!(checkoutManager.isCheckedOut(item))) {
            checkoutManager.checkOut(item);  // 항목 대여 처리
        } else {
            // 대여 중인 항목이면 대여 불가 메시지 출력
            System.out.println("[Not Possible] " + item.getTitle() + " is being rented.");
        }
    }

    // 항목을 반납하는 메서드
    public void returnItem(LibraryItem item) {
        // 항목이 대여 중인 경우에만 반납 가능
        if (checkoutManager.isCheckedOut(item)) {
            checkoutManager.returnItem(item);  // 항목 반납 처리
        } else {
            // 대여 중이지 않은 항목이면 반납 불가 메시지 출력
            System.out.println("[Not Possible] " + item.getTitle() + " is not on rent.");
        }
    }

    // 도서관에 있는 모든 항목의 정보를 출력하는 메서드
    public void generateReport() {
        System.out.println("[모든 Library Item 출력]");
        int index = 1;
        // 모든 항목에 대해 보고서를 생성하고 출력
        for (LibraryItem item : items) {
            System.out.printf("[%d] ", index);  // 항목 번호 출력
            item.generateReport();  // 각 항목의 상세 정보 출력
            index++;
        }
    }
}
