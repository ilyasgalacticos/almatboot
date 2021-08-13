package kz.bitlab.almatgroup.almatboot.config;

import kz.bitlab.almatgroup.almatboot.beans.ItemManager;
import kz.bitlab.almatgroup.almatboot.beans.SecondBean;
import kz.bitlab.almatgroup.almatboot.beans.impl.MikhailItemManager;
import kz.bitlab.almatgroup.almatboot.beans.impl.MysqlItemManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeansConfig {

    @Bean(name = "secondBeanAikyn")
    @Scope("singleton")
    public SecondBean secondBean(){
        SecondBean sb = new SecondBean();
        sb.setText("Messi");
        sb.setNumber(30);
        return sb;
    }

    @Bean(name = "secondBeanKairat")
    @Scope("singleton")
    public SecondBean theSecondBean(){
        return new SecondBean("Ilyas", 232323);
    }

    @Bean(name = "mysqlConnectorBean")
    public ItemManager itemManager(){
        return new MysqlItemManager("jdbc:mysql://localhost:3306/almat_db?serverTimezone=UTC", "root", "");
    }

    @Bean(name = "mikhailConnectorBean")
    public ItemManager mikhailItemManager(){
        return new MikhailItemManager();
    }

}