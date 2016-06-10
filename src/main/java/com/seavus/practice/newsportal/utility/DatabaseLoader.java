package com.seavus.practice.newsportal.utility;

import com.seavus.practice.newsportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by MK on 09.06.2016.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}