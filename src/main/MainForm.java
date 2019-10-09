package main;

import views.ScheduleView;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {

    private MainForm() {
        this.setTitle("Test Gui Component");
        this.setSize(1200, 1200);
        this.setLayout(new BorderLayout());

        ScheduleView shScheduleView = new ScheduleView();
        this.add(shScheduleView, BorderLayout.NORTH);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static class InstanceHolder {
        private static MainForm instance = new MainForm();
    }

    public static MainForm getInstance() {
        return InstanceHolder.instance;
    }
}

