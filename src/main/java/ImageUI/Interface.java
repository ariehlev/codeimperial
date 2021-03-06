package ImageUI;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Interface{

    protected static JPanel images;
    protected static JFrame frame;
    protected static JCheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10;
    protected static JTextField start_date,end_date,patient_id_window, other_scan_field, other_body_field;
    protected static JProgressBar progress_bar;

    public static void inter() { //creates the main interface of the program as well as the filter parameters
        frame = new JFrame("Image Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //checkboxes provide filter parameters
        checkBox1 = new JCheckBox("MRI");
        checkBox2 = new JCheckBox("CT");
        checkBox3 = new JCheckBox("ECG");
        checkBox4 = new JCheckBox("US");
        checkBox5 = new JCheckBox("X-ray");
        JLabel other_scan_label = new JLabel("Other:");
        other_scan_field = new JTextField();

        checkBox6 = new JCheckBox("Leg");
        checkBox7 = new JCheckBox("Head");
        checkBox8 = new JCheckBox("Arm");
        checkBox9 = new JCheckBox("Body");
        checkBox10 = new JCheckBox("Heart");
        JLabel other_body_label = new JLabel("Other:");
        other_body_field = new JTextField();


        JPanel filter = new JPanel();
        JPanel top_bar_logo = new JPanel();
        JPanel top_bar_title = new JPanel();
        JPanel top_bar_upload_button = new JPanel();
        images = new JPanel();

        JLabel logo = new JLabel();//multiple JLabels for adding logos, names of search parameters and examples
        JLabel title = new JLabel("Medical Image Database");
        title.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        JLabel scan = new JLabel("Scan Type");
        JLabel body = new JLabel("Body Part");
        JLabel date = new JLabel("Date");
        start_date = new JTextField();
        end_date = new JTextField();
        JLabel date_format_label_YYYY = new JLabel("YYYY-MM-DD");
        JLabel date_format_label =new JLabel("Date Format:");
        JLabel start =new JLabel("Start Date:");
        JLabel end =new JLabel("End Date:");
        JLabel patient_id = new JLabel("Patient ID");
        JLabel patient_id_format = new JLabel("Search for Individual Patient ID");
        JLabel patient_id_format_example = new JLabel("Example: 12345");
        JButton upload = new JButton("Upload");
        upload.addActionListener(new Uploader());
        upload.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        upload.setPreferredSize(new Dimension(125,45));
        upload.setFont(scan.getFont().deriveFont(20.0f));
        JButton search = new JButton("Search");
        patient_id_window = new JTextField();
        patient_id_window.setSize(100, 15);

        images.setAutoscrolls(true);
        images.setLayout(new BoxLayout(images, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(images);//adds the option of scrolling
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(250, 60, 1150, 740);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        top_bar_logo.setBounds(0, 0, 250, 60);
        top_bar_title.setBounds(250, 0, 900, 60);
        top_bar_upload_button.setBounds(1150, 0, 250, 60);

        top_bar_logo.setBorder(BorderFactory.createLineBorder(Color.black));
        top_bar_title.setBorder(BorderFactory.createLineBorder(Color.black));
        top_bar_upload_button.setBorder(BorderFactory.createLineBorder(Color.black));
        filter.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        progress_bar = new JProgressBar();
        progress_bar.setVisible(false);

        Image image = null; //loads the logo of Holloway Labs
        try {
            image= ImageIO.read(new File("../codeimperial/holloway_lab_logo.jpg"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        logo.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        assert image != null;
        logo.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(240, 45, Image.SCALE_SMOOTH)));

        search.addActionListener(new Searcher()); //adds an action listener to the search button which starts a search

        top_bar_logo.add(logo);
        top_bar_title.add(title);
        top_bar_upload_button.add(upload);
        scan.setFont(scan.getFont().deriveFont(18.0f));
        body.setFont(body.getFont().deriveFont(18.0f));
        date.setFont(body.getFont().deriveFont(18.0f));
        patient_id.setFont(body.getFont().deriveFont(18.0f));
        title.setFont(body.getFont().deriveFont(35.0f));

        GroupLayout layout = new GroupLayout(filter);
        filter.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scan)
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(body,checkBox1, LayoutStyle.ComponentPlacement.INDENT)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(checkBox1)
                                        .addComponent(checkBox2)
                                        .addComponent(checkBox3)
                                        .addComponent(checkBox4)
                                        .addComponent(checkBox5)
                                )
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(scan,other_scan_label, LayoutStyle.ComponentPlacement.INDENT)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(other_scan_label)
                                )
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(other_scan_field)
                                )
                        )
                        .addComponent(body)
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(body,checkBox4, LayoutStyle.ComponentPlacement.INDENT)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(checkBox6)
                                        .addComponent(checkBox7)
                                        .addComponent(checkBox8)
                                        .addComponent(checkBox9)
                                        .addComponent(checkBox10)
                                )
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(scan,other_scan_label, LayoutStyle.ComponentPlacement.INDENT)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(other_body_label)
                                )
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(other_body_field)
                                )
                        )
                        .addComponent(date)
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(date,start, LayoutStyle.ComponentPlacement.INDENT)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(date_format_label)
                                        .addComponent(start)
                                        .addComponent(end)
                                )
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(date_format_label_YYYY)
                                        .addComponent(start_date)
                                        .addComponent(end_date)
                                )
                        )
                        .addComponent(patient_id)
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(patient_id, patient_id_format, LayoutStyle.ComponentPlacement.INDENT)
                                .addComponent(patient_id_format)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(patient_id, patient_id_format_example, LayoutStyle.ComponentPlacement.INDENT)
                                .addComponent(patient_id_format_example)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(patient_id, patient_id_window, LayoutStyle.ComponentPlacement.INDENT)
                                .addComponent(patient_id_window)

                        )
                        .addComponent(search)
                        .addComponent(progress_bar)
                )


        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(scan)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkBox1)
                                        .addComponent(checkBox2)
                                        .addComponent(checkBox3)
                                        .addComponent(checkBox4)
                                        .addComponent(checkBox5)
                                )
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(other_scan_label)
                                .addComponent(other_scan_field)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(body)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkBox6)
                                        .addComponent(checkBox7)
                                        .addComponent(checkBox8)
                                        .addComponent(checkBox9)
                                        .addComponent(checkBox10)
                                )
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(other_body_label)
                                .addComponent(other_body_field)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(date)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(date_format_label)
                                        .addComponent(date_format_label_YYYY)
                                )
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(start)
                                        .addComponent(start_date)
                                )
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(end)
                                        .addComponent(end_date)
                                )
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(patient_id)
                                .addComponent(patient_id_format)
                                .addComponent(patient_id_format_example)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(patient_id_window)

                                )
                        )
                        .addComponent(search)
                        .addComponent(progress_bar)
                )


        );

        filter.setBounds(0,60,250,740);
        frame.add(filter);
        frame.add(top_bar_logo);
        frame.add(top_bar_title);
        frame.add(top_bar_upload_button);
        frame.add(scrollPane);
        frame.setSize(1415,810);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
