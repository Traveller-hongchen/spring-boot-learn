package tacos.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.Taco;
import tacos.Ingredient;
import tacos.Ingredient.Type;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author 红尘渡者
 */
@Slf4j //一种日志记录器
@Controller //标识该类为控制器
@RequestMapping("/design") //该注解在类级应用时，指定该控制器处理的请求的类型
// 在本例中，它指定该类将处理路径以 /design 开头的请求
public class DesignTacoController {

    @GetMapping //与requestMapping成对使用
    /**收到get请求所执行的方法
     * Model （模型） 大概是代指发送到前端的数据吧
     * 最后的返回应该还是跳转的意思！！！
     * 或许可以确信就是这样的
     */

    public String showDesignFrom(Model model){
        //创建一个Ingredient的List泛型数组，存储数据
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        //创建一个Type数组，存储Ingredient的所有Type(其实就5个啦)
        Type[] types = Ingredient.Type.values();
        //遍历所有5个Type
        for (Type type : types) {
            //向前端传输数据，数据按 key : value 键值对？
            model.addAttribute(type.toString().toLowerCase(),
                    //调用函数，将所被遍历的Type对应的Ingredient的对象传过去
                    filterByType(ingredients, type));
        }

        //这里不是很懂,或许是传过去一个taco对象的引用？
        model.addAttribute("design", new Taco());
        return "design";
    }
    //挑选与传入Type相应的Ingredient，做成List泛型数组返回
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    /**
     * 如果我没理解错，这个就是用来处理post请求的,请求的页面是"/disgen"
     * 请求的data就是传进来的这个Taco design了吧
     * 不过最后的这个是跳转到哪里去了？
     * 额，，，看了下自己注释，第三章会完成这个页面吧。。。
     */

    public String processDesign(Taco design) {
        // 保存这个taco设计。。。
        // 但是我看着咋是日志保存起来了。。。
        // 我们将在第三章完成该页面
        log.info("Processing design: " + design);
        //redirect: 被称为重定向视图, 表示并非到"/orders/current.html"的页面
        //而是一个get请求
        return "redirect:/orders/current";
    }

}