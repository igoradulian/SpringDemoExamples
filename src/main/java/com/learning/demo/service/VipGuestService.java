package com.learning.demo.service;

import com.learning.demo.dto.VipGuestDTO;
import com.learning.demo.entity.onetomany.VipGuest;

public interface VipGuestService {

    public VipGuest createVipGuest(VipGuestDTO vipGuest);
    public VipGuestDTO getVipGuest(String phone);
}
