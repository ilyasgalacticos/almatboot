package kz.bitlab.almatgroup.almatboot.db;

import kz.bitlab.almatgroup.almatboot.dto.Items;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Items> tovary = new ArrayList<>();

    private static Long id = 5L;

    static {

        tovary.add(new Items(1L, "IPhone 12 PRO", 20, 450000));
        tovary.add(new Items(2L, "IPhone 11 PRO", 30, 350000));
        tovary.add(new Items(3L, "IPhone 10 PRO", 10, 300000));
        tovary.add(new Items(4L, "XIAOMI REDMI NOTE 8", 10, 75000));

    }

    public static void addItem(Items item){
        item.setId(id);
        tovary.add(item);
        id++;
    }

    public static ArrayList<Items> getAllItems(){
        return tovary;
    }

    public static Items getItem(Long id){
        for(Items it : tovary){
            if(it.getId()==id) return it;
        }
        return null;
    }

}
