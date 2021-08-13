package kz.bitlab.almatgroup.almatboot.beans;

import kz.bitlab.almatgroup.almatboot.dto.Items;

import java.util.ArrayList;

public interface ItemManager {

    void addItem(Items item);
    ArrayList<Items> getAllItems();
    Items getItem(Long id);

}
