import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LostItemApp extends JFrame {
    private LostItemManager manager = new LostItemManager();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> itemList = new JList<>(listModel);

    public LostItemApp() {
        setTitle("Aplikasi Kehilangan Barang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Panel input
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JTextField nameField = new JTextField();
        JTextField descField = new JTextField();
        JTextField locField = new JTextField();
        JTextField dateField = new JTextField();
        JButton addButton = new JButton("Tambah");

        inputPanel.add(new JLabel("Nama Barang:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Deskripsi:"));
        inputPanel.add(descField);
        inputPanel.add(new JLabel("Lokasi Hilang:"));
        inputPanel.add(locField);
        inputPanel.add(new JLabel("Tanggal (YYYY-MM-DD):"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel());
        inputPanel.add(addButton);

        // Panel daftar barang
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(new JLabel("Daftar Barang Hilang:"), BorderLayout.NORTH);
        listPanel.add(new JScrollPane(itemList), BorderLayout.CENTER);

        // Panel pencarian
        JPanel searchPanel = new JPanel(new BorderLayout());
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Cari");
        searchPanel.add(new JLabel("Cari Nama:"), BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        // Layout utama
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);

        // Event tambah barang
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String desc = descField.getText();
            String loc = locField.getText();
            String date = dateField.getText();
            if (!name.isEmpty() && !desc.isEmpty() && !loc.isEmpty() && !date.isEmpty()) {
                LostItem item = new LostItem(name, desc, loc, date);
                manager.addItem(item);
                listModel.addElement(item.toString());
                nameField.setText("");
                descField.setText("");
                locField.setText("");
                dateField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            }
        });

        // Event cari barang
        searchButton.addActionListener(e -> {
            String keyword = searchField.getText();
            listModel.clear();
            for (LostItem item : manager.searchByName(keyword)) {
                listModel.addElement(item.toString());
            }
        });

        setVisible(true);
    }
}
