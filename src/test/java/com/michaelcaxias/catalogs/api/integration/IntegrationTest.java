package com.michaelcaxias.catalogs.api.integration;

import com.michaelcaxias.catalogs.api.Application;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class IntegrationTest {
}
