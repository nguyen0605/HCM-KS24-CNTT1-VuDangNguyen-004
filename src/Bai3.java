import java.util.Scanner;
import java.util.Stack;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào chuỗi văn bản: ");
        String s = sc.nextLine();

        //Formmat chuỗi loại bỏ kí tự đặc biệt và khoảng trắng
        s = s.toLowerCase().trim().replaceAll("\\W", "");

        //Kiểm tra chuỗi không hợp lệ nếu không còn số hay chữ cái
        if (s.isEmpty()){
            System.out.println("Lỗi: Chuỗi không hợp lệ");
            return;
        }

        //Đẩy chuỗi vào stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        //Lấy chuỗi (đảo ngược)
        String rev = "";
        while (!stack.isEmpty()){
            rev += stack.pop();
        }

        //So sánh 2 chuỗi
        System.out.println(rev.equals(s));
    }
}
