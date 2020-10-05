package controllers;

import main.MainForm;
import model.ScheduleTableModel;
import service.ScheduleService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ExportDataActionListener implements ActionListener {

    private ScheduleTableModel scheduleTableModel;
    private ScheduleService scheduleService;

    public ExportDataActionListener(ScheduleTableModel scheduleTableModel, ScheduleService scheduleService) {
        this.scheduleTableModel = scheduleTableModel;
        this.scheduleService = scheduleService;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(MainForm.getInstance());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                scheduleService.saveSchedule(chooser.getSelectedFile(),
                        this.scheduleTableModel.getSchedule());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
