package com.learning.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.demo.entity.manytoone.VipGuestFeedBack;
import com.learning.demo.entity.onetoone.VipRoom;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Igor Adulyan
 */
@Getter
@Setter
@NoArgsConstructor
public class VipGuestDTO {

    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    private String lastName;

    @Size(max = 50)
    private String phoneNumber;

    /*
   @JsonInclude enforce non-null fields in Json objects
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<VipGuestFeedBack> guestFeedBackList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private VipRoom vipRoom;
}
