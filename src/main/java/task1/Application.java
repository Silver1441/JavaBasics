package task1;

import task1.service.demo.DemoDispatcher;
import task1.service.demo.DemoDispatcherImpl;


public class Application {

    public static void main(String[] args) {
        DemoDispatcher demo = new DemoDispatcherImpl();
        demo.makeDemo();
    }
}
