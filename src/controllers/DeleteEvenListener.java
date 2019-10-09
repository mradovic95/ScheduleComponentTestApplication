package controllers;

import model.ScheduleTableModel;
import views.ScheduleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEvenListener implements ActionListener {

    private ScheduleTableModel scheduleTableModel;
    private ScheduleView scheduleView;

    public DeleteEvenListener(ScheduleTableModel scheduleTableModel, ScheduleView scheduleView) {
        this.scheduleTableModel = scheduleTableModel;
        this.scheduleView = scheduleView;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        scheduleTableModel.removeRow(scheduleView.getScheduleTable().getSelectedRow());
    }

}
