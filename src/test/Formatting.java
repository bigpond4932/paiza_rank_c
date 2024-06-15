package test;

public class Formatting {
    public static void main(String[] args) {
        String product = "Laptop";
        int quantity = 5;
        double price = 799.99;
//        double price = 799.995; -> 800.00
//        double price = 799.993; -> 799.99

        // String.format을 사용하여 복잡한 포맷팅
        String receipt = String.format("Product: %s\nQuantity: %d\nPrice: $%.2f\nTotal: $%.2f",
                product, quantity, price, quantity * price);

        // 결과 출력
        System.out.println(receipt);
    }
}
