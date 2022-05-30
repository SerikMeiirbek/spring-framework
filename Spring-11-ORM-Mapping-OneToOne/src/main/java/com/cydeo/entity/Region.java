package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="regions")
public class Region extends BaseEntity{

    String region;
    String country;

}
