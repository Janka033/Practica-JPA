package co.edu.cue.org.jan.api.hibernateapp;

import co.edu.cue.org.jan.api.hibernateapp.entity.Cliente;
import jakarta.persistence.EntityManager;
import co.edu.cue.org.jan.api.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingresa el id del cliente a modificar"));
            Cliente c = em.find(Cliente.class,id);

            String nombre = JOptionPane.showInputDialog("Ingrese nombre:",c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese apellido:",c.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrese forma de pago:",c.getFormaPago());
            em.getTransaction().begin();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.merge(c);
            em.getTransaction().commit();

            System.out.println(c);

        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}
