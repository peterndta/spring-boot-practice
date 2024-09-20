import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before");
    }

    @Test
    void test1(){
        System.out.println("1");
    }

    @Test
    void test2(){
        System.out.println("2");
    }

    @Test
    void test3(){
        System.out.println("3");
    }
}
