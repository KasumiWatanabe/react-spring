package com.udemy.react-spring;

-spring.model.Item;
import com.udemy.react-spring.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class react-springApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(react-springApplication.class);
    }

    @Autowired
    private ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(react-springApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.save(new Item("ネックレス", "ジュエリ"));
        itemRepository.save(new Item("パーカー", "ファッション"));
        itemRepository.save(new Item("フェイスクリーム", "ビューティ"));
        itemRepository.save(new Item("サプリメント", "ジュエリ"));
        itemRepository.save(new Item("ブルーベリー", "フード"));
    }
}
