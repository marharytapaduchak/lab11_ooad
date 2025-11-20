package ucu.edu.ua.task3;

import org.junit.jupiter.api.Test;

import java.awt.GraphicsEnvironment;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    @Test
    public void testLazyLoading() throws Exception {
        // На CI (GitHub Actions) немає графічного середовища → пропускаємо тест
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }

        ProxyImage proxy = new ProxyImage("test.png");

        // Перед display() реальний об'єкт ще не створений
        assertNull(getRealImage(proxy));

        // Викликаємо display() – це має створити RealImage
        proxy.display();

        // Після першого display() всередині ProxyImage вже має бути RealImage
        assertNotNull(getRealImage(proxy));
    }

    // Reflection, щоб дістати private поле realImage
    private RealImage getRealImage(ProxyImage proxy) throws Exception {
        Field field = ProxyImage.class.getDeclaredField("realImage");
        field.setAccessible(true);
        return (RealImage) field.get(proxy);
    }
}
