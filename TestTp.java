import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.beans.Transient;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestTp {

    private User user;
    private ToDoList toDoList;

    EmailSenderService emailSenderServiceMock;
    ToDoListBis toDoListMock;

    Task taskMock, taskMock2;


    @Before
    public void setup() {
        this.user = new User("email@esgi.fr",
                    "Sebastien",
                    "Grand",
                    "Password123",
                    20);
    }

    @Test
    public void testIsEmailValid() {
        Assert.assertTrue(user.isValid());
    }

    @Test
    public void testIsEmailNotValid() {
        user.setEmail("test");
        Assert.assertFalse(user.isValid());
    }

    @Test
    public void testIsPasswordValid() {
        Assert.assertTrue(user.isValid());
    }

    @Test
    public void testIsPasswordNotValid() {
        user.setPassword("test");
        Assert.assertFalse(user.isValid());
    }

    @Test
    public void testIsAgeValid() {
        Assert.assertTrue(user.isValid());
    }

    @Test
    public void testIsAgeNotValid() {
        user.setAge(10);
        Assert.assertFalse(user.isValid());
    }

    @Test
    public void testIsFirstNameValid() {
        Assert.assertTrue(user.isValid());
    }

    @Test
    public void testIsFirstNameNotValid() {
        user.setFirstName("");
        Assert.assertFalse(user.isValid());
    }

    @Test
    public void testIsLastNameValid() {
        Assert.assertTrue(user.isValid());
    }

    @Test
    public void testIsLastNameNotValid() {
        user.setLastName("");
        Assert.assertFalse(user.isValid());
    }

    @Test
    public void testCreationToDoList() {
        this.toDoList = new ToDoList(user);
        Assert.assertNotNull(toDoList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationToDoListWithInvalidUser() {
        user.setEmail("test");
        this.toDoList = new ToDoList(user);
    }

    @Test
    public void testAddTaskValid() {
        this.toDoList = new ToDoList(user);
        Task task = new Task("name", "content");
        Assert.assertTrue(toDoList.addTask(task));
    }

    @Test
    public void testAddTaskWithExistingName() {
        this.toDoList = new ToDoList(user);
        Task task = new Task("name", "content");
        toDoList.addTask(task);
        Assert.assertFalse(toDoList.addTask(task));
    }

    @Test
    public void testAddTaskWithMoreThanTwoTasksInThirtyMinutes() {
        this.toDoList = new ToDoList(user);
        Task task = new Task("name", "content");
        Task task3 = new Task("name3", "content3");
        toDoList.addTask(task);
        Assert.assertFalse(toDoList.addTask(task3));
    }

    @Test
    public void testTenTasks() {
        this.toDoListMock = new ToDoListBis(user);
        Task task = new Task("name", "content", java.sql.Date.valueOf(LocalDate.now().minusDays(10)));
        Task task2 = new Task("name2", "content2", java.sql.Date.valueOf(LocalDate.now().minusDays(9)));
        Task task3 = new Task("name3", "content3", java.sql.Date.valueOf(LocalDate.now().minusDays(8)));
        Task task4 = new Task("name4", "content4", java.sql.Date.valueOf(LocalDate.now().minusDays(7)));
        Task task5 = new Task("name5", "content5", java.sql.Date.valueOf(LocalDate.now().minusDays(6)));
        Task task6 = new Task("name6", "content6", java.sql.Date.valueOf(LocalDate.now().minusDays(5)));
        Task task7 = new Task("name7", "content7", java.sql.Date.valueOf(LocalDate.now().minusDays(4)));
        Task task8 = new Task("name8", "content8", java.sql.Date.valueOf(LocalDate.now().minusDays(3)));
        Task task9 = new Task("name9", "content9", java.sql.Date.valueOf(LocalDate.now().minusDays(2)));
        Task task10 = new Task("name10", "content10", java.sql.Date.valueOf(LocalDate.now().minusDays(1)));
        this.emailSenderServiceMock = Mockito.mock(EmailSenderService.class);
        when(emailSenderServiceMock.sendEmail(anyString())).thenReturn(true);
        toDoListMock.addTask(task, emailSenderServiceMock);
        toDoListMock.addTask(task2, emailSenderServiceMock);
        toDoListMock.addTask(task3, emailSenderServiceMock);
        toDoListMock.addTask(task4, emailSenderServiceMock);
        toDoListMock.addTask(task5, emailSenderServiceMock);
        toDoListMock.addTask(task6, emailSenderServiceMock);
        toDoListMock.addTask(task7, emailSenderServiceMock);
        toDoListMock.addTask(task8, emailSenderServiceMock);
        toDoListMock.addTask(task9, emailSenderServiceMock);
        toDoListMock.addTask(task10, emailSenderServiceMock);

    }

    @Test
    public void testSave(){
        taskMock  = new Task("name", "content");
        this.taskMock = Mockito.mock(Task.class);
        when(taskMock.save()).thenReturn(true);
        Assert.assertTrue(taskMock.save());
    }

//    @Test
//    public void testAddTasksAndSaveTrueAndFalse(){
//        this.toDoListMock = new ToDoListBis(user);
//        taskMock = new Task("name", "content");
//        this.taskMock = Mockito.mock(Task.class);
//        when(taskMock.save()).thenReturn(true);
//        taskMock2 = new Task("name", "content");
//        this.taskMock2 = Mockito.mock(Task.class);
//        when(taskMock2.save()).thenReturn(false);
//        toDoListMock.addTask(taskMock, emailSenderServiceMock);
//        toDoListMock.addTask(taskMock2, emailSenderServiceMock);
//    }
}
