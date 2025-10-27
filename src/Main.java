import controller.BankController;
import repository.BankRepository;

public class Main {
    public static void main(String[] args) throws Exception {


                BankRepository repository = new BankRepository();
                BankController controller = new BankController(repository);
                controller.simulate();
            }
        }

