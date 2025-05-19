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
        setSize(560, 440);
        setLocationRelativeTo(null);

        // Set global font
        Font mainFont = new Font("Segoe UI", Font.PLAIN, 15);
        UIManager.put("Label.font", mainFont);
        UIManager.put("Button.font", mainFont);
        UIManager.put("TextField.font", mainFont);
        UIManager.put("List.font", mainFont);

        // Panel input
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Barang Hilang"));
        inputPanel.setBackground(new Color(245, 250, 255));
        JTextField nameField = new JTextField();
        JTextField descField = new JTextField();
        JTextField locField = new JTextField();
        JTextField dateField = new JTextField();
        JButton addButton = new JButton("Tambah");
        addButton.setBackground(new Color(0, 123, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);

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
        listPanel.setBorder(BorderFactory.createTitledBorder("Daftar Barang Hilang"));
        listPanel.setBackground(new Color(240, 248, 255));
        itemList.setSelectionBackground(new Color(0, 123, 255));
        itemList.setSelectionForeground(Color.WHITE);
        itemList.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        JScrollPane scrollPane = new JScrollPane(itemList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        listPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel pencarian
        JPanel searchPanel = new JPanel(new BorderLayout(10, 0));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        searchPanel.setBackground(new Color(245, 250, 255));
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Cari");
        searchButton.setBackground(new Color(40, 167, 69));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchPanel.add(new JLabel("Cari Nama:"), BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        // Layout utama
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(230, 240, 250));
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(listPanel, BorderLayout.CENTER);
        mainPanel.add(searchPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);

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
            for (Item item : manager.searchByName(keyword)) {
                listModel.addElement(item.toString());
            }
        });

        setVisible(true);
    }
}
