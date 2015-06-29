package de.podolak.netbeans.bootstrap;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.JTextComponent;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;

/**
 *
 * @author podolak
 */
public class GridCustomizer extends javax.swing.JPanel {

    private Dialog dialog = null;
    private DialogDescriptor descriptor = null;
    private boolean dialogOK = false;

    private final Grid grid;
    private final JTextComponent target;

    public GridCustomizer(Grid grid, JTextComponent target) {
        this.grid = grid;
        this.target = target;

        initComponents();
        columns.setModel(new javax.swing.DefaultComboBoxModel(GridBreakpoint.COLUMNS_PER_ROW));
        //columnSize.setModel(new javax.swing.DefaultComboBoxModel(GridBreakpoint.PREFIXES));
        columnSize.setModel(new javax.swing.DefaultComboBoxModel(GridBreakpoint.values()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rowsLabel = new javax.swing.JLabel();
        rows = new javax.swing.JTextField();
        columnsLabel = new javax.swing.JLabel();
        columns = new javax.swing.JComboBox();
        columnSizeLabel = new javax.swing.JLabel();
        columnSize = new javax.swing.JComboBox();

        rowsLabel.setText(org.openide.util.NbBundle.getMessage(GridCustomizer.class, "GridCustomizer.rowsLabel.text")); // NOI18N

        rows.setText(org.openide.util.NbBundle.getMessage(GridCustomizer.class, "GridCustomizer.rows.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(columnsLabel, org.openide.util.NbBundle.getMessage(GridCustomizer.class, "GridCustomizer.columnsLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(columnSizeLabel, org.openide.util.NbBundle.getMessage(GridCustomizer.class, "GridCustomizer.columnSizeLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(columnSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(columnsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rowsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rows)
                    .addComponent(columns, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(columnSize, 0, 348, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rowsLabel)
                    .addComponent(rows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(columnsLabel)
                    .addComponent(columns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(columnSizeLabel)
                    .addComponent(columnSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean showDialog() {
        dialogOK = false;
        descriptor = new DialogDescriptor(this, org.openide.util.NbBundle.getMessage(GridCustomizer.class, "GridCustomizer.DialogDescriptor.title"),
                true, DialogDescriptor.OK_CANCEL_OPTION, DialogDescriptor.OK_OPTION,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (descriptor.getValue().equals(DialogDescriptor.OK_OPTION)) {
                            evaluateInput();
                            dialogOK = true;
                        }
                        dialog.dispose();
                    }
                });
        dialog = DialogDisplayer.getDefault().createDialog(descriptor);
        dialog.setVisible(true);
        return dialogOK;
    }

    private void evaluateInput() {
        grid.setRows(Integer.parseInt(rows.getText()));
        grid.setColumns((Integer) columns.getSelectedItem());
        grid.setGridBreakpoint((GridBreakpoint) columnSize.getSelectedItem());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox columnSize;
    private javax.swing.JLabel columnSizeLabel;
    private javax.swing.JComboBox columns;
    private javax.swing.JLabel columnsLabel;
    private javax.swing.JTextField rows;
    private javax.swing.JLabel rowsLabel;
    // End of variables declaration//GEN-END:variables
}
