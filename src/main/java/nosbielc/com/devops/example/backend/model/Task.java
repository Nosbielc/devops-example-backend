package nosbielc.com.devops.example.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 19/05/2020
 * @project devops-example-backend
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String task;

    @Column(nullable = false)
    private LocalDate dueDate;
}
