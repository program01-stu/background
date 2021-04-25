package web;

import domain.*;
import service.GoodsService;
import service.Impl.GoodsServiceImpl;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( value="/show/*",asyncSupported =true)

public class ShowServlet extends BaseServlet {
    private static GoodsService service=new GoodsServiceImpl();
    public void showAllPhones(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Phone>  phones = service.findAllPhone();
        if (phones!=null){
            writeValue(phones,response);
        }
    }

    public void showAllElectrical(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Electrical> electrical = service.findAllElectrical();
        if (electrical!=null){
            writeValue(electrical,response);
        }
    }

    public void showPhonesLimit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Phone> phones = service.findPhoneInLimit();
        if (phones!=null){
            writeValue(phones,response);
        }
    }

    public void showPhoneDetails(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String pid = request.getParameter("pid");
        Phone phone = service.showPhoneDetails(Integer.parseInt(pid));
        writeValue(phone,response);
    }

    public void showAllHeadset(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Headset> headset = service.findAllHeadset();
        if (headset!=null){
            writeValue(headset,response);
        }
    }
    public void showAllOutdoor(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Outdoor> outdoor = service.findAllOutdoor();
        if (outdoor!=null){
            writeValue(outdoor,response);
        }
    }
    public void showAllPower_supply(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Power_supply> power_supply = service.findAllPower_supply();
        if (power_supply!=null){
            writeValue(power_supply,response);
        }
    }
    public void showAllHealthy(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Healthy> healthy = service.findAllHealthy();
        if (healthy!=null){
            writeValue(healthy,response);
        }
    }
    public void showAllLive(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Live> live = service.findAllLive();
        if (live!=null){
            writeValue(live,response);
        }
    }
    public void showAllNotebook(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Notebook> notebook = service.findAllNotebook();
        if (notebook!=null){
            writeValue(notebook,response);
        }
    }
    public void showAllIntelligence(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Intelligence> intelligence = service.findAllIntelligence();
        if (intelligence!=null){
            writeValue(intelligence,response);
        }
    }

}
