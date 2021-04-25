package dao.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.GoodsDao;
import domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.Collections;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Phone> findAllPhone() {
        String sql="select * from phones";
        try {
            List<Phone> phones = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Phone.class));
            return phones;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Intelligence> findAllIntelligence() throws JsonProcessingException {
        String sql="select * from intelligence";
        try {
            List<Intelligence> intelligences = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Intelligence.class));
            return intelligences;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Notebook> findAllNotebook() throws JsonProcessingException {
        String sql="select * from notebook";
        try {
            List<Notebook> notebooks = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Notebook.class));
            return notebooks;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Outdoor> findAllOutdoor() throws JsonProcessingException {
        String sql="select * from outdoor";
        try {
            List<Outdoor> outdoors = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Outdoor.class));
            return outdoors;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Power_supply> findAllPower_supply() throws JsonProcessingException {
        String sql="select * from power_supply";
        try {
            List<Power_supply> power_supplies = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Power_supply.class));
            return power_supplies;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Healthy> findAllHealthy() throws JsonProcessingException {
        String sql="select * from healthy";
        try {
            List<Healthy> healthies = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Healthy.class));
            return healthies;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Live> findAllLive() throws JsonProcessingException {
        String sql="select * from live";
        try {
            List<Live> lives = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Live.class));
            return lives;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Electrical> findAllElectrical() throws JsonProcessingException {
        String sql="select * from electrical";
        try {
            List<Electrical> electricals = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Electrical.class));
            return electricals;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Headset> findAllHeadset() throws JsonProcessingException {
        String sql="select * from headset";
        try {
            List<Headset> headsets = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Headset.class));
            return headsets;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Phone> findPhoneInLimit() {
        String sql="select * from phones limit 0,8";
        try {
            List<Phone> phones = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Phone.class));
            return phones;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Phone showPhoneDetails(int pid) {
        String sql1="select * from phones where pid=?";
        String sql2="select * from phone_version_money where vid=?";
        String sql3="select * from phone_color where cid=?";
        try {
            Phone phone = jdbcTemplate.queryForObject(sql1, new BeanPropertyRowMapper<>(Phone.class),pid);
            Color color = jdbcTemplate.queryForObject(sql3, new BeanPropertyRowMapper<>(Color.class),phone.getPid());
            List<PhoneVersion> versions = jdbcTemplate.query(sql2, new BeanPropertyRowMapper<>(PhoneVersion.class), phone.getPid());
            phone.setVersions(versions);
            phone.setColors(color);
            return phone;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateUserBuy(int pid,int uid,String money) {
        String sql1="select version from phone_version_money where money=?";
        String sql2="insert int user_phones(userId,phoneId,phoneversion) values(?,?,?)";
        String version = jdbcTemplate.queryForObject(sql1, String.class, money);
        int update = jdbcTemplate.update(sql2, uid, pid, version);
        return update;
    }


}
