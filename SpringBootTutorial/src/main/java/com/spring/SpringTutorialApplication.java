package com.spring;

import com.base.kafka.util.FileStorageProperties;
import com.spring.model.Dress;
import com.spring.model.GirlFriend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
@EnableEurekaClient
@EnableConfigurationProperties({
        FileStorageProperties.class
})
@ComponentScan({"com.spring.*"})
public class SpringTutorialApplication {
    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(SpringTutorialApplication.class, args);
        SpringApplication.run(SpringTutorialApplication.class, args);

//          @Component
//        Outfit dress = context.getBean(Outfit.class);
//
//        System.out.println("Instance Dress: "+dress);
//        //do interface k the tao 1 truc tiep 1 object => container da tu dong tim trong context va tu tao ra obj Dress do impl outfit
//        //Instance Dress: com.spring.model.Dress@3122b117UserRepository

//        dress.wear();


//          @ComponentScan
//        Bikini bikini = context.getBean(Bikini.class);
//        System.out.println("Instance bikini: "+ bikini);
//        bikini.wear();
//
//        System.out.println("==============================");
//
//        Dress dress = context.getBean(Dress.class);
//        System.out.println("Instance dress: "+ dress);
//        dress.wear();

//            @Autowired
//        GirlFriend girlFriend = context.getBean(GirlFriend.class);
//        System.out.println("Instance GirlFriend: "+girlFriend);
//        System.out.println("Outfit of GirlFriend: "+ girlFriend.outfit);
//        girlFriend.outfit.wear();

//        @Scope m???c ?????nh l?? singleton => c??ng tr??? v??o 1 ?? nh???,
//        khi 1 bean ???? t???o ra r, th?? context s??? t??? ?????ng laasy lu??n m?? kh??ng c???n ta???o ra 1 obj m???i n??a

//        Dress dress1 = context.getBean(Dress.class);
//        Dress dress2 = context.getBean(Dress.class);
//
//        System.out.println("Dress 1 : " + dress1);
//        System.out.println("Dress 2 : " + dress2);
        //khi ch??a thay ?????i thu???c t??nh Scope th?? 2 dress c??ng tr??? v??? 1 ?? nh???.
        //khi thay Scope("prototype") => t???o ra 2 instance
        //Dress 1 : com.spring.model.Dress@3b0ca5e1
        //Dress 2 : com.spring.model.Dress@5bb3131b

        //Khi 2 Bean ?????u impl 1 Interface , contaier kb ch???n bean n??o ????? inject vafo Girlfriend
//        GirlFriend girlFriend = context.getBean(GirlFriend.class);
//        System.out.println("Instance GirlFriend: " + girlFriend);
//        System.out.println("Outfit of GirlFriend: " + girlFriend.outfit);
    }

}
