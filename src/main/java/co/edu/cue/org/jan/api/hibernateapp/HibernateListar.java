package co.edu.cue.org.jan.api.hibernateapp;

import co.edu.cue.org.jan.api.hibernateapp.entity.Cliente;
import jakarta.persistence.EntityManager;
import co.edu.cue.org.jan.api.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {

        EntityManager cm = JpaUtil.getEntityManager();
        List<Cliente> clientes = cm.createQuery("select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        cm.close();
    }
}
