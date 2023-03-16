import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WebScraperGui extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField link;
    private JButton scrapeButton;
    private JLabel statusLabel;

    public WebScraperGui() {
        setTitle("Web Scraper");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
        add(mainPanel);

        JLabel titleLabel = new JLabel("Web Scraper_");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 44));
        titleLabel.setAlignmentX(LEFT_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel label = new JLabel("Enter URL:");
        label.setFont(new Font("SansSerif", Font.PLAIN, 40));
        label.setAlignmentX(LEFT_ALIGNMENT);
        mainPanel.add(label);

        link = new JTextField();
        link.setFont(new Font("SansSerif", Font.PLAIN, 40));
        link.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        link.setAlignmentX(LEFT_ALIGNMENT);
        mainPanel.add(link);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        scrapeButton = new JButton("Scrape");
        scrapeButton.setFont(new Font("SansSerif", Font.PLAIN, 40));
        scrapeButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        scrapeButton.setAlignmentX(LEFT_ALIGNMENT);
        mainPanel.add(scrapeButton);
        scrapeButton.addActionListener(this);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 38));
        statusLabel.setAlignmentX(LEFT_ALIGNMENT);
        statusLabel.setForeground(Color.RED);
        mainPanel.add(statusLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        WebScraperGui gui = new WebScraperGui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == scrapeButton) {
            String urlText = link.getText();
            if (urlText != null && !urlText.isEmpty()) {
                try {
                    URL url = new URL(urlText);
                    WebScraper.main(new String[] { urlText });
                    statusLabel.setText("Scraping...");
                    statusLabel.setForeground(Color.BLUE);
                } catch (Exception ex) {
                    statusLabel.setText("Invalid URL");
                    statusLabel.setForeground(Color.RED);
                }
            } else {
                statusLabel.setText("Please enter a URL");
                statusLabel.setForeground(Color.RED);
            }
        }
    }
}
