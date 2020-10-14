package cl.accenture.javarecruitinghsa.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cl.accenture.javarecruitinghsa.pojo.Coupon;
import cl.accenture.javarecruitinghsa.service.impl.CouponsServiceImpl;

public class CouponsServiceTest {

    @Mock
    private RestTemplate restTemplate;
    
    private CouponsServiceImpl couponsServiceImpl;
    private List<Coupon> listCoupon;
    private Coupon coupon;
    private ResponseEntity<List<Coupon>> couponAPI;
    
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

        couponsServiceImpl = new CouponsServiceImpl();
        couponAPI = new ResponseEntity<>(listCoupon, HttpStatus.OK);    }

    @Test
	public void getListCouponsServiceCorrecto() throws Exception {
        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.<HttpMethod>any(), 
            Mockito.<HttpEntity<?>>any(),Mockito.eq(new ParameterizedTypeReference<List<Coupon>>() {}))).thenReturn(couponAPI);
		Whitebox.setInternalState(couponsServiceImpl, "restTemplate", restTemplate);
		List<Coupon> response = couponsServiceImpl.getListCouponsService();
        Assertions.assertNotNull(response);
    }
    
}
