import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

public class WebScraperGui extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField link;
    private JButton scrapeButton;

    public WebScraperGui() {
        setTitle("Web Scraper");
        setSize(1800, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("Enter URL: ");
        label.setBounds(20, 20, 80, 25);
        //label.setFont(new Font("Serif", Font.PLAIN, 14));
        /////////////find a way to scale the window properly 
        add(label);

        link = new JTextField();
        link.setBounds(100, 20, 300, 25);
        add(link);

        scrapeButton = new JButton("Scrape");
        scrapeButton.setBounds(20, 60, 80, 25);
        add(scrapeButton);
        scrapeButton.addActionListener(this);
    }

    public static void main(String[] args) {
        WebScraperGui gui = new WebScraperGui();
        gui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == scrapeButton) {
            String urlText = link.getText();
            if (urlText != null && !urlText.isEmpty()) {
                try {
                    URL url = new URL(urlText);
                    WebScraper.main(new String[] { urlText });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
