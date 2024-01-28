package works.mgr.visual;

import javax.swing.*;
import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;
import works.mgr.activities.*;

class Logger {
    public static Color infoColor = new Color(72, 226, 29);
    public static Color warningColor = new Color(226, 217, 29);
    public static Color errorColor = new Color(225, 52, 29);
    public static int currentLine = 1;

    public static void log (int level, String message, JPanel logField) {
        String messageFormat = "  %s [%s] %s\n\n";
        String levelClass = "";
        Color color = null;

        if (level == 1) {
            levelClass = "INF";
            color = infoColor;

        } else if (level == 2) {
            levelClass = "WRN";
            color = warningColor;

        } else if (level == 3) {
            levelClass = "ERR";
            color = errorColor;
        }

        JLabel logText = new JLabel();
        logText.setText(String.format(messageFormat, String.valueOf(currentLine), levelClass, message));
        logText.setBackground(Manager.buttonPanelColor);
        logText.setForeground(color);
        logField.add(logText);
        logField.add(Box.createRigidArea(new Dimension(0, 3)));
        logField.repaint();
        logField.revalidate();
        currentLine++;
    }
}

public class Manager extends JFrame {
    private static final String windowTitle = "Java Works Manager";
    private static final Image windowIcon = new ImageIcon("target/classes/JWM.png").getImage();

    private static final Font buttonFont = new Font("Bahnschrift", 1, 14);
    private static final Color buttonBackground = new Color(43, 44, 54);
    private static final Color buttonForeground = new Color(189, 147, 249);
    private static final Dimension buttonDimension = new Dimension(155, 18);

    private static final Color homeColor = new Color(40, 42, 54);
    private static final Color headerColor = new Color(30, 32, 34);
    public static final Color buttonPanelColor = new Color(33, 34, 44);

    private JPanel actButton1;
    private JPanel actButton2;
    private JPanel actButton3;
    private JPanel actButton4;
    private JPanel actButton5;
    private JPanel actButton6;
    private JPanel actButton7;
    private JLabel actLabel1;
    private JLabel actLabel2;
    private JLabel actLabel3;
    private JLabel actLabel4;
    private JLabel actLabel5;
    private JLabel actLabel6;
    private JLabel actLabel7;
    private JLabel authorLabel1;
    private JPanel buttonPanel;
    private JLabel headerLabel;
    private JPanel headerPanel;
    private JPanel homePanel;
    private JPanel logField;
    private JLabel logLabel;
    private JScrollPane logPane;

    public Manager () {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(windowTitle);
        setIconImage(windowIcon);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setVisible(true);

        initComponents();

        UIManager.put("Tooltip.background", buttonBackground);
        UIManager.put("Tooltip.foreground", headerColor);
        UIManager.put("OptionPane.background", homeColor);
        UIManager.put("OptionPane.messageForeground", new Color(242,242,242));
        UIManager.put("Panel.background", homeColor);
        UIManager.put("Button.background", buttonBackground);
        UIManager.put("Button.foreground", new Color(242,242,242));
        UIManager.put("OptionPane.cancelButtonText", "Close");
        UIManager.put("OptionPane.okButtonText", "Okay");
        UIManager.put("Button.focus", buttonBackground);
    }

