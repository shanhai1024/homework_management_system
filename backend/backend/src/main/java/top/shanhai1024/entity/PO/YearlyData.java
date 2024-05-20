package top.shanhai1024.entity.PO;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "yearly_data")
public class YearlyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    private int year;
    private double value;

    // getters and setters
}
