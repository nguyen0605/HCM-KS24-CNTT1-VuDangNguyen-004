import java.util.*;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Câu 1: Khởi tạo và nhập dữ liệu
        System.out.print("Nhập vào số lượng điểm muốn thêm vào danh sách: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n == 0){
            System.out.println("Lỗi: Số lượng điểm sinh viên không hợp lệ");
            return;
        }

        List<Double> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập vào điểm số thứ " + (i+1) + ": ");
            double score = sc.nextDouble();

            if (score < 0.0 || score > 10.0){
                System.out.println("Điểm không hợp lệ! (0.0 -> 10.0)");
                return;
            }

            scores.add(score);
        }

        //Câu 4a: Tìm điểm số cao nhất và thấp nhất
        double min = scores.get(0), max = scores.get(0);

        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) < min){
                min = scores.get(i);
            } else if (scores.get(i) > max){
                max = scores.get(i);
            }
        }

        System.out.println("Min: " + min + ", Max: " + max);

        //Câu 4b: Tính tổng điểm và điểm trung bình
        double sum = 0.0;

        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
        }

        double average = sum / scores.size();
        System.out.println("Average: "+ average);

        //Câu 4c: Sắp xếp và hiển thị danh sách mức điểm duy nhất
        for (int i = 0; i < scores.size() - 1; i++) {
            for (int j = 0; j < scores.size() - 1 -i; j++) {
                if (scores.get(j) > scores.get(j+1)){
                    double temp = scores.get(j);
                    scores.set(j, scores.get(j+1));
                    scores.set(j+1, temp);
                }
            }
        }

        Set<Double> set = new TreeSet<>();
        for (Double score : scores){
            if (!set.contains(score)){
                set.add(score);
            }
        }

        System.out.print("Unique (Asc): ");
        for (Double i : set){
            System.out.print(i + " ");
        }

        //Câu 4d: Đếm số lượng sinh viên đạt điểm giỏi
        int count = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) >= 8.0){
                count++;
            }
        }
        System.out.println("\nExcellent (>= 8.0): " + count);
    }
}