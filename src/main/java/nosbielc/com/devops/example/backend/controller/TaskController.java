package nosbielc.com.devops.example.backend.controller;

import nosbielc.com.devops.example.backend.model.Task;
import nosbielc.com.devops.example.backend.repository.TaskRepo;
import nosbielc.com.devops.example.backend.utils.DateUtils;
import nosbielc.com.devops.example.backend.utils.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 19/05/2020
 * @project devops-example-backend
 */
@RestController
@RequestMapping(value ="/todo")
public class TaskController {

    private TaskRepo todoRepo;

    @Autowired
    public TaskController(TaskRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @GetMapping
    public List<Task> findAll() {
        return todoRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task todo) throws ValidationException {
        if(todo.getTask() == null || todo.getTask() == "") {
            throw new ValidationException("Fill the task description");
        }
        if(todo.getDueDate() == null) {
            throw new ValidationException("Fill the due date");
        }
        if(!DateUtils.isEqualOrFutureDate(todo.getDueDate())) {
            throw new ValidationException("Due date must not be in past");
        }
        Task saved = todoRepo.save(todo);
        return new ResponseEntity<Task>(saved, HttpStatus.CREATED);
    }
}
