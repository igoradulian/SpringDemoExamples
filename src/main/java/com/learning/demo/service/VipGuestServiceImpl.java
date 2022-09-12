package com.learning.demo.service;

import com.learning.demo.dto.VipGuestDTO;
import com.learning.demo.entity.manytoone.VipGuestFeedBack;
import com.learning.demo.entity.onetomany.VipGuest;
import com.learning.demo.entity.onetoone.VipRoom;
import com.learning.demo.repository.VipGuestFeedbackRepository;
import com.learning.demo.repository.VipGuestRepository;
import com.learning.demo.repository.VipRoomRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;
import java.util.Set;

@Service
public class VipGuestServiceImpl implements VipGuestService{

    private VipGuestRepository vipGuestRepository;
    private VipRoomRepository vipRoomRepository;
    private VipGuestFeedbackRepository vipGuestFeedbackRepository;

    @Autowired
    public VipGuestServiceImpl(VipGuestRepository vipGuestRepository, VipRoomRepository vipRoomRepository, VipGuestFeedbackRepository vipGuestFeedbackRepository) {
        this.vipGuestRepository = vipGuestRepository;
        this.vipRoomRepository = vipRoomRepository;
        this.vipGuestFeedbackRepository = vipGuestFeedbackRepository;
    }

    @Override
    public VipGuest createVipGuest(VipGuestDTO vipGuestDTO) {

        //Get vipGuestFeedBack objects List from VipGuest object
        List <VipGuestFeedBack> vipGuestFeedBackList = vipGuestDTO.getGuestFeedBackList();

        /*
        Create new vipRoom object
        use setter/getter methods
        assign appropriate fields
        You can also use ModelMapper
        or ObjectMapper for large classes.
        The last step, overwrite field
        in
         */

        ModelMapper modelMapper = new ModelMapper();
        //Strictly matches source and destination properties
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        VipGuest vipGuest = modelMapper.map(vipGuestDTO, VipGuest.class);

        VipRoom vipRoom = new VipRoom();
        vipRoom.setVipGuest(vipGuest);
        vipRoom.setRoomNumber(vipGuest.getVipRoom().getRoomNumber());
        vipGuest.setVipRoom(vipRoom);

        VipGuest vipGuestSaved = vipGuestRepository.save(vipGuest);

        for(VipGuestFeedBack v:  vipGuestFeedBackList)
        {
            v.setVipGuest(vipGuestSaved);
            vipGuestFeedbackRepository.save(v);
        }

        return vipGuestSaved;
    }

    @Override
    public VipGuestDTO getVipGuest(String phone) {
        VipGuest vipGuest = vipGuestRepository.findByPhoneNumber(phone);
        List<VipGuestFeedBack> vipGuestFeedBackList = vipGuestFeedbackRepository.findVipGuestFeedBacksByVipGuest_Id(vipGuest.getId());
        System.out.println(vipGuestFeedBackList.size());
        VipRoom vipRoom = vipRoomRepository.findById(vipGuest.getId()).orElseThrow( () -> new RuntimeException("Room doesn't exist"));

        vipGuest.setGuestFeedBackList(vipGuestFeedBackList);
        vipGuest.setVipRoom(vipRoom);

        ModelMapper modelMapper = new ModelMapper();
        //Strictly matches source and destination properties
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        VipGuestDTO vipGuestDTO = modelMapper.map(vipGuest, VipGuestDTO.class);

        return vipGuestDTO;
    }
}
