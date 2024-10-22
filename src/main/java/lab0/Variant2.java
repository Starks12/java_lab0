package lab0;

import java.util.ArrayList;
import java.util.List;

public class Variant2 {

    public enum DAY_OF_WEEK {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public class IntegerTask {

        public static int kilogramsToTons(int kilograms) {
            if (kilograms < 0) {
                throw new IllegalArgumentException("Mass cannot be negative");
            }
            return kilograms / 1000;
        }
    }

    public class BooleanTask {

        public static boolean isOdd(int number) {
            return number % 2 != 0; // Повертає true, якщо число непарне
        }
    }


    public class IfTask {

        public static int modifyNumber(int number) {
            if (number > 0) {
                return number + 1; // Додаємо 1, якщо число позитивне
            } else {
                return number - 2; // Віднімаємо 2, якщо число не позитивне
            }
        }
    }


    public class CaseTask {

        public static String describeGrade(int K) {
            switch (K) {
                case 1:
                    return "погано";
                case 2:
                    return "незадовільно";
                case 3:
                    return "задовільно";
                case 4:
                    return "добре";
                case 5:
                    return "відмінно";
                default:
                    return "помилка";
            }
        }
    }

    public class ForTask {

        public static Result printRange(int A, int B) {
            if (A >= B) {
                throw new IllegalArgumentException("A must be less than B.");
            }

            List<Integer> numbers = new ArrayList<>();
            for (int i = A; i <= B; i++) {
                numbers.add(i);
            }

            return new Result(numbers, numbers.size());
        }

        public static class Result {
            private List<Integer> numbers;
            private int count;

            public Result(List<Integer> numbers, int count) {
                this.numbers = numbers;
                this.count = count;
            }

            public List<Integer> getNumbers() {
                return numbers;
            }

            public int getCount() {
                return count;
            }
        }
    }



    public class WhileTask {

        public static int countSegments(int A, int B) {
            if (A <= 0 || B <= 0 || A <= B) {
                throw new IllegalArgumentException("A must be greater than B and both numbers must be positive.");
            }

            int count = 0;
            int totalLength = 0;

            // Додаємо довжину B до загальної довжини, поки вона не перевищує A
            while (totalLength + B <= A) {
                totalLength += B;
                count++;
            }

            return count;
        }
    }



    public class ArrayTask {

        public static int[] generatePowersOfTwo(int N) {
            if (N <= 0) {
                throw new IllegalArgumentException("N must be greater than 0.");
            }

            int[] powersOfTwo = new int[N];
            for (int i = 0; i < N; i++) {
                powersOfTwo[i] = (int) Math.pow(2, i); // Обчислюємо 2 в степені i
            }
            return powersOfTwo;
        }
    }



    public class MatrixTask {

        public static int[][] generateMatrix(int M, int N) {
            if (M < 2 || M > 10 || N < 2 || N > 10) {
                throw new IllegalArgumentException("The dimensions of the matrix M and N must be between 2 and 10.");
            }

            int[][] matrix = new int[M][N];

            for (int j = 0; j < N; j++) {
                int value = 5 * (j + 1); // Значення для J-го стовпця
                for (int i = 0; i < M; i++) {
                    matrix[i][j] = value;
                }
            }

            return matrix;
        }
    }


}