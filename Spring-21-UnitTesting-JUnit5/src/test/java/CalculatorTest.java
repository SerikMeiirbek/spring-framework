import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCase1(){
//        fail("Not implemented");
    }

    @Test
    void testCase2(){
        assertEquals("add", Calculator.operator);
    }

    @Test
    @Disabled
    void testCase3(){
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
    }

    @Test
    void testCase4(){
        String nullString = null;
        String notNullString = "cydeo";
        assertNull(nullString);
        assertNotNull(notNullString);
    }

    @Test
    void testCase5(){
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        assertSame(c1,c2);
    }

    @Test
    void add() {
        int actual = Calculator.add(2,3);
        assertEquals(5, actual, "it's not matching expected value");
    }

    @Test
    void add2() {
        assertThrows(IllegalArgumentException.class, ()->Calculator.add2(3,2));
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("BeforeEach is executed");
    }

    @AfterEach
    void afterEach(){
        System.out.println("AfterEach is executed");
    }

    @AfterAll
    static void  afterAll(){
        System.out.println("AfterAll is executed");
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all");
    }

}