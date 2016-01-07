package xyz.incraft.Sample3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import xyz.incraft.Sample3.dbmodel.MyItem;
import xyz.incraft.Sample3.dbmodel.SimpleItem;

import java.util.List;

/**
 * Created by Михаил on 07.01.2016.
 *
 */
public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        try(SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();){

            session.beginTransaction();
            List<MyItem> result = session.createQuery( "from MyItem " ).list();
            session.getTransaction().commit();

            for (MyItem item : result) {
                System.out.println(item.getSi1().getName() + " - " + item.getSi2().getName());
            }
        }

        System.out.println("All done");
        StandardServiceRegistryBuilder.destroy( registry );
    }
}
