package armen.springbootmillionaires;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ConsoleMain {


    public static void main(String[] args) {

        SpringApplication.run(ConsoleMain.class, args);


    }
}