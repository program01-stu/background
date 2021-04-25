package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.*;

import java.util.List;

public interface GoodsDao {
     List<Phone>  findAllPhone() throws JsonProcessingException;
     List<Intelligence> findAllIntelligence() throws JsonProcessingException;
     List<Notebook> findAllNotebook() throws JsonProcessingException;
     List<Outdoor>  findAllOutdoor() throws JsonProcessingException;
     List<Power_supply>  findAllPower_supply() throws JsonProcessingException;
     List<Healthy>  findAllHealthy() throws JsonProcessingException;
     List<Live>  findAllLive() throws JsonProcessingException;
     List<Electrical>  findAllElectrical() throws JsonProcessingException;
     List<Headset>  findAllHeadset() throws JsonProcessingException;
     List<Phone> findPhoneInLimit();
     Phone showPhoneDetails(int id);
     int updateUserBuy(int pid,int uid,String money);
}
