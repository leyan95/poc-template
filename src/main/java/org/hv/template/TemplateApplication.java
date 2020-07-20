package org.hv.template;

import org.hv.pocket.session.Session;
import org.hv.pocket.session.SessionFactory;
import org.hv.pocket.session.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujianchuan
 */
@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"org.hv.*"})
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String persistenceTest() {
        OrderType orderType = new OrderType();
        Session session = SessionFactory.getSession("template");
        session.open();
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();
            orderType.setName("测试Alpha");
            session.save(orderType);
            orderType.setName("测试Beta");
            session.update(orderType);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollBack();
            }
        } finally {
            session.close();
        }
        return orderType.getName();
    }
}
