package com.banking.wallets;

import com.banking.wallets.DTO.RequestRegister;
import com.banking.wallets.database.ServiceResponse;
import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;
import java.util.Date;

public class testTime {

    @Test
    public void testFormattime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format( new Date()   );
//        Date date = format.parse ( "2009-12-31" );
    }

//    @Test
//    public void checkResponseRegister(){
//        ServiceResponse serviceResponse = new ServiceResponse();
//        RequestRegister requestRegister = new RequestRegister();
//        requestRegister.setName("jame");
//        String repsose = serviceResponse.responseRegister(requestRegister,true);
//        assertTrue();
//
//    }
}
