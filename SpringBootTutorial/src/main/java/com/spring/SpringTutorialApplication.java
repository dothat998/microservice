package com.spring;

import com.base.kafka.util.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
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

//        @Scope mặc định là singleton => cùng trỏ vào 1 ô nhớ,
//        khi 1 bean đã tạo ra r, thì context sẽ tự động laasy luôn mà không cần taạo ra 1 obj mới nưa

//        Dress dress1 = context.getBean(Dress.class);
//        Dress dress2 = context.getBean(Dress.class);
//
//        System.out.println("Dress 1 : " + dress1);
//        System.out.println("Dress 2 : " + dress2);
        //khi chưa thay đổi thuộc tính Scope thì 2 dress cùng trỏ về 1 ô nhớ.
        //khi thay Scope("prototype") => tạo ra 2 instance
        //Dress 1 : com.spring.model.Dress@3b0ca5e1
        //Dress 2 : com.spring.model.Dress@5bb3131b

        //Khi 2 Bean đều impl 1 Interface , contaier kb chọn bean nào để inject vafo Girlfriend
//        GirlFriend girlFriend = context.getBean(GirlFriend.class);
//        System.out.println("Instance GirlFriend: " + girlFriend);
//        System.out.println("Outfit of GirlFriend: " + girlFriend.outfit);
    }

}
