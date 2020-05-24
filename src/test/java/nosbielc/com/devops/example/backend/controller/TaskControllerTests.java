package nosbielc.com.devops.example.backend.controller;

import nosbielc.com.devops.example.backend.model.Task;
import nosbielc.com.devops.example.backend.repository.TaskRepo;
import nosbielc.com.devops.example.backend.utils.ValidationException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 23/05/2020
 * @project devops-example-backend
 */
public class TaskControllerTests {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
        controller.findAll();
        Mockito.verify(taskRepo).findAll();
    }

    @Test
    public void naoDeveSalvarTarefaSemDescricao() {
        Task todo = new Task();
        todo.setDueDate(LocalDate.now());
        try {
            controller.save(todo);
            Assert.fail("Houve uma falha no desenho do teste.");
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarTarefaSemData() {
        Task todo = new Task();
        todo.setTask(" - ");
        try {
            controller.save(todo);
            Assert.fail("Houve uma falha no desenho do teste.");
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarTarefaComDataPassada() {
        Task todo = new Task();
        todo.setDueDate(LocalDate.now().minusDays(1));
        todo.setTask(" - ");
        try {
            controller.save(todo);
            Assert.fail("Houve uma falha no desenho do teste.");
        } catch (ValidationException e) {
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void deveSalvarTarefaComSucesso() throws Exception {
        Task todo = new Task();
        todo.setDueDate(LocalDate.now().plusDays(1));
        todo.setTask(" - ");
        controller.save(todo);

        Mockito.verify(taskRepo).save(todo);
    }
}