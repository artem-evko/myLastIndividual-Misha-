import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    JLabel l1, l2, l3, l4;
    TextArea area;
    JTextField f1, f2, f3, f4;
    ArrayList<Book> m;
    JButton add, print, delete;

    MyPanel() {
        m = new ArrayList<>();
        l1 = new JLabel("Введите название книги");
        add(l1);
        f1 = new JTextField();
        f1.setColumns(10);
        add(f1);

        l2 = new JLabel("Введите автора");
        add(l2);
        f2 = new JTextField();
        f2.setColumns(10);
        add(f2);

        l3 = new JLabel("Введите год публикации");
        add(l3);
        f3 = new JTextField();
        f3.setColumns(10);
        add(f3);

        add = new JButton("Добавить книгу ");
        MyListener m = new MyListener();
        add.addActionListener(m);
        add(add);

        l4 = new JLabel("Введите название книги, чтобы ее удалить");
        add(l4);
        f4 = new JTextField(10);
        add(f4);

        delete = new JButton("Удалить");
        MyListenerDel d = new MyListenerDel();
        delete.addActionListener(d);
        add(delete);

        print = new JButton("Вывести список ");
        MyListenerPrinter p = new MyListenerPrinter();
        print.addActionListener(p);
        add(print);
        area = new TextArea("В вашем списке:\n");
        add(area);


    }

    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = f1.getText();
            String author = f2.getText();
            int year = Integer.parseInt(f3.getText());
            Book book = new Book(title, author, year);
            m.add(book);

        }
    }

    class MyListenerPrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Book book : m) {
                area.append(book.toString() + "\n");
            }
        }
    }

    class MyListenerDel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            int p = -1;
            for (int i = 0; i < m.size(); i++)
                if (f4.getText().equalsIgnoreCase(m.get(i).getTitle())) {
                    p = i;
                }

            if (p > -1) {
                m.remove(p);
                area.append("Удалили книгу: " + f4.getText() + "\n");
            } else {
                area.append("Такой книги нет" + "\n");
            }

        }
    }
}
