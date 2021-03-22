package hu.bme.mit.train.tachograph;

import com.google.common.collect.*;
import java.time.LocalDateTime;

public class TrainTachograph {

    private Table<LocalDateTime, Integer, Integer> tachoTable;

    public TrainTachograph(){
        tachoTable = TreeBasedTable.create();
    }

    public void add(Integer joyPos, Integer refSpe){
        tachoTable.put(LocalDateTime.now(), joyPos, refSpe);
    }

    public Table<LocalDateTime, Integer, Integer> gettachoTable() {
        return tachoTable;
    }

    public int getSize(){
        return tachoTable.size();
    }
}
