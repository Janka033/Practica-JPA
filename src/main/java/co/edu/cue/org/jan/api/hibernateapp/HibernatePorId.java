package co.edu.cue.org.jan.api.hibernateapp;

import co.edu.cue.org.jan.api.hibernateapp.entity.Cliente;
import co.edu.cue.org.jan.api.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class HibernatePorId {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Cliente  c where c.id=?1", Cliente.class);
        System.out.println("Ingrese el Id");
        Long pago = s.nextLong();
        query.setParameter(1, pago);
        Cliente c = (Cliente) query.getSingleResult();
        System.out.println(c);
        em.close();
    }
}
