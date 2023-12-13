import java.util.ArrayList;
import java.util.List;

public class ToDoList{

    private User user;
    private List<Task> taskList;
    private EmailSenderService emailSenderService;

    public ToDoList(User user) {
        if(user.isValid()){
            this.taskList = new ArrayList<>();
            this.user = user;
            this.emailSenderService = new EmailSenderService();
        }
        else
            throw new IllegalArgumentException();
    }
    
    public boolean addTask(Task task) {
        for (Task t : taskList) {
            if (t.getName().equals(task.getName())) {
                System.out.println("Une tâche avec ce nom existe déjà");
                return false;
            }
        }
        if (taskList.size() > 0) {
            Task lastTask = taskList.get(taskList.size() - 1);
            if (task.getCreationDate().getTime() - lastTask.getCreationDate().getTime() < 1800000) {
                System.out.println("Vous ne pouvez pas ajouter plus de 2 tâches en 30 minutes");
                return false;
            }
        }
        if (task.getContent().length() > 1000) {
            System.out.println("Le contenu de la tâche ne doit pas dépasser 1000 caractères");
            return false;
        }
        taskList.add(task);

        if (taskList.size() == 8){
            System.out.println("Vous avez atteint 8 tâches, vous allez recevoir un email de rappel");
            if(emailSenderService.sendEmail(user.getEmail()))
                System.out.println("Email envoyé");
        }

//        if(save())
//            System.out.println("Tâche ajoutée");
//        else
//            System.out.println("Erreur lors de l'ajout de la tâche");
        return true;
    }


}