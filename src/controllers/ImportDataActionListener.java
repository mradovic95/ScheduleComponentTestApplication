package controllers;

import importexport.impl.SheduleImportExportJsonImplementation;
import main.MainForm;
import model.Event;
import model.Schedule;
import model.ScheduleTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ImportDataActionListener implements ActionListener {

    private ScheduleTableModel scheduleTableModel;
    private SheduleImportExportJsonImplementation exportJsonImplementation;

    public ImportDataActionListener(ScheduleTableModel scheduleTableModel) {
        this.scheduleTableModel = scheduleTableModel;
        this.exportJsonImplementation = new SheduleImportExportJsonImplementation();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(MainForm.getInstance());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            Schedule schedule = null;
            try {
                schedule = this.exportJsonImplementation.importSchedule(chooser.getSelectedFile());
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
