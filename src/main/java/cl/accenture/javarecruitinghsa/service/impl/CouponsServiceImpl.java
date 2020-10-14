package cl.accenture.javarecruitinghsa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.accenture.javarecruitinghsa.pojo.Coupon;
import cl.accenture.javarecruitinghsa.service.CouponsService;

@Service("couponsService")
public class CouponsServiceImpl implements CouponsService{

    @Override
	public List<Coupon> getListCouponsService(){

        List<Coupon> listCoupon = new ArrayList<Coupon>();

        return listCoupon;
    }
    
}
