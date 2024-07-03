package top.shanhai1024.entity.PO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleStatistics {
    private long total;
    private long students;
    private long teachers;
    private long others;
}
