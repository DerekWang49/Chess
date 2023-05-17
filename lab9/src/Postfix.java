public class Postfix <T extends Comparable<T>> {

    public static double evaluate(String[] expression) {
        Stack<String> s = new Stack<String>();
        try {
            for (int i = 0; i < expression.length; i++) {
                // for (int j = 0; j < expression[i].length; j++)
                if (expression[i] == "-") {
                    double num1 = Double.parseDouble(s.pop());
                    double num2 = Double.parseDouble(s.pop());
                    s.push("" + (num2 - num1));
                } else if (expression[i] == "+") {
                    double num1 = Double.parseDouble(s.pop());
                    double num2 = Double.parseDouble(s.pop());
                    s.push("" + (num1 + num2));
                } else if (expression[i] == "*") {
                    double num1 = Double.parseDouble(s.pop());
                    double num2 = Double.parseDouble(s.pop());
                    s.push("" + (num1 * num2));
                } else if (expression[i] == "/") {
                    double num1 = Double.parseDouble(s.pop());
                    double num2 = Double.parseDouble(s.pop());
                    s.push("" + (num2 / num1));
                }
                else {
                    s.push(expression[i]);
                }
//                if (expression[i] != "-" || expression[i] != "/" || expression[i] != "+" || expression[i] != "*") {
//                    s.push(expression[i]);
//                } else {
//                    double num1 = Double.parseDouble(s.pop());
//                    double num2 = Double.parseDouble(s.pop());
//                    if (expression[i] == "-") {
//                        s.push("" + (num1 - num2));
//                    } else if (expression[i] == "+") {
//                        s.push("" + (num1 + num2));
//                    } else if (expression[i] == "*") {
//                        s.push("" + (num1 * num2));
//                    } else {
//                        s.push("" + (num1 / num2));
//                    }
//                }
            }
            return Double.parseDouble(s.pop());
        }


        catch (StackException e){
                System.out.println(e);
            }
        finally{
                System.out.println("Evaluation Complete");
            }
        return 0;
        }


    public static void main(String[] args) {
        System.out.println(evaluate(new String[]{"5", "2", "+"}));
        System.out.println(evaluate(new String[]{"1", "2", "-"}));
        System.out.println(evaluate(new String[]{"4", "5", "*", "3", "+"}));
        System.out.println(evaluate(new String[]{"1", "2", "+", "3", "4", "+", "/"}));

        System.out.println(evaluate(new String[] {"1", "2", "-","1", "2", "-", "1", "2", "-", "1", "2", "-", "1", "2", "-", "1", "2", "-"}
                ));

    }
}
