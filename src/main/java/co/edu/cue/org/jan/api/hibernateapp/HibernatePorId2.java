package co.edu.cue.org.jan.api.hibernateapp;

import jakarta.persistence.EntityManager;
import co.edu.cue.org.jan.api.hibernateapp.entity.Cliente;
import co.edu.cue.org.jan.api.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HibernatePorId2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese el Id");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);

        Cliente cliente2 = em.find(Cliente.class, id);
        System.out.println(cliente2);
        em.close();
    }
}
