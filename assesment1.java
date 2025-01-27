import java.util.Stack;

public class assesment1 {
    public static double evaluate(String expression) {
        try {
            Stack<Double> operands = new Stack<>();
            Stack<Character> operators = new Stack<>();
            for (char c : expression.toCharArray()) {
                if (Character.isDigit(c)) {
                    String number = "";
                    while (Character.isDigit(c) || c == '.') {
                        number += c;
                        c = (++c < expression.length()) ? expression.charAt(c) : '\0';
                    }
                    operands.push(Double.valueOf(number));
                    c--;
                } else if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (operators.peek() != '(') {
                        operands.push(applyOp(operators.pop(), operands.pop(), operands.pop()));
                    }
                    operators.pop();
                } else if (isOperator(c)) {
                    while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                        operands.push(applyOp(operators.pop(), operands.pop(), operands.pop()));
                    }
                    operators.push(c);
                }
            }
            while (!operators.isEmpty()) {
                operands.push(applyOp(operators.pop(), operands.pop(), operands.pop()));
            }
            return operands.pop();
        } catch (NumberFormatException e) {
            System.err.println("Invalid expression: " + expression);
            return Double.NaN;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    private static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                return a * b;
            }
            case '/' -> {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String expression = "3 + 5 * (2 - 4)";
        System.out.println(expression + " = " + evaluate(expression));
        System.out.println("Yash Gupta\t23BCS11317");
    }
}