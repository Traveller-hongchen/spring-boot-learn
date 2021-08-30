package tacos;



import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import tacos.web.HomeController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(HomeController.class)
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestHello() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                //.andExpect(view().name("hello"))
                .andExpect(content().string(containsString("hello")));
    }
    @Test
    public void TestHome() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                //请求返回200
                .andExpect(view().name("home"))
                //请求返回视图名称为home
                .andExpect(content().string(containsString("TacoCloud.png")));
                //返回视图包含字符串Welcome to...
    }
}
