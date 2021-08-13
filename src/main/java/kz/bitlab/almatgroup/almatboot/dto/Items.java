package kz.bitlab.almatgroup.almatboot.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Items {

    private Long id;
    private String name;
    private int amount;
    private double price;

}
