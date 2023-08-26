package com.sarasavi.nansala.configuration;

import com.sarasavi.nansala.model.Book;
import com.sarasavi.nansala.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    BookRepository bookRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            log.info("Preloading " + bookRepository.save(Book.builder().bookId("#67632e7").title("Harry Potter and the Philosopher's Stone").author("J. K. Rowling").build()));
            log.info("Preloading " + bookRepository.save(Book.builder().bookId("#17232d9").title("Harry Potter and the Chamber of Secrets").author("J. K. Rowling").build()));
            log.info("Preloading " + bookRepository.save(Book.builder().bookId("#17232d9").title("Harry Potter and the Chamber of Secrets").author("J. K. Rowling").build()));
            log.info("Preloading " + bookRepository.save(Book.builder().bookId("#56762j8").title("Five on a Treasure Island").author("Enid Blyton").build()));
        };
    }

}
