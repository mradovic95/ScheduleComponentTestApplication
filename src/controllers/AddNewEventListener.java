package controllers;

import model.ScheduleTableModel;
import views.ScheduleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class AddNewEventListener implements ActionListener {

    private ScheduleTableModel scheduleTableModel;
    private ScheduleView scheduleView;

    public AddNewEventListener(ScheduleTableModel scheduleTableModel, ScheduleView scheduleView) {
        this.scheduleTableModel = scheduleTableModel;
        this.scheduleView = scheduleView;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String title = scheduleView.getTitleField().getText();
        String description = scheduleView.getDescriptionField().getText();
        LocalDateTime startActivity = LocalDateTime.parse(scheduleView.getStartActivityField().getText());
        LocalDateTime endActivity = LocalDateTime.parse(scheduleView.getEndActivityField().getText());
        String type = scheduleView.getTypeField().getText();
        scheduleTableModel.addRow(new Object[]{title, description, startActivity, endActivity, type});
    }

}
