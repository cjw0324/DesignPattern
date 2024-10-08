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
    private JButton[] selectCatDogRabbit = new JButton[3]; //cat, dog, rabbit
    private JButton[] buttons = new JButton[4];  // 1개의 버튼 hat,ball,toy,clear
    private Doll doll;  // 인형 객체
    private Doll initialDoll; //초기 객체
    private JPanel displayPanel;  // 인형을 표시하는 패널

    public PaperDollApp() {

        // 초기 GUI 설정
        setTitle("Paper Doll App");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // displayPanel 설정
        displayPanel = new JPanel(new BorderLayout());
        doll = new CatDoll();  // 기본 인형 설정
        initialDoll = doll;
        displayPanel.add(doll);  // 기본 인형을 패널에 추가

        // buttonPanel 설정
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttons[0] = new JButton("Hat");
        buttons[1] = new JButton("Ball");
        buttons[2] = new JButton("Toy");
        buttons[3] = new JButton("clear");

        JPanel animalButtonPanel = new JPanel(new GridLayout(1, 3));
        selectCatDogRabbit[0] = new JButton("CAT");
        selectCatDogRabbit[1] = new JButton("DOG");
        selectCatDogRabbit[2] = new JButton("RABBIT");

        // 버튼에 액션 리스너 추가
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        for (JButton jButton : selectCatDogRabbit) {
            jButton.addActionListener(this);
            buttonPanel.add(jButton);
        }
        // 버튼 패널을 displayPanel에 추가
        displayPanel.add(buttonPanel, BorderLayout.SOUTH);
        displayPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(displayPanel);  // JFrame에 displayPanel 추가
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 기존 인형 제거
        displayPanel.remove(doll);

        if (e.getSource() == selectCatDogRabbit[0]) {
            doll = new CatDoll();
            initialDoll = doll;
        } else if (e.getSource() == selectCatDogRabbit[1]) {  // Dog 인형 선택
            doll = new DogDoll();
            initialDoll = doll;
        } else if (e.getSource() == selectCatDogRabbit[2]) {  // Rabbit 인형 선택
            doll = new RabbitDoll();
            initialDoll = doll;
        }


        // 버튼에 따른 장식 추가
        if (e.getSource() == buttons[0]) {
            doll = new HatDecorator(doll);  // 모자 장식 추가
        } else if (e.getSource() == buttons[1]) {
            doll = new BallDecorator(doll);  // 공 장식 추가
        } else if (e.getSource() == buttons[2]) {
            doll = new ToyDecorator(doll);  // 장난감 장식 추가
        }else if (e.getSource() == buttons[3]) {
            Doll cleanDoll = checkInstance(initialDoll);
            doll = cleanDoll;
        }

        // 새로운 인형을 패널에 추가
        displayPanel.add(doll, BorderLayout.CENTER);

        // UI를 다시 그리기
        displayPanel.revalidate();
        displayPanel.repaint();
    }

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
