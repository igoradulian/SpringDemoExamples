package com.learning.demo.entity.manytoone;

import com.learning.demo.entity.onetomany.VipGuest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VipGuestFeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String feedback;

    @ManyToOne
    @JoinColumn(name = "vipGuest_id")
    private VipGuest vipGuest;
}