    private void initHomePanel() {
        homePanel.setBackground(homeColor);

        headerPanel.setBackground(headerColor);

        headerLabel.setFont(new Font("Monospaced", 1, 24));
        headerLabel.setForeground(new Color(98, 114, 164));
        headerLabel.setText(windowTitle);

        GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        authorLabel1.setFont(new Font("Monospaced", 3, 13));
        authorLabel1.setForeground(new Color(242, 242, 242));
        authorLabel1.setText("Author: Janver Flores");

        logLabel.setFont(new Font("Monospaced", 1, 13));
        logLabel.setForeground(new Color(242, 242, 242));
        logLabel.setText("Log History:");
        logLabel.setToolTipText("Click to clear the log history");
        logLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked (MouseEvent evt) {
                logLabelClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                logLabelEntered(evt);
            }
        });

        logField.setBackground(new Color(33, 34, 44));
        logField.setForeground(new Color(200, 200, 200));
        logField.setLayout(new BoxLayout(logField, BoxLayout.Y_AXIS));
        logPane.setViewportView(logField);
    
        GroupLayout homePanelLayout = new GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(authorLabel1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logLabel))
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logPane, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(authorLabel1)
                .addGap(42, 42, 42)
                .addComponent(logLabel)
                .addGap(12, 12, 12)
                .addComponent(logPane, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(homePanel, BorderLayout.CENTER);
    }

    private void initButtonPanel () {
        buttonPanel.setBackground(buttonPanelColor);
        buttonPanel.setPreferredSize(new Dimension(180, 395));

        FlowLayout buttonPanelLayout = new FlowLayout(FlowLayout.LEADING, 0, 22);
        buttonPanel.setLayout(buttonPanelLayout);

        buttonPanel.add(actButton1);
        buttonPanel.add(actButton2);
        buttonPanel.add(actButton3);
        buttonPanel.add(actButton4);
        buttonPanel.add(actButton5);
        buttonPanel.add(actButton6);
        buttonPanel.add(actButton7);

        getContentPane().add(buttonPanel, BorderLayout.LINE_START);
    }
    
    private void initButtons () {
        actButton1.setBackground(buttonBackground);
        actButton1.setLayout(new FlowLayout());
        actButton1.setToolTipText("Compute for the fibonacci series of a number");
        actButton1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                actButton1MouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt, actButton1);
            }
            public void mouseExited(MouseEvent evt) {
                buttonMouseExited(evt, actButton1, buttonBackground);
            }
        });

        actLabel1.setFont(buttonFont);
        actLabel1.setForeground(buttonForeground);
        actLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        actLabel1.setText("Fibonacci Sequence");
        actLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        actLabel1.setPreferredSize(buttonDimension);
        actButton1.add(actLabel1);

        actButton2.setBackground(buttonBackground);
        actButton2.setLayout(new FlowLayout());
        actButton2.setToolTipText("Compute for the sum of alternating 10th intervals of the range of a number");
        actButton2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                actButton2MouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt, actButton2);
            }
            public void mouseExited(MouseEvent evt) {
                buttonMouseExited(evt, actButton2, buttonBackground);
            }
        });

        actLabel2.setFont(buttonFont);
        actLabel2.setForeground(buttonForeground);
        actLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        actLabel2.setText("Alternate Adding");
        actLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
        actLabel2.setPreferredSize(buttonDimension);
        actButton2.add(actLabel2);

        actButton3.setBackground(buttonBackground);
        actButton3.setLayout(new FlowLayout());
        actButton3.setToolTipText("Play a game of Rock, Paper, Scissors with someone");
        actButton3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                actButton3MouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt, actButton3);
            }
            public void mouseExited(MouseEvent evt) {
                buttonMouseExited(evt, actButton3, buttonBackground);
            }
        });

        actLabel3.setFont(buttonFont);
        actLabel3.setForeground(buttonForeground);
        actLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        actLabel3.setText("RPS Game");
        actLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
        actLabel3.setPreferredSize(buttonDimension);
        actButton3.add(actLabel3);

        actButton4.setBackground(buttonBackground);
        actButton4.setLayout(new FlowLayout());
        actButton4.setToolTipText("Calculate the highest value among three integers");
        actButton4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                actButton4MouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt, actButton4);
            }
            public void mouseExited(MouseEvent evt) {
                buttonMouseExited(evt, actButton4, buttonBackground);
            }
        });

        actLabel4.setFont(buttonFont);
        actLabel4.setForeground(buttonForeground);
        actLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        actLabel4.setText("Input Comparison");
        actLabel4.setHorizontalTextPosition(SwingConstants.CENTER);
        actLabel4.setPreferredSize(buttonDimension);
        actButton4.add(actLabel4);

        actButton5.setBackground(buttonBackground);
        actButton5.setLayout(new FlowLayout());
        actButton5.setToolTipText("Calculate the highest and lowest value in an 2-D integer matrix");
        actButton5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                actButton5MouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt, actButton5);
            }
            public void mouseExited(MouseEvent evt) {
                buttonMouseExited(evt, actButton5, buttonBackground);
            }
        });

        actLabel5.setFont(buttonFont);
        actLabel5.setForeground(buttonForeground);
        actLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        actLabel5.setText("Highest-Lowest");
        actLabel5.setHorizontalTextPosition(SwingConstants.CENTER);
        actLabel5.setPreferredSize(buttonDimension);
        actButton5.add(actLabel5);

        actButton6.setBackground(buttonBackground);
        actButton6.setLayout(new FlowLayout());
        actButton6.setToolTipText("Calculate the sum and product of each row and column of a 2-D integer matrix");
        actButton6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                actButton6MouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt, actButton6);
            }
            public void mouseExited(MouseEvent evt) {
                buttonMouseExited(evt, actButton6, buttonBackground);
            }
        });

        actLabel6.setFont(buttonFont);
        actLabel6.setForeground(buttonForeground);
        actLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        actLabel6.setText("Matrix Computation");
        actLabel6.setHorizontalTextPosition(SwingConstants.CENTER);
        actLabel6.setPreferredSize(buttonDimension);
        actButton6.add(actLabel6);

        actButton7.setBackground(buttonBackground);
        actButton7.setLayout(new FlowLayout());
        actButton7.setToolTipText("Convert a raw grade format into a pointed grade format (BulSU Grading System)");
        actButton7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                actButton7MouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt, actButton7);
            }
            public void mouseExited(MouseEvent evt) {
                buttonMouseExited(evt, actButton7, buttonBackground);
            }
        });

        actLabel7.setFont(buttonFont);
        actLabel7.setForeground(buttonForeground);
        actLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        actLabel7.setText("Grading System");
        actLabel7.setHorizontalTextPosition(SwingConstants.CENTER);
        actLabel7.setPreferredSize(buttonDimension);
        actButton7.add(actLabel7);
    }

    private void actButton1MouseClicked(MouseEvent evt) {
        Logger.log(1, "\"Fibonacci\" Button has been performed", logField);

        String input = JOptionPane.showInputDialog(getContentPane(), 
                                                    "Enter the fibonacci number (1-250)", 
                                                    "Fibonacci Sequence", 
                                                    JOptionPane.DEFAULT_OPTION);

        if (input == null) {
            Logger.log(2, "Action halted", logField);
            return;
        }

        else if (input.trim().isEmpty()) {
            Logger.log(3, "Expected input but none was provided", logField);
            return;
        }

        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            Logger.log(3, "Invalid input. Invalid variable type of (String, long, or double)", logField);

            JOptionPane.showMessageDialog(getContentPane(), "Input is not a valid integer", "Invalid Integer Value", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 250) {
            Logger.log(3, "Invalid input. It is outside the range of 1 to 250", logField);

            JOptionPane.showMessageDialog(getContentPane(), 
                                          "Enter a number between 1 and 250", 
                                          "Invalid Fibonacci Number", 
                                          JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(getContentPane(), 
                                          Fibonacci.fibonacci(input), 
                                          "Fibonacci Sequence", 
                                          JOptionPane.PLAIN_MESSAGE);
            Logger.log(1, "Button action successful", logField);
            return;
        }
    }

    private void actButton2MouseClicked(MouseEvent evt) {
        Logger.log(1, "\"Alternating Addition\" Button has been performed", logField);

        String input = JOptionPane.showInputDialog(getContentPane(), 
                                                    "Enter the number (1-99)", 
                                                    "Alternating Addition System",
                                                    JOptionPane.DEFAULT_OPTION);
        
        if (input == null) {
            Logger.log(2, "Action halted", logField);
            return;
        }

        else if (input.trim().isEmpty()) {
            Logger.log(3, "Expected input but none was provided", logField);
            return;
        }

        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            Logger.log(3, "Invalid input. Invalid variable type of (String, long, or double)", logField);
            
            JOptionPane.showMessageDialog(getContentPane(), 
                                            "Enter a valid integer type value", 
                                            "Invalid number", 
                                            JOptionPane.ERROR_MESSAGE);
            return;           
        }

        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 99) {
            Logger.log(3, "Input is out of range", logField);
            
            JOptionPane.showMessageDialog(getContentPane(), 
                                            "Enter a number ranging from 1 to 99", 
                                            "Invalid number", 
                                            JOptionPane.ERROR_MESSAGE);
            return;                                
        }

        else {
            JOptionPane.showMessageDialog(getContentPane(), 
                                            AltAdd.altAdd(input), 
                                            "Altenating Addition System", 
                                            JOptionPane.PLAIN_MESSAGE);
            Logger.log(1, "Button action successful", logField);
            return;
        }    
    }

    private void actButton3MouseClicked(MouseEvent evt) {
        Logger.log(1, "\"Rock, Paper, Scissors\" Button has been performed", logField);

        String instruction = "Enter a pick between (R)ock, (P)aper, and (S)cissors";

        String p1 = JOptionPane.showInputDialog(getContentPane(), 
                                                instruction, 
                                                "Rock, Paper, Scissors | Player One's Turn",
                                                JOptionPane.DEFAULT_OPTION);

        if (p1 == null) {
            Logger.log(2, "Action halted", logField);
            return;
        }

        else if (p1.trim().isEmpty()) {
            Logger.log(3, "Expected input but none was provided", logField);
            return;
        }

        else if (!p1.equals("R") && !p1.equals("P") && !p1.equals("S") ) {
            Logger.log(3, "Input provided was invalid. It was neither (R, P, or S)", logField);
            JOptionPane.showMessageDialog(getContentPane(), 
                                            instruction, 
                                            "Invalid Choice", 
                                            JOptionPane.ERROR_MESSAGE);
            return;                                
        }
        else {
            String p2 = JOptionPane.showInputDialog(getContentPane(), 
                                                    instruction, 
                                                    "Rock, Paper, Scissors | Player Two's Turn",
                                                    JOptionPane.DEFAULT_OPTION);


            if (p2 == null) {
                Logger.log(2, "Action halted", logField);
                return;
            }

            else if (p2.trim().isEmpty()) {
                Logger.log(3, "Expected input but none was provided", logField);
                return;
            }
            else if (!p2.equals("R") && !p2.equals("P") && !p2.equals("S")) {
                Logger.log(3, "Input provided was invalid. It was neither (R, P, or S)", logField);
                JOptionPane.showMessageDialog(getContentPane(), 
                                                instruction, 
                                                "Invalid Choice", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                p1 = p1.strip().toUpperCase();
                p2 = p2.strip().toUpperCase();

                JOptionPane.showMessageDialog(getContentPane(), RPS.rps(p1, p2), "Game Result", JOptionPane.PLAIN_MESSAGE);
                Logger.log(1, "Button action successful", logField);
                return;
            }
        }
    }

    private void actButton4MouseClicked(MouseEvent evt) {
        Logger.log(1, "\"Input Comparison\" Button has been performed", logField);

        String var1 = JOptionPane.showInputDialog(getContentPane(),
                                                     "Enter the first number", 
                                                     "Comparison of Numbers | First Variable", 
                                                     JOptionPane.DEFAULT_OPTION);
        
        if (var1 == null) {
            Logger.log(2, "Action halted", logField);
            return;
        }

        else if (var1.trim().isEmpty()) {
            Logger.log(3, "Expected input but none was provided", logField);
            return;
        }
        
        try {
            Integer.parseInt(var1);
        }
        catch (NumberFormatException e) {
            Logger.log(3, "Invalid input. Invalid variable type of (String, long, or double)", logField);
            JOptionPane.showMessageDialog(getContentPane(), 
                                            "Enter a valid integer type value", 
                                            "Invalid Input", 
                                            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String var2 = JOptionPane.showInputDialog(getContentPane(),
        "Enter the second number", 
        "Comparison of Numbers | Second Variable", 
        JOptionPane.DEFAULT_OPTION);

        if (var2 == null) {
            Logger.log(2, "Action halted", logField);
            return;
        }

        else if (var2.trim().isEmpty()) {
            Logger.log(3, "Expected input but none was provided", logField);
            return;
        }
        try {
            Integer.parseInt(var2);
        }
        catch (NumberFormatException e) {
            Logger.log(3, "Invalid input. Invalid variable type of (String, long, or double)", logField);
            JOptionPane.showMessageDialog(getContentPane(), 
                                            "Enter a valid integer type value", 
                                            "Invalid Input", 
                                            JOptionPane.ERROR_MESSAGE);
            return;
        }

        String var3 = JOptionPane.showInputDialog(getContentPane(),
        "Enter the third number", 
        "Comparison of Numbers | Third Variable", 
        JOptionPane.DEFAULT_OPTION);

        if (var3 == null) {
            Logger.log(2, "Action halted", logField);
            return;
        }

        else if (var3.trim().isEmpty()) {
            Logger.log(3, "Expected input but none was provided", logField);
            return;
        }
        try {
            Integer.parseInt(var3);
        }
        catch (NumberFormatException e) {
            Logger.log(3, "Invalid input. Invalid variable type of (String, long, or double)", logField);
            JOptionPane.showMessageDialog(getContentPane(), 
                                            "Enter a valid integer type value", 
                                            "Invalid Input", 
                                            JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(getContentPane(), Comparison.compare(var1, var2, var3), "Comparison Result", JOptionPane.PLAIN_MESSAGE);
        Logger.log(1, "Button action successful", logField);
        return;
    }

    private void actButton5MouseClicked(MouseEvent evt) {
        matrixActionInputGetter("HighLow");
    }

    private void actButton6MouseClicked(MouseEvent evt) {
        matrixActionInputGetter("MatrixComp");
    }

    private void actButton7MouseClicked(MouseEvent evt) {
        Logger.log(1, "\"Grading System\" Button has been performed", logField); 

        String input = JOptionPane.showInputDialog(getContentPane(), 
                                                    "Enter the raw grade value (0 - 100)", 
                                                    "Raw Grade to Pointed Grade Converter", 
                                                    JOptionPane.DEFAULT_OPTION);

        if (input == null) {
            Logger.log(2, "Action halted", logField);
            return;
        }

        else if (input.trim().isEmpty()) {
            Logger.log(3, "Expected input but none was provided", logField);
            return;
        }

        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            Logger.log(3, "Invalid input. Invalid variable type of (String, long, or double)", logField);

            JOptionPane.showMessageDialog(getContentPane(), 
                                            "Enter a valid integer type value", 
                                            "Invalid Input", 
                                            JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 100) {
            Logger.log(3, "Input is out of range", logField);

            JOptionPane.showMessageDialog(getContentPane(), 
                                            "Enter a value in the range of 0 to 100", 
                                            "Invalid Input", 
                                            JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(getContentPane(), Grading.gradingSystem(Integer.parseInt(input)), "Raw Grade to Pointed Grade Converter", JOptionPane.PLAIN_MESSAGE);
        Logger.log(1, "Button action successful", logField);
        return;     
    }

    private void logLabelClicked(MouseEvent evt) {
        new Thread(() -> {
            logField.removeAll();
            logField.repaint();
            logField.revalidate();

            JLabel logText = new JLabel();
            logText.setText("  *Log history has been cleared!");
            logText.setBackground(buttonBackground);
            logText.setForeground(Logger.infoColor);
            Logger.currentLine = 1;

            logField.add(logText);

            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            logField.removeAll();
            logField.repaint();
            logField.revalidate();
        }).start();
    }

    private void logLabelEntered(MouseEvent evt) {
        logLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    private void buttonMouseEntered(MouseEvent evt, JPanel button) {
        Color color = buttonBackground.brighter();
        
        button.setBackground(color);
        
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }

    private void buttonMouseExited(MouseEvent evt, JPanel button, Color color) {
        button.setBackground(color);
    }

    private void matrixActionInputGetter(String func) {
        JDialog inputGetter = new JDialog(getOwner(), "Matrix Interactive Input", ModalityType.MODELESS);
        inputGetter.setIconImage(windowIcon);
        inputGetter.setLayout(new BorderLayout());
        inputGetter.setBackground(homeColor);
        inputGetter.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                Logger.log(2, "Action halted", logField);
            }
        }); 

        JPanel matrixBuildPanel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new MigLayout("align 50% 50%, wrap", "[][][]", "[][][]"));
        fieldPanel.setBackground(buttonPanelColor);

        JTextField row1col1 = initMatrixField();
        JTextField row1col2 = initMatrixField();
        JTextField row1col3 = initMatrixField();
        JTextField row2col1 = initMatrixField();
        JTextField row2col2 = initMatrixField();
        JTextField row2col3 = initMatrixField();
        JTextField row3col1 = initMatrixField();
        JTextField row3col2 = initMatrixField();
        JTextField row3col3 = initMatrixField();
        JPanel confirmButton = initMatrixBuild(new JTextField[][]{{row1col1, row1col2, row1col3}, {row2col1, row2col2, row2col3}, {row3col1, row3col2, row3col3}}, func, inputGetter);

        fieldPanel.add(row1col1);
        fieldPanel.add(row1col2);
        fieldPanel.add(row1col3);
        fieldPanel.add(row2col1);
        fieldPanel.add(row2col2);
        fieldPanel.add(row2col3);
        fieldPanel.add(row3col1);
        fieldPanel.add(row3col2);
        fieldPanel.add(row3col3);

        matrixBuildPanel.add(fieldPanel, BorderLayout.CENTER);
        matrixBuildPanel.add(confirmButton, BorderLayout.SOUTH);
        inputGetter.add(matrixBuildPanel, BorderLayout.CENTER);
        inputGetter.pack();
        inputGetter.setVisible(true);
    }   

    private JPanel initMatrixBuild(JTextField[][] fields, String func, JDialog dialog) {
        JPanel confirm = new JPanel(new MigLayout("align 50% 50%"));
        confirm.setBackground(buttonPanelColor);
        confirm.setPreferredSize(new Dimension(290, 30));
        JLabel confirmLabel = new JLabel("Build Matrix");
        confirmLabel.setFont(buttonFont);
        confirmLabel.setForeground(buttonForeground);
        confirm.add(confirmLabel, "gapleft 5");

        confirm.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt, confirm);
            }
            public void mouseExited(MouseEvent evt) {
                buttonMouseExited(evt, confirm, buttonPanelColor);
            }
            public void mouseClicked(MouseEvent evt) {
                matrixBuildClicked(evt, fields, func);
                dialog.dispose();
                }
            });
        return confirm;
    }
   
    private void matrixBuildClicked(MouseEvent evt, JTextField[][] fields, String func) {
        int[][] matrix = new int[3][3];

        for (int matrixRow = 0; matrixRow < fields.length; matrixRow++) {
            for (int matrixCol = 0; matrixCol < fields[matrixRow].length; matrixCol++) {
                JTextField field = fields[matrixRow][matrixCol];

                if (field.getText().isBlank()) {
                    JOptionPane.showMessageDialog(evt.getComponent(), "Cell(s) have no value", "Cell Empty", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    matrix[matrixRow][matrixCol] = Integer.parseInt(field.getText());
                }
                catch (NumberFormatException e) {
                    Logger.log(3, "Invalid cell variable type. Type is of (String, long, double)", logField);
                    JOptionPane.showMessageDialog(evt.getComponent(), "Cell value type is not of integer type", "Invalid Cell Value", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        if (func.equals("HighLow")) {
            Logger.log(1, "\"Highest-Lowest\" Button has been performed", logField);

            JOptionPane.showMessageDialog(getContentPane(), HighestLowest.highestLowest(matrix), "Highest Lowest", JOptionPane.PLAIN_MESSAGE);
            Logger.log(1, "Button action successful", logField);
            return;
        }
        else if (func.equals("MatrixComp")) {
            Logger.log(1, "\"Matrix Computation\" Button has been performed", logField);                                              

            JOptionPane.showMessageDialog(getContentPane(), MatrixComp.matrixComputation(matrix), "Matrix Operation", JOptionPane.PLAIN_MESSAGE);
            Logger.log(1, "Button action successful", logField);
            return;    
        }
    }

    private JTextField initMatrixField() {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(100, 100));
        field.setEditable(true);
        field.setLayout(new MigLayout("align 50% 50%"));
        field.setForeground(new Color(242, 242, 242));
        field.setBackground(buttonBackground);
        field.setFont(new Font("Bahnschrift", 1, 24));
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setRequestFocusEnabled(true);
        return field;
    }

    private void initComponents() {
        buttonPanel = new JPanel();
        actButton1 = new JPanel();
        actLabel1 = new JLabel();
        actButton2 = new JPanel();
        actLabel2 = new JLabel();
        actButton3 = new JPanel();
        actLabel3 = new JLabel();
        actButton4 = new JPanel();
        actLabel4 = new JLabel();
        actButton5 = new JPanel();
        actLabel5 = new JLabel();
        actButton6 = new JPanel();
        actLabel6 = new JLabel();
        actButton7 = new JPanel();
        actLabel7 = new JLabel();
        homePanel = new JPanel();
        headerPanel = new JPanel();
        headerLabel = new JLabel();
        logLabel = new JLabel();
        authorLabel1 = new JLabel();
        logPane = new JScrollPane();
        logField = new JPanel();

        initHomePanel();
        initButtons();
        initButtonPanel();

        pack();
    }
}