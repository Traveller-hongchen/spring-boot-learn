package tacos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebConfig implements WebMvcConfigurer {

    /**
     * 用处和HomeController里的第一个跳转一样，现在可以删掉里面的了
     * 不过由于是学习过程，注释掉那个更可取一点
     * 这是通过实现WebMvcConfigurer接口并且重写addViewControllers方法
     * 完成的
     * 该方法可以注册多个视图控制器
     * <p>
     * 或许应该将所有get请求导致的页面指示都写在这里？
     * 电子书将这个方法放到了TacoCloudApplication里
     * 实现该接口，但是为什么呢？
     */

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}
