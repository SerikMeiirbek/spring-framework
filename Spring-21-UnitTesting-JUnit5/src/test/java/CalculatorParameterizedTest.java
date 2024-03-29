import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings={"Java", "JS", "TS"})
    void testCase1(String args){
        Assertions.assertTrue(!args.isEmpty());
    }

    /* Steps to run with maven command
     mvn -Dtest=TestCircle#mytest test
     maven-surefire-plugin
     mvn clean
     */

    @ParameterizedTest
    @ValueSource(ints={3,6,9})
    void testCase2(int numbers){
        Assertions.assertEquals(0, numbers % 3);
    }

    @ParameterizedTest
    @ValueSource(strings={"Java", "JS", "TS"})
//    @EmptySource
//    @NullSource
//    @NullAndEmptySource
    void testCase3(String args){
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg){
        Assertions.assertNotNull(arg);
    }

    static String[] stringProvider(){
        return new String []{"Java", "JS", "TS"};
    }

    @ParameterizedTest
    @CsvSource({"10,20,30", "20,20,40","30,20,50"})
    void testCase5(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1,num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1,num2));
    }
}
