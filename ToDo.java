import java.util.*;

public class ToDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ToDoList = new ArrayList<>();

        while (true) {
            System.out.println("\nToDoリスト：");
            for(int i = 0;i < ToDoList.size();i++){
                System.out.println((i + 1 +"."+ ToDoList.get(i)));
            }
            System.out.println("\n　1:追加｜　２：削除　｜3：終了");
            System.out.println("番号を選択して下さい。");

            int choice ;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("誤った入力です。数字を入力してください。");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("追加するToDoを入力");
                    String task = sc.nextLine();
                    ToDoList.add(task);
                    break;
                case 2:
                    if(ToDoList.isEmpty()){
                        System.out.println("リストが空です");
                        continue;
                    }
                    System.out.println("削除する番号を入力：");
                    int index;
                    try {
                        index = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("無効な入力です。数字を入力してください。");
                        sc.nextLine();
                        continue;
                    }

                    if(index > 0 && index <=ToDoList.size()){
                        System.out.println(ToDoList.get(index-1) + "を削除しました");
                        ToDoList.remove(index - 1);
                    } else {
                        System.out.println("無効な番号です。");
                    }
                    break;
                case 3:
                    System.out.println("アプリを終了します");
                    sc.close();
                    return;
                default:
                    System.out.println("無効な番号です。");
                }
            
        }
    }
}