package collection;

/*
 * Класс с объявлениями внутренних классов
 */
public class InternalClassContainer {

    public static class PublicStaticExample {
    }

    static class StaticExample {
    }

    public class PublicExample {
    }

    class Example {
    }

    // Демонстрация вызова внутренних классов в методе
    public void test() {
        InternalClassContainer.PublicStaticExample e1 = new InternalClassContainer.PublicStaticExample();
        InternalClassContainer.StaticExample e2 = new InternalClassContainer.StaticExample();
        InternalClassContainer.PublicExample e3 = new InternalClassContainer.PublicExample();
        InternalClassContainer.Example e4 = new InternalClassContainer.Example();

        // Пример объявления класса внутри метода
        class LocalExample {
        }
        LocalExample le = new LocalExample();

        // Пример создания анонимного класса
        Object obj = new Object() {
            @Override
            public String toString() {
                return "Class:" + super.toString();
            }
        };
    }

    // Демонстрация вызова внутренних классов в статическом методе
    public static void staticTest() {
        InternalClassContainer.PublicStaticExample e1 = new InternalClassContainer.PublicStaticExample();
        InternalClassContainer.StaticExample e2 = new InternalClassContainer.StaticExample();
        //InternalClassContainer.PublicExample e3 = new InternalClassContainer.PublicExample();
        //InternalClassContainer.Example e4 = new InternalClassContainer.Example();
    }
}
