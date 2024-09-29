//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package services;

import models.AbstractClass.LibraryItem;

import java.util.HashMap;
import java.util.Map;

public class CheckoutManager {
    // 각 LibraryItem에 대해 대여 상태를 저장하는 맵 (항목과 대여 여부를 매핑)
    private Map<LibraryItem, Boolean> checkoutStatus = new HashMap<>();

    // 항목을 대여하는 메서드
    public void checkOut(LibraryItem item) {
        // 대여 상태를 true로 설정하고 출력
        checkoutStatus.put(item, true);
        System.out.println("[CHECK OUT] " + item.getClass().getSimpleName().toUpperCase()
                + " | TITLE : " + item.getTitle());
    }

    // 항목을 반납하는 메서드
    public void returnItem(LibraryItem item) {
        // 반납 상태를 false로 설정하고 출력
        checkoutStatus.put(item, false);
        System.out.println("[RETURN] " + item.getClass().getSimpleName().toUpperCase()
                + " | TITLE : " + item.getTitle());
    }

    // 항목이 대여 중인지 확인하는 메서드
    public Boolean isCheckedOut(LibraryItem item) {
        // 대여 여부를 체크. 만약 항목이 대여된 적이 없으면 false를 반환
        return checkoutStatus.getOrDefault(item, false);
        // 빌린 적이 없는 item을 get 할 시 null point exception 발생 방지를 위해
        // default 값을 false로 설정해 줌.
    }
}
