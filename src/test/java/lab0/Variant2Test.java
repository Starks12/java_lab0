package lab0;

import org.testng.annotations.Test;
import static org.testng.Assert.*;


import java.util.List;

import static org.testng.Assert.assertEquals;


public class Variant2Test {
    // integer
    @Test
    public void testKilogramsToTons() {
        assertEquals(Variant2.IntegerTask.kilogramsToTons(500), 0);
        assertEquals(Variant2.IntegerTask.kilogramsToTons(1000), 1);
        assertEquals(Variant2.IntegerTask.kilogramsToTons(2500), 2);
        assertEquals(Variant2.IntegerTask.kilogramsToTons(3000), 3);
        assertEquals(Variant2.IntegerTask.kilogramsToTons(5000), 5);
        assertEquals(Variant2.IntegerTask.kilogramsToTons(10000), 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Mass cannot be negative")
    public void testKilogramsToTonsNegative() {
        Variant2.IntegerTask.kilogramsToTons(-1);
    }

    // boolean
    @Test
    public void testIsOdd() {
        assertTrue(Variant2.BooleanTask.isOdd(1));    // Непарне
        assertTrue(Variant2.BooleanTask.isOdd(3));    // Непарне
        assertFalse(Variant2.BooleanTask.isOdd(2));   // Парне
        assertFalse(Variant2.BooleanTask.isOdd(0));   // Парне
        assertTrue(Variant2.BooleanTask.isOdd(-5));   // Непарне
        assertFalse(Variant2.BooleanTask.isOdd(-4));  // Парне
    }

    // if
    @Test
    public void testModifyNumber() {
        assertEquals(Variant2.IfTask.modifyNumber(5), 6);
        assertEquals(Variant2.IfTask.modifyNumber(0), -2);
        assertEquals(Variant2.IfTask.modifyNumber(-3), -5);
        assertEquals(Variant2.IfTask.modifyNumber(10), 11);
        assertEquals(Variant2.IfTask.modifyNumber(-1), -3);
    }

    // case
    @Test
    public void testDescribeGrade() {
        assertEquals(Variant2.CaseTask.describeGrade(1), "погано");
        assertEquals(Variant2.CaseTask.describeGrade(2), "незадовільно");
        assertEquals(Variant2.CaseTask.describeGrade(3), "задовільно");
        assertEquals(Variant2.CaseTask.describeGrade(4), "добре");
        assertEquals(Variant2.CaseTask.describeGrade(5), "відмінно");
        assertEquals(Variant2.CaseTask.describeGrade(0), "помилка");  // За межами діапазону
        assertEquals(Variant2.CaseTask.describeGrade(6), "помилка");
        assertEquals(Variant2.CaseTask.describeGrade(-1), "помилка");
    }

    // for
    @Test
    public void testPrintRange() {
        Variant2.ForTask.Result result = Variant2.ForTask.printRange(3, 7);
        assertEquals(result.getNumbers(), List.of(3, 4, 5, 6, 7));
        assertEquals(result.getCount(), 5);

        result = Variant2.ForTask.printRange(0, 5);
        assertEquals(result.getNumbers(), List.of(0, 1, 2, 3, 4, 5));
        assertEquals(result.getCount(), 6);

        result = Variant2.ForTask.printRange(-3, 2);
        assertEquals(result.getNumbers(), List.of(-3, -2, -1, 0, 1, 2));
        assertEquals(result.getCount(), 6);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPrintRangeInvalidInput() {
        Variant2.ForTask.printRange(5, 3); // A не менше B
    }


    // while
    @Test
    public void testCountSegments() {
        assertEquals(Variant2.WhileTask.countSegments(10, 2), 5);  // 2 + 2 + 2 + 2 + 2 = 10
        assertEquals(Variant2.WhileTask.countSegments(15, 3), 5);  // 3 + 3 + 3 + 3 + 3 = 15
        assertEquals(Variant2.WhileTask.countSegments(7, 1), 7);   // 1 + 1 + 1 + 1 + 1 + 1 + 1 = 7
        assertEquals(Variant2.WhileTask.countSegments(9, 4), 2);   // 4 + 4 = 8, 9 - не можна
        assertEquals(Variant2.WhileTask.countSegments(8, 3), 2);   // 3 + 3 = 6, 8 - не можна
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCountSegmentsInvalidInput() {
        Variant2.WhileTask.countSegments(5, 5);  // A не більше B
        Variant2.WhileTask.countSegments(0, 2);  // A не позитивне
        Variant2.WhileTask.countSegments(2, 0);  // B не позитивне
    }

    // array
    @Test
    public void testGeneratePowersOfTwo() {
        assertEquals(Variant2.ArrayTask.generatePowersOfTwo(1), new int[]{1});
        assertEquals(Variant2.ArrayTask.generatePowersOfTwo(2), new int[]{1, 2});
        assertEquals(Variant2.ArrayTask.generatePowersOfTwo(3), new int[]{1, 2, 4});
        assertEquals(Variant2.ArrayTask.generatePowersOfTwo(4), new int[]{1, 2, 4, 8});
        assertEquals(Variant2.ArrayTask.generatePowersOfTwo(5), new int[]{1, 2, 4, 8, 16});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGeneratePowersOfTwoInvalidInput() {
        Variant2.ArrayTask.generatePowersOfTwo(0);
        Variant2.ArrayTask.generatePowersOfTwo(-5);
    }


    // martix
    @Test
    public void testGenerateMatrix() {
        int[][] matrix = Variant2.MatrixTask.generateMatrix(3, 4);
        assertEquals(matrix[0], new int[]{5, 10, 15, 20});
        assertEquals(matrix[1], new int[]{5, 10, 15, 20});
        assertEquals(matrix[2], new int[]{5, 10, 15, 20});

        matrix = Variant2.MatrixTask.generateMatrix(2, 5);
        assertEquals(matrix[0], new int[]{5, 10, 15, 20, 25});
        assertEquals(matrix[1], new int[]{5, 10, 15, 20, 25});

        matrix = Variant2.MatrixTask.generateMatrix(4, 2);
        assertEquals(matrix[0], new int[]{5, 10});
        assertEquals(matrix[1], new int[]{5, 10});
        assertEquals(matrix[2], new int[]{5, 10});
        assertEquals(matrix[3], new int[]{5, 10});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGenerateMatrixInvalidDimensions() {
        Variant2.MatrixTask.generateMatrix(1, 5); // M < 2
        Variant2.MatrixTask.generateMatrix(5, 1); // N < 2
        Variant2.MatrixTask.generateMatrix(11, 5); // M > 10
        Variant2.MatrixTask.generateMatrix(5, 11); // N > 10
    }
}


