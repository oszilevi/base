import com.google.common.collect.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TrainTachograph {

    private Table<LocalDateTime, Integer, Integer> tacho_table;

    public TrainTachograph(){
        tacho_table = TreeBasedTable.create();
    }

    public void add(Integer joy_pos, Integer ref_spe){
        tacho_table.put(LocalDateTime.now(), joy_pos, ref_spe);
    }

    public Table<LocalDateTime, Integer, Integer> getTacho_table() {
        return tacho_table;
    }

    public int get_size(){
        return tacho_table.size();
    }
}
