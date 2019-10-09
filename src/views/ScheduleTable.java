package views;

import model.ScheduleTableModel;

import javax.swing.*;

public class ScheduleTable extends JTable {

    public ScheduleTable() {
        super(new ScheduleTableModel());

    }

}
