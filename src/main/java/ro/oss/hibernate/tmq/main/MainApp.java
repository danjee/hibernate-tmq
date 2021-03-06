package ro.oss.hibernate.tmq.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.oss.hibernate.tmq.domain.*;
import ro.oss.hibernate.tmq.spring.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        Credential credential = Credential.CredentialBuilder.builder()
                .withPassword("12345")
                .withPersistent(Persistent.PersistentBuilder.builder().withStatus(EntityStatus.NA).withDeleted(false).build())
                .build();
        UserAttribute userAttribute1 = UserAttribute.UserAttributeBuilder.builder()
                .withType(UserAttributeType.DETAILS)
                .withKey("key1")
                .withValue("valoare1")
                .withScope(AttributeScope.DEFAULT)
                .withName("name1")
                .withPersistent(Persistent.PersistentBuilder.builder().withStatus(EntityStatus.NA).withDeleted(false).build())
                .build();
        UserAttribute userAttribute2 = UserAttribute.UserAttributeBuilder.builder()
                .withType(UserAttributeType.DETAILS)
                .withKey("key2")
                .withValue("valoare2")
                .withScope(AttributeScope.DEFAULT)
                .withName("name2")
                .withPersistent(Persistent.PersistentBuilder.builder().withStatus(EntityStatus.NA).withDeleted(false).build())
                .build();
        UserAttribute userAttribute3 = UserAttribute.UserAttributeBuilder.builder()
                .withType(UserAttributeType.DETAILS)
                .withKey("key3")
                .withValue("valoare3")
                .withScope(AttributeScope.DEFAULT)
                .withName("name3")
                .withPersistent(Persistent.PersistentBuilder.builder().withStatus(EntityStatus.NA).withDeleted(false).build())
                .build();


        User user = User.UserBuilder.builder()
                .withUsername("username-" + System.currentTimeMillis())
                .withCredential(credential)
                .withPersistent(Persistent.PersistentBuilder.builder().withStatus(EntityStatus.NA).withDeleted(false).build())
                .build();

        userAttribute1.setUser(user);
        userAttribute2.setUser(user);
        userAttribute3.setUser(user);

        user.setAttributes(List.of(userAttribute1, userAttribute2, userAttribute3));

        EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(user);

        manager.getTransaction().commit();
        manager.close();
//        UserRepository repository = context.getBean(UserRepository.class);
//        repository.save(user);

    }
}

