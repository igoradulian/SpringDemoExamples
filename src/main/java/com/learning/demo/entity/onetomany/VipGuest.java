package com.learning.demo.entity.onetomany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.demo.entity.manytoone.VipGuestFeedBack;
import com.learning.demo.entity.onetoone.VipRoom;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class VipGuest{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "phone")
    private String phoneNumber;

    @OneToMany(mappedBy = "vipGuest", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter(AccessLevel.NONE)
    private List<VipGuestFeedBack> guestFeedBackList;

    @OneToOne(mappedBy = "vipGuest", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private VipRoom vipRoom;

}
