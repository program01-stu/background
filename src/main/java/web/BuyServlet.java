package web;

import service.GoodsService;
import service.Impl.GoodsServiceImpl;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/buy/*")
public class BuyServlet extends BaseServlet {
    private static GoodsService service=new GoodsServiceImpl();
    public void buyPhone(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String pid = request.getParameter("pid");
        String money = request.getParameter("money");
        int Ok = service.buyGood(Integer.parseInt(pid), 1, money);
        if (Ok>0){
            writeValueAsString("购买成功",response);
        }else {
            writeValueAsString("购买失败，请与商家联系",response);
        }

    }


}
