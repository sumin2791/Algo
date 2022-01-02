import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {

            boolean isOk = false;
            if (arr[i] == '<') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                isOk = true;
                System.out.print('<');
                while (isOk) {
                    i++;
                    System.out.print(arr[i]);
                    if (arr[i] == '>') {

                        isOk = false;
                    }

                }
            } else if (arr[i] == ' ') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            } else {
                stack.push(arr[i]);
            }

        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        } // 문장 끝날때

    }

}