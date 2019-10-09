package views;

import controllers.AddNewEventListener;
import controllers.DeleteEvenListener;
import controllers.ExportDataActionListener;
import controllers.ImportDataActionListener;
import model.ScheduleTableModel;

import javax.swing.*;
import java.awt.*;

public class ScheduleView extends JPanel {

    private ScheduleTable scheduleTable;
    private JPanel editingPanel;

    private JButton addButton;
    private JButton deleteButton;
    private JButton showDetailsButton;
    private JButton importButton;
    private JButton exportButton;

    private JTextField titleField;
    private JTextField descriptionField;
    private JTextField startActivityField;
    private JTextField endActivityField;
    private JTextField typeField;

    public ScheduleView() {
        super();
        this.setSize(400, 400);

        scheduleTable = new ScheduleTable();
        this.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        this.add(scrollPane, BorderLayout.NORTH);

        this._initEditPanel();

    }

    private void _initEditPanel() {
        this.editingPanel = new JPanel();
        this.editingPanel.setLayout(new BorderLayout());

        this.addButton = new JButton("ADD");
        this.deleteButton = new JButton("DELETE");
        this.showDetailsButton = new JButton("SHOW DETAILS");
        this.importButton = new JButton("IMPORT");
        this.exportButton = new JButton("EXPORT");

        addButton.addActionListener(new AddNewEventListener((ScheduleTableModel) this.scheduleTable.getModel(), this));
        deleteButton.addActionListener(new DeleteEvenListener((ScheduleTableModel) this.scheduleTable.getModel(), this));
        importButton.addActionListener(new ImportDataActionListener((ScheduleTableModel) scheduleTable.getModel()));
        exportButton.addActionListener(new ExportDataActionListener((ScheduleTableModel) scheduleTable.getModel()));

        // Add panel for buttons
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.add(addButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(showDetailsButton);
        buttonsPanel.add(importButton);
        buttonsPanel.add(exportButton);

        JPanel fieldsPanel = new JPanel();
        this.titleField = new JTextField("Title", 20);
        this.descriptionField = new JTextField("Description", 20);
        this.startActivityField = new JTextField("Start activity", 20);
        this.endActivityField = new JTextField("End activity", 20);
        this.typeField = new JTextField("Type", 20);
        fieldsPanel.add(titleField);
        fieldsPanel.add(descriptionField);
        fieldsPanel.add(startActivityField);
        fieldsPanel.add(endActivityField);
        fieldsPanel.add(typeField);

        this.editingPanel.add(buttonsPanel, BorderLayout.CENTER);
        this.editingPanel.add(fieldsPanel, BorderLayout.SOUTH);
        this.add(editingPanel, BorderLayout.CENTER);
    }

    public ScheduleTable getScheduleTable() {
        return scheduleTable;
    }

    public void setScheduleTable(ScheduleTable scheduleTable) {
        this.scheduleTable = scheduleTable;
    }

    public JPanel getEditingPanel() {
        return editingPanel;
    }

    public void setEditingPanel(JPanel editingPanel) {
        this.editingPanel = editingPanel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getShowDetailsButton() {
        return showDetailsButton;
    }

    public void setShowDetailsButton(JButton showDetailsButton) {
        this.showDetailsButton = showDetailsButton;
    }

    public JButton getImportButton() {
        return importButton;
    }

    public void setImportButton(JButton importButton) {
        this.importButton = importButton;
    }

    public JButton getExportButton() {
        return exportButton;
    }

    public void setExportButton(JButton exportButton) {
        this.exportButton = exportButton;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public void setTitleField(JTextField titleField) {
        this.titleField = titleField;
    }

    public JTextField getDescriptionField() {
        return descriptionField;
    }

    public void setDescriptionField(JTextField descriptionField) {
        this.descriptionField = descriptionField;
    }

    public JTextField getStartActivityField() {
        return startActivityField;
    }

    public void setStartActivityField(JTextField startActivityField) {
        this.startActivityField = startActivityField;
    }

    public JTextField getEndActivityField() {
        return endActivityField;
    }

    public void setEndActivityField(JTextField endActivityField) {
        this.endActivityField = endActivityField;
    }

    public JTextField getTypeField() {
        return typeField;
    }

    public void setTypeField(JTextField typeField) {
        this.typeField = typeField;
    }

}
