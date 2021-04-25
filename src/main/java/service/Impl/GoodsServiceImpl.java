package service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.GoodsDao;
import dao.Impl.GoodsDaoImpl;
import domain.*;
import redis.clients.jedis.Jedis;
import service.GoodsService;
import utils.JedisUtil;

import java.io.IOException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao=new GoodsDaoImpl();
    private Jedis jedis= JedisUtil.getJedis();
    @Override
    public List<Phone> findAllPhone() throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        String _phones = jedis.get("phones");
        if (_phones==null){
            List<Phone> phones = goodsDao.findAllPhone();
            String phoneJson = mapper.writeValueAsString(phones);
            System.out.println(phoneJson);
            jedis.set("phones",phoneJson);
            return phones;
        }
        List<Phone> phones1 = mapper.readValue(_phones, List.class);
        return phones1;
    }

    @Override
    public List<Intelligence> findAllIntelligence() throws IOException {
        String _intelligences = jedis.get("intelligences");
        ObjectMapper mapper=new ObjectMapper();
        if (_intelligences==null){
            List<Intelligence> intelligences = goodsDao.findAllIntelligence();

            String intelligenceJson = mapper.writeValueAsString(intelligences);
            System.out.println(intelligenceJson);
            jedis.set("intelligences",intelligenceJson);
            return intelligences;
        }
        List<Intelligence> intelligences1 = mapper.readValue(_intelligences, List.class);
        return intelligences1;
    }

    @Override
    public List<Notebook> findAllNotebook() throws IOException {
        String _notebooks = jedis.get("notebooks");
        ObjectMapper mapper=new ObjectMapper();
        if (_notebooks==null){
            List<Notebook> notebooks = goodsDao.findAllNotebook();

            String notebookJson = mapper.writeValueAsString(notebooks);
            jedis.set("notebooks",notebookJson);
            return notebooks;
        }
        List<Notebook> notebooks1 = mapper.readValue(_notebooks, List.class);
        return notebooks1;
    }

    @Override
    public List<Outdoor> findAllOutdoor() throws IOException {
        String _outdoors = jedis.get("outdoor");
        ObjectMapper mapper=new ObjectMapper();
        if (_outdoors==null){
            List<Outdoor> outdoors = goodsDao.findAllOutdoor();
            String outdoorJson = mapper.writeValueAsString(outdoors);
            jedis.set("outdoor",outdoorJson);
            return outdoors;
        }
        List<Outdoor> outdoors1 = mapper.readValue(_outdoors, List.class);
        return outdoors1;
    }

    @Override
    public List<Power_supply> findAllPower_supply() throws IOException {
        String _power_supplies = jedis.get("power_supply");
        ObjectMapper mapper=new ObjectMapper();
        if (_power_supplies==null){
            List<Power_supply> power_supplies = goodsDao.findAllPower_supply();

            String power_suppliesJson = mapper.writeValueAsString(power_supplies);
            jedis.set("power_supply",power_suppliesJson);
            return power_supplies;
        }
        List<Power_supply> power_supplies1 = mapper.readValue(_power_supplies, List.class);
        return power_supplies1;
    }

    @Override
    public List<Healthy> findAllHealthy() throws IOException {
        String _healthy = jedis.get("healthy");
        ObjectMapper mapper=new ObjectMapper();
        if (_healthy==null){
            List<Healthy> healthy = goodsDao.findAllHealthy();

            String healthyJson = mapper.writeValueAsString(healthy);
            jedis.set("healthy",healthyJson);
            return healthy;
        }
        List<Healthy> healthy1 = mapper.readValue(_healthy, List.class);
        return healthy1;
    }

    @Override
    public List<Live> findAllLive() throws IOException {
        String _lives = jedis.get("live");
        ObjectMapper mapper=new ObjectMapper();
        if (_lives==null){
            List<Live> lives = goodsDao.findAllLive();

            String livesJson = mapper.writeValueAsString(lives);
            jedis.set("live",livesJson);
            return lives;
        }
        List<Live> lives1 = mapper.readValue(_lives, List.class);
        return lives1;
    }

    @Override
    public List<Electrical> findAllElectrical() throws IOException {
        String _electricals = jedis.get("electrical");
        ObjectMapper mapper=new ObjectMapper();
        if (_electricals==null){
            List<Electrical> electricals = goodsDao.findAllElectrical();

            String electricalJson = mapper.writeValueAsString(electricals);
            jedis.set("electrical",electricalJson);
            return electricals;
        }
        List<Electrical> electricals1 = mapper.readValue(_electricals, List.class);
        return electricals1;
    }

    @Override
    public List<Headset> findAllHeadset() throws IOException {
        String _headset = jedis.get("headset");
        ObjectMapper mapper=new ObjectMapper();
        if (_headset==null){
            List<Headset> headset = goodsDao.findAllHeadset();

            String headsetJson = mapper.writeValueAsString(headset);
            jedis.set("headset",headsetJson);
            return headset;
        }
        List<Headset> headset1 = mapper.readValue(_headset, List.class);
        return headset1;
    }

    @Override
    public List<Phone> findPhoneInLimit() {
        return goodsDao.findPhoneInLimit();
    }


    @Override
    public Phone showPhoneDetails(int id) {
        return goodsDao.showPhoneDetails(id);
    }

    @Override
    public int buyGood(int pid,int uid,String money) {
        return goodsDao.updateUserBuy(pid,uid,money);
    }



}
