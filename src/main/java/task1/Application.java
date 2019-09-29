package task1;


import task1.exception.NoEntityException;
import task1.repomanager.CurriculumRepositoryManager;
import task1.repomanager.CurriculumRepositoryManagerImpl;
import task1.repository.CurriculumRepository;
import task1.repository.CurriculumRepositoryImpl;
import task1.service.demo.DemoDispatcher;
import task1.service.demo.DemoDispatcherImpl;

public class Application {

    public static void main(String[] args) {
        /*DemoDispatcher demo = new DemoDispatcherImpl();
        demo.makeDemo();*/
        CurriculumRepository repo = new CurriculumRepositoryImpl();
        CurriculumRepositoryManager manager = new CurriculumRepositoryManagerImpl(repo);
        try {
            System.out.println(manager.getCurriculumById(3).getName());
        } catch (NoEntityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Log: end");
    }
}
