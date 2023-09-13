package inventory_microService.inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="inventory")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
