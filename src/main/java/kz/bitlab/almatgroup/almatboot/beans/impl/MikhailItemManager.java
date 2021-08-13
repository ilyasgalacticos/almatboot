package kz.bitlab.almatgroup.almatboot.beans.impl;

import kz.bitlab.almatgroup.almatboot.beans.ItemManager;
import kz.bitlab.almatgroup.almatboot.dto.Items;

import java.util.ArrayList;

public class MikhailItemManager implements ItemManager {

    private ArrayList<Items> tovary = new ArrayList<>();

    private Long id = 5L;

    public MikhailItemManager(){
        tovary.add(new Items(1L, "IPhone 12 PRO", 20, 450000));
        tovary.add(new Items(2L, "IPhone 11 PRO", 30, 350000));
        tovary.add(new Items(3L, "IPhone 10 PRO", 10, 300000));
        tovary.add(new Items(4L, "XIAOMI REDMI NOTE 8", 10, 75000));
    }

    @Override
    public void addItem(Items item) {
        item.setId(id);
        tovary.add(item);
        id++;
    }

    @Override
    public ArrayList<Items> getAllItems() {
        return tovary;
    }

    @Override
    public Items getItem(Long id) {
        for(Items it : tovary){
            if(it.getId()==id) return it;
        }
        return null;
    }
}
