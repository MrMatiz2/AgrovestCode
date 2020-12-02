package com.Agrovest;

import com.Agrovest.controller.LoginController;
import com.Agrovest.domain.Asesoria;
import com.Agrovest.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class AgrovestApplicationTests {

   @Autowired
   private LoginController controller;

    // Prueba unitaria: Registro correcto de usuarios - inversores en la aplicación
    @Test
    void userCreationTest() {

        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;

        User user = new User();
        user.setFullname("test");
        user.setEmail("test"+randomInt+"@test.com");
        user.setPassword("12345678");
        assertEquals(controller.createNewUsers(user), true);

    }

    // Prueba unitaria: Creacion correcta de la asesoría
    @Test
    void creationAsesoriaTest() {

        Asesoria asesoria = new Asesoria();

        asesoria.setUserName("Usuario");
        asesoria.setUserId("5f88d348ec08ba255334934e");
        asesoria.setAsunto("Test asesoria");
        asesoria.setDescripcion("Test para comprobar la creación de la asesoría");

        assertEquals(controller.saveAsesoria(asesoria), true);

    }


}