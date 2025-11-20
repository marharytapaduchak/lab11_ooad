package ucu.edu.ua.task3;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    @Test
    public void testLazyLoading() throws Exception {
        ProxyImage proxy = new ProxyImage("test.png");

        assertNull(getRealImage(proxy));

        proxy.display();

        assertNotNull(getRealImage(proxy));
    }

    private RealImage getRealImage(ProxyImage proxy) throws Exception {
        Field field = ProxyImage.class.getDeclaredField("realImage");
        field.setAccessible(true);
        return (RealImage) field.get(proxy);
    }
}
