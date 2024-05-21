package co.edu.cue.org.jan.api.hibernateapp;

import co.edu.cue.org.jan.api.hibernateapp.entity.Cliente;
import co.edu.cue.org.jan.api.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernateEliminar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a eliminar:");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }
}