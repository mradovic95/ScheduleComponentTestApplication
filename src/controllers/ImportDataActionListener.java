package controllers;

import main.MainForm;
import model.Event;
import model.Schedule;
import model.ScheduleTableModel;
import service.ScheduleService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ImportDataActionListener implements ActionListener {

    private ScheduleTableModel scheduleTableModel;
    private ScheduleService scheduleService;

    public ImportDataActionListener(ScheduleTableModel scheduleTableModel, ScheduleService scheduleService) {
        this.scheduleTableModel = scheduleTableModel;
        this.scheduleService = scheduleService;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(MainForm.getInstance());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            Schedule schedule = null;
            try {
                schedule = this.scheduleService.loadSchedule(chooser.getSelectedFile());
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Event event : schedule.getEvents()) {
                this.scheduleTableModel.addRow(new Object[]{event.getTitle(), event.getDescription(),
                        event.getStartActivity(), event.getEndActivity(), event.getClass().getSimpleName()});
            }
        }
    }

}
