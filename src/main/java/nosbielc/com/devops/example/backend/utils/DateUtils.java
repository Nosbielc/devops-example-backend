package nosbielc.com.devops.example.backend.utils;

import java.time.LocalDate;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 19/05/2020
 * @project devops-example-backend
 */
public class DateUtils {

    public static boolean isEqualOrFutureDate(LocalDate date) {
        return date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now());
    }
}
