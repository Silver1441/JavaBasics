package task1;


import task1.exception.NoEntityException;
import task1.repomanager.CurriculumRepositoryManager;
import task1.repomanager.CurriculumRepositoryManagerImpl;
import task1.repository.CurriculumRepository;
import task1.repository.CurriculumRepositoryImpl;
import task1.service.demo.DemoDispatcher;
import task1.service.demo.DemoDispatcherImpl;

import java.text.DecimalFormat;

public class Application {

    public static void main(String[] args) {
        /*DemoDispatcher demo = new DemoDispatcherImpl();
        demo.makeDemo();*/

        DecimalFormat df = new DecimalFormat("#.#");
        String result = df.format(Math.random());
        result = result.replace(",", ".");
        double d = Double.valueOf(result);

        System.out.println(d);



        System.out.println("Log: end");
    }
}
