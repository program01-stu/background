package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.*;

import java.io.IOException;
import java.util.List;

public interface GoodsService {

    List<Phone>  findAllPhone() throws IOException;
    List<Intelligence>  findAllIntelligence() throws IOException;
    List<Notebook>  findAllNotebook() throws IOException;
    List<Outdoor>  findAllOutdoor() throws IOException;
    List<Power_supply>  findAllPower_supply() throws  IOException;
    List<Healthy>  findAllHealthy() throws  IOException;
    List<Live>  findAllLive() throws IOException;
    List<Electrical>  findAllElectrical() throws IOException;
    List<Headset>  findAllHeadset() throws IOException;

    List<Phone> findPhoneInLimit();
    Phone showPhoneDetails(int id);
    int buyGood(int pid,int uid,String money);
}
