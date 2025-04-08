import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoGUI {
    public static void main(String[] args) {
        //ウィンドウ作成
        JFrame frame = new JFrame("ToDoリスト");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //パネルレイアウト
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        //追加
        JTextField inputField = new JTextField();
        inputField.setColumns(15);
        JButton addButton = new JButton("追加");
        
        //削除
        JTextField inputDel = new JTextField();
        inputDel.setColumns(3);
        JButton del= new JButton("削除");

        //配置
        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        
        JPanel deletePanel = new JPanel();
        deletePanel.add(inputDel,BorderLayout.CENTER);
        deletePanel.add(del,BorderLayout.EAST);
        
        //まとめるパネル
        JPanel nortPanel = new JPanel();
        nortPanel.setLayout(new BoxLayout(nortPanel, BoxLayout.Y_AXIS));
        nortPanel.add(inputPanel);
        nortPanel.add(deletePanel);

        //表示エリア
        JTextArea todoArea = new JTextArea();
        todoArea.setEditable(false);

        //スクロール
        JScrollPane scroll = new JScrollPane(todoArea);

        //データ保存リスト
        ArrayList<String> todoList = new ArrayList<>();

        //ボタン処理
        addButton.addActionListener(e -> {
            String task = inputField.getText().trim();
            if(!task.isEmpty()) {
                todoList.add(task);
                inputField.setText("");

                //更新
                StringBuilder sb = new StringBuilder();
                for(int i = 0;i <todoList.size();i++){
                    sb.append((i + 1)+"."+ todoList.get(i) + "\n");
                }
                todoArea.setText(sb.toString());
            }
        });

        del.addActionListener(e ->{
            try {
                int index = Integer.parseInt(inputDel.getText().trim())-1;
                if(index >= 0 &&index < todoList.size()){
                todoList.remove(index);
                inputDel.setText("");
                StringBuilder sb = new StringBuilder();
                for(int i = 0;i <todoList.size();i++){
                    sb.append((i + 1)+"."+ todoList.get(i) + "\n");
                }
                todoArea.setText(sb.toString());
                } else {
                    JOptionPane.showMessageDialog(frame,"無効な番号です。", "エラー", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,"数字を入力してください。", "エラー", JOptionPane.ERROR_MESSAGE);
                // TODO: handle exception
            }
        });
        
        //パネルに追加
        panel.add(nortPanel, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
    
        frame.add(panel);
        frame.setVisible(true);
    }    
}
