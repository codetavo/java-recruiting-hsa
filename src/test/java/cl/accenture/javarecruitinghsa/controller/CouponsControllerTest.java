package cl.accenture.javarecruitinghsa.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cl.accenture.javarecruitinghsa.pojo.Coupon;
import cl.accenture.javarecruitinghsa.service.CouponsService;

public class CouponsControllerTest {

    @Mock
    private CouponsService couponsService;
    
    private CouponsController couponsController;
    private List<Coupon> listCoupon;
    private Coupon coupon;
    
    @BeforeEach
	public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        listCoupon = new ArrayList<Coupon>();
        coupon = new Coupon();
        
        coupon.setId("id");
        coupon.setDescription("description");
        coupon.setSeller("seller");
        coupon.setImage("image");
        coupon.setExpiresAt("expiresAt");

        listCoupon.add(coupon);
        couponsController = new CouponsController();
    }

    @Test
    public void getListCouponsCorrecto() throws Exception{
        Mockito.when(couponsService.getListCouponsService()).thenReturn(listCoupon);
        Whitebox.setInternalState(couponsController, "couponsService",couponsService);
        ResponseEntity<List<Coupon>> response = (ResponseEntity<List<Coupon>>) couponsController.getListCoupons();
        Assertions.assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
    }


}
