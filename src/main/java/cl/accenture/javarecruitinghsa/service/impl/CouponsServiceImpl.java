package cl.accenture.javarecruitinghsa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.accenture.javarecruitinghsa.pojo.Coupon;
import cl.accenture.javarecruitinghsa.service.CouponsService;

@Service("couponsService")
public class CouponsServiceImpl implements CouponsService{

    @Autowired
	RestTemplate restTemplate;

    @Override
	public List<Coupon> getListCouponsService(){
        List<Coupon> listCoupon = new ArrayList<Coupon>();
        String urlCoupon = "http://localhost:8081/coupons";
        HttpHeaders headersCoupon = new HttpHeaders();
        HttpEntity<?> requestEntityCoupon = new HttpEntity<>(headersCoupon);
        ResponseEntity<List<Coupon>> couponAPI = restTemplate.exchange(urlCoupon, HttpMethod.GET, requestEntityCoupon, 
            new ParameterizedTypeReference<List<Coupon>>() {});
        listCoupon = couponAPI.getBody();
        return listCoupon;
    }
    
}
