package nikita.coursework;


import nikita.coursework.handler.*;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * Created by nikita on 10.05.16.
 */
public class GVEFrame extends JFrame {

    private static final int MIN_FRAME_WIDTH = 840;
    private static final int MIN_FRAME_HEIGHT = 580;

    private static final int FRAME_WIDTH = MIN_FRAME_WIDTH ;
    private static final int FRAME_HEIGHT = MIN_FRAME_HEIGHT;

    private static final Color DRAWING_PANEL_COLOR = new Color(241, 241, 241);
    private static final Color BAR_COLOR = new Color(232, 232, 232);
    private static final Color BORDER_COLOR = new Color(151, 151, 151);


    private static final int TOP_BAR_HIGHT = 80;
    private static final int SPACER_HIGHT = 15;
    private static final int SPACER_WIDTH = 5;

    private static final int SPACE_BETWEEN_MAIN_ELEMENTS = 100;

    private static final int TOP_BAR_ITEM_HIGHT = TOP_BAR_HIGHT - 2*SPACER_HIGHT;
    private static final int TOP_BAR_ITEM_WIDTH = (int)(TOP_BAR_ITEM_HIGHT* 1.6);

    private static final int ZOOM_SPACER_HITGHT = 30;
    private static final int ZOOM_BAR_ITEM_HIGHT = TOP_BAR_HIGHT - 2*ZOOM_SPACER_HITGHT;
    private static final int ZOOM_BAR_ITEM_WIDTH = (int)(ZOOM_BAR_ITEM_HIGHT* 1.5);



    public GVEFrame(){
            initUI();
    }

    public void initUI(){
        setTitle("Graphic Vector Editor");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setMinimumSize(new Dimension(MIN_FRAME_WIDTH, MIN_FRAME_HEIGHT));

        setLayout(new BorderLayout(1, 1));
        createDrawinganel();
        createTopBar();
        createRightBar();
    }

    private GVEDrawingPanel graphPanel;

