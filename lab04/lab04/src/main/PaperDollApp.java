//Lab04, 자바프로그래밍2, 1분반, 2024-10-08, 최재우
package main;

import decorators.*;
import dolls.CatDoll;
import dolls.DogDoll;
import dolls.RabbitDoll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaperDollApp extends JFrame implements ActionListener {
    private JButton[] selectCatDogRabbit = new JButton[3]; // CAT, DOG, RABBIT 버튼 배열
    private JButton[] buttons = new JButton[5];  // Hat, Ball, Toy, Pet Food, Clear 버튼 배열
    private Doll doll;  // 현재 선택된 인형 객체
    private Doll initialDoll; // 초기 인형 객체 (Clear 시 기본 인형으로 되돌리기 위해 사용)
    private JPanel displayPanel;  // 인형을 표시하는 패널

    public PaperDollApp() {

        // 초기 GUI 설정
        setTitle("Paper Doll App");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // displayPanel 설정
        displayPanel = new JPanel(new BorderLayout());
        doll = new CatDoll();  // 기본 인형 설정 (처음엔 CatDoll)
        initialDoll = doll;  // 초기 인형을 CatDoll로 설정
        displayPanel.add(doll);  // 기본 인형을 패널에 추가

        // buttonPanel 설정
        JPanel buttonPanel = new JPanel(new GridLayout(1, 8));  // 장식 버튼 4개 (Hat, Ball, Toy, Clear)
        buttons[0] = new JButton("Hat");
        buttons[1] = new JButton("Ball");
        buttons[2] = new JButton("Toy");
        buttons[3] = new JButton("PetFood");
        buttons[4] = new JButton("Clear");

        // Animal 선택 버튼 패널 설정 (CAT, DOG, RABBIT)
        selectCatDogRabbit[0] = new JButton("CAT");
        selectCatDogRabbit[1] = new JButton("DOG");
        selectCatDogRabbit[2] = new JButton("RABBIT");

        // 장식 버튼에 액션 리스너 추가
        for(JButton jButton : buttons){
            jButton.addActionListener(this);
            buttonPanel.add(jButton);
        }

        // 동물 선택 버튼에 액션 리스너 추가
        for (JButton jButton : selectCatDogRabbit) {
            jButton.addActionListener(this);
            buttonPanel.add(jButton);
        }

        // 버튼 패널을 displayPanel에 추가
        displayPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(displayPanel);  // JFrame에 displayPanel 추가
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 기존 인형 제거
        displayPanel.remove(doll);

        // 동물 선택 버튼 클릭 처리
        if (e.getSource() == selectCatDogRabbit[0]) {
            doll = new CatDoll();  // CatDoll 선택
            initialDoll = doll;  // 초기 인형 설정
        } else if (e.getSource() == selectCatDogRabbit[1]) {  // Dog 인형 선택
            doll = new DogDoll();
            initialDoll = doll;
        } else if (e.getSource() == selectCatDogRabbit[2]) {  // Rabbit 인형 선택
            doll = new RabbitDoll();
            initialDoll = doll;
        }

        // 장식 버튼 클릭 처리
        if (e.getSource() == buttons[0]) {
            doll = new HatDecorator(doll);  // Hat 장식 추가
        } else if (e.getSource() == buttons[1]) {
            doll = new BallDecorator(doll);  // Ball 장식 추가
        } else if (e.getSource() == buttons[2]) {
            doll = new ToyDecorator(doll);  // Toy 장식 추가
        } else if (e.getSource() == buttons[3]) {
            doll = new PetFoodDecorator(doll);  // Pet Food 장식 추가
        } else if (e.getSource() == buttons[4]) {  // Clear 버튼 클릭 시
            Doll cleanDoll = checkInstance(initialDoll);  // 현재 인형을 초기 상태로 되돌림
            doll = cleanDoll;
        }

        // 새로운 인형을 패널에 추가
        displayPanel.add(doll, BorderLayout.CENTER);

        // UI를 다시 그리기
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    // 초기 인형 상태로 되돌리기 위한 메서드 (Cat, Dog, Rabbit 중 하나로 설정)
    public Doll checkInstance(Doll object) {
        if (object instanceof CatDoll) {
            return new CatDoll();
        } else if (object instanceof DogDoll) {
            return new DogDoll();
        } else {
            return new RabbitDoll();
        }
    }

}
