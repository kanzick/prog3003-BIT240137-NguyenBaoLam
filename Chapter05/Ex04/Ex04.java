import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

class QueryProducts {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            String hql = "FROM Product p WHERE p.price > 1000";
            List<Product> products = session.createQuery(hql, Product.class)
                    .getResultList();

            for (Product p : products) {
                System.out.println(p.getId() + " - " + p.getName() + " - " + p.getPrice());
            }

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
