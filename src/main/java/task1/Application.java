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
            manager.getCurriculumById(5).ifPresent(user -> System.out.println(user.getName()));
        } catch (NoEntityException e) {
            e.printStackTrace();
        }
        System.out.println("Log: end");
    }
}
