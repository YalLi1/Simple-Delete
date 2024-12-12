import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MouseListenerExample extends JFrame implements MouseListener {

    private BufferedImage image;
    private int xPosition = -1, yPosition = -1;

    public MouseListenerExample() {
        // загружаем изображение
        try {
            image = ImageIO.read(new File("C:\\Users\\New\\Pictures\\Sun.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Настройка панели
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null && xPosition >= 0 && yPosition >= 0) {
                    g.drawImage(image, xPosition, yPosition, this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(800, 800));
        panel.addMouseListener(this);

        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            xPosition = e.getX();
            yPosition = e.getY();
            repaint(); // Перерисовываем панель для отображения изображения
        } else if (SwingUtilities.isMiddleMouseButton(e)) {
            xPosition = -1;
            yPosition = -1;
            repaint(); // Перерисовываем панель для удаления изображения
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Не используется
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Не используется
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Не используется
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Не используется
    }

   }