    private void createDrawinganel() {

        graphPanel = new GVEDrawingPanel();

        graphPanel.setBackground(DRAWING_PANEL_COLOR);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        graphPanel.setPreferredSize(new Dimension(width, height));

        JScrollPane scroller = new JScrollPane(graphPanel);
        scroller.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));

        add(scroller, BorderLayout.CENTER);
        graphPanel.setFocusable(true);
    }

    private void createKeyBinding() {
        //TODO: Implement key binding, bitch.
    }

    private void createTopBar() {
        /**
         *  Initialization of buttons
         */
        JButton group = createTopBarButton("/images/group.png");
        JButton ungroup = createTopBarButton("/images/ungroup.png");
        JButton edit = createStateButton("/images/edit.png", new EditState(graphPanel));
        JButton line = createStateButton("/images/line.png", new LineState(graphPanel));
        JButton rectangle = createStateButton("/images/rectangle.png", new RectangleState(graphPanel));
        JButton oval = createStateButton("/images/oval.png", new OvalState(graphPanel));

        JButton zoomPlus = createZoomBarButton("/images/zoomplus.png");
        JButton zoomMinus = createZoomBarButton("/images/zoomminus.png");

        /**
         *  Initialization of panel
         */
        JPanel topBar = new JPanel();
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.LINE_AXIS));
        topBar.setBackground(BAR_COLOR);
        topBar.setPreferredSize(new Dimension(MIN_FRAME_WIDTH, TOP_BAR_HIGHT));

        /**
         *  Adding of buttons
         */
        topBar.add(Box.createRigidArea(new Dimension(SPACER_WIDTH, SPACER_HIGHT)));
        topBar.add(group);
        topBar.add(Box.createRigidArea(new Dimension(SPACER_WIDTH, SPACER_HIGHT)));
        topBar.add(ungroup);
        topBar.add(Box.createRigidArea(new Dimension(SPACE_BETWEEN_MAIN_ELEMENTS, SPACER_HIGHT)));
        topBar.add(edit);
        topBar.add(Box.createRigidArea(new Dimension(SPACER_WIDTH, SPACER_HIGHT)));
        topBar.add(line);
        topBar.add(Box.createRigidArea(new Dimension(SPACER_WIDTH, SPACER_HIGHT)));
        topBar.add(rectangle);
        topBar.add(Box.createRigidArea(new Dimension(SPACER_WIDTH, SPACER_HIGHT)));
        topBar.add(oval);

        topBar.add(Box.createRigidArea(new Dimension(SPACE_BETWEEN_MAIN_ELEMENTS, SPACER_HIGHT)));
        topBar.add(zoomPlus);
        topBar.add(Box.createRigidArea(new Dimension(SPACER_WIDTH, SPACER_HIGHT)));
        topBar.add(zoomMinus);

        /**
         *  Adding panel to main frame.
         */
        add(topBar, BorderLayout.PAGE_START);
    }



    private  void createRightBar(){
        /**
         * Right panel init
         */
        JPanel rightBar = new JPanel();
        rightBar.setBackground(BAR_COLOR);
        rightBar.setLayout(new BoxLayout(rightBar, BoxLayout.PAGE_AXIS));
        rightBar.setPreferredSize(new Dimension(200, MIN_FRAME_HEIGHT));
        rightBar.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));

        /**
         *  Panel for position init
         */
        JPanel positionPanel = new JPanel();
        JLabel positionName = new JLabel("Position:");
        JTextField positionX = new JTextField();
        JTextField positionY = new JTextField();
        positionPanel.setLayout(new BoxLayout(positionPanel, BoxLayout.LINE_AXIS));
        positionPanel.setMaximumSize(new Dimension(200, 20));
        positionPanel.add(positionName);
        positionPanel.add(positionX);
        positionPanel.add(positionY);

        rightBar.add(Box.createRigidArea(new Dimension(20, 20)));
        rightBar.add(positionPanel);

        /**
         *  Panel for size init
         */
        JPanel sizedPanel = new JPanel();
        JLabel sizeName = new JLabel("Size:      ");
        JTextField width = new JTextField();
        JTextField height = new JTextField();
        sizedPanel.setLayout(new BoxLayout(sizedPanel, BoxLayout.LINE_AXIS));
        sizedPanel.setMaximumSize(new Dimension(200, 20));
        sizedPanel.add(sizeName);
        sizedPanel.add(width);
        sizedPanel.add(height);


        /**
         *  Panel for border init
         */
        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new BoxLayout(borderPanel, BoxLayout.PAGE_AXIS));
        JPanel borderThicknessPanel = new JPanel();
        JPanel redGreenBlueBorderPanel = new JPanel();
        JLabel borderName = new JLabel("Thickness:   ");
        JTextField thickness = new JTextField();
        JTextField red = new JTextField();
        JTextField green = new JTextField();
        JTextField blue = new JTextField();

        borderThicknessPanel.setLayout(new BoxLayout(borderThicknessPanel, BoxLayout.LINE_AXIS));
        borderThicknessPanel.setMaximumSize(new Dimension(200, 20));
        borderThicknessPanel.add(borderName);
        borderThicknessPanel.add(thickness);


        redGreenBlueBorderPanel.setLayout(new BoxLayout(redGreenBlueBorderPanel, BoxLayout.LINE_AXIS));
        redGreenBlueBorderPanel.setMaximumSize(new Dimension(200, 30));
        redGreenBlueBorderPanel.add(new JLabel("R:"));
        redGreenBlueBorderPanel.add(red);
        redGreenBlueBorderPanel.add(new JLabel("G:"));
        redGreenBlueBorderPanel.add(green);
        redGreenBlueBorderPanel.add(new JLabel("B:"));
        redGreenBlueBorderPanel.add(blue);

        borderPanel.add(new JLabel("Border:"));
        borderPanel.add(borderThicknessPanel);
        borderPanel.add(redGreenBlueBorderPanel);

        /**
         *  Panel for color init
         */
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.PAGE_AXIS));
        JPanel colorRedGreenBluePanel = new JPanel();
        JTextField colorRed = new JTextField();
        JTextField colorGreen = new JTextField();
        JTextField colorBlue = new JTextField();


        colorRedGreenBluePanel.setLayout(new BoxLayout(colorRedGreenBluePanel, BoxLayout.LINE_AXIS));
        colorRedGreenBluePanel.setMaximumSize(new Dimension(200, 25));
        colorRedGreenBluePanel.add(new JLabel("R:"));
        colorRedGreenBluePanel.add(colorRed);
        colorRedGreenBluePanel.add(new JLabel("G:"));
        colorRedGreenBluePanel.add(colorGreen);
        colorRedGreenBluePanel.add(new JLabel("B:"));
        colorRedGreenBluePanel.add(colorBlue);

        colorPanel.add(new JLabel("Color:"));
        colorPanel.add(colorRedGreenBluePanel);

        rightBar.add(Box.createRigidArea(new Dimension(20, 20)));
        rightBar.add(sizedPanel);
        rightBar.add(Box.createRigidArea(new Dimension(20, 20)));
        rightBar.add(colorPanel);
        rightBar.add(Box.createRigidArea(new Dimension(20, 20)));
        rightBar.add(borderPanel);

        add(rightBar, BorderLayout.EAST);
    }

    private JButton createTopBarButton(String iconPath) {
        JButton toolBarButton = new JButton();
        toolBarButton.setIcon(createImageIcon(iconPath, "", TOP_BAR_ITEM_WIDTH, TOP_BAR_ITEM_HIGHT));
        toolBarButton.setOpaque(true);
        toolBarButton.setFocusPainted(false);
        toolBarButton.setFocusable(false);
        toolBarButton.setBorder(new LineBorder(BORDER_COLOR, 0));
        return toolBarButton;
    }

    private JButton createStateButton(String iconPath, AbstractState state) {
        JButton button = createTopBarButton(iconPath);
        button.addActionListener(e -> graphPanel.setHandlerState(state));
        return button;
    }

    private JButton createZoomBarButton(String iconPath) {
        JButton toolBarButton = new JButton();
        toolBarButton.setIcon(createImageIcon(iconPath, "", ZOOM_BAR_ITEM_WIDTH, ZOOM_BAR_ITEM_HIGHT));
        toolBarButton.setOpaque(true);
        toolBarButton.setFocusPainted(false);
        toolBarButton.setFocusable(false);
        toolBarButton.setBorder(new LineBorder(BORDER_COLOR, 0));
        return toolBarButton;
    }

    private ImageIcon createImageIcon(String path, String description, int width, int height) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL, description);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(newImg);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

