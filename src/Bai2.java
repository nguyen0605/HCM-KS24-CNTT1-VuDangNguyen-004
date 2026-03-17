import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Hãy nhập vào lịch sử các phương tiện đã vào bãi đỗ xe: ");
        String s = sc.nextLine();

        //kiểm tra chuỗi rỗng
        if (s.isEmpty()){
            System.out.println("Lỗi: Chuỗi không hợp lệ");
            return;
        }

        //Khởi tạo map và lưu key, value
        Map<String, Integer> map = new HashMap<>();
        for (String vehical : s.trim().toLowerCase().split(",\\s+")){
            map.put(vehical, map.getOrDefault(vehical,0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");
        }

        //Tra cứu phương tiên
        boolean found = false;
        System.out.print("\nHãy nhập tên phương tiện muốn tra cứu: ");
        String findString = sc.nextLine().toLowerCase();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getKey().equals(findString)){
                System.out.println("Search ''" + findString + "'':  " + entry.getValue());
                found = true;
                break;
            }
        }

        if (!found){
            System.out.println("Phương tiện chưa từng vào bãi đỗ xe!");
        }
    }
}
