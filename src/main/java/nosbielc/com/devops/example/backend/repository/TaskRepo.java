package nosbielc.com.devops.example.backend.repository;

import nosbielc.com.devops.example.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 19/05/2020
 * @project devops-example-backend
 */
public interface TaskRepo extends JpaRepository<Task, Long> {

}
