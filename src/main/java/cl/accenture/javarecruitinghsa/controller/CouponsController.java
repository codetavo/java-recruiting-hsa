package cl.accenture.javarecruitinghsa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.javarecruitinghsa.pojo.Coupon;
import cl.accenture.javarecruitinghsa.pojo.ErrorResponse;
import cl.accenture.javarecruitinghsa.service.CouponsService;

@Component("couponsController")
@RestController
public class CouponsController {

    @Autowired
    @Qualifier("couponsService")
    CouponsService couponsService;

    @RequestMapping(value = "/coupons", method = RequestMethod.GET)
	public ResponseEntity<?> getListCoupons() {
        ResponseEntity<?> response = null;
        try{
            List<Coupon> listCoupon = new ArrayList<Coupon>();
            listCoupon = this.couponsService.getListCouponsService();
            response = new ResponseEntity<List<Coupon>>(listCoupon, HttpStatus.OK);
        }catch(Exception e){
            ErrorResponse error = new ErrorResponse();
            error.setCode("500");
            error.setMessage(e.getMessage());
            response = new ResponseEntity<ErrorResponse>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
}
