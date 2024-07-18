package br.com.edu.foodfusion.shared.database.entity.inventory.supplier;

import br.com.edu.foodfusion.shared.database.converter.PaymentMethodConverter;
import br.com.edu.foodfusion.shared.database.converter.SupplierCategoryConverter;
import br.com.edu.foodfusion.shared.database.entity.contact.info.AddressEntity;
import br.com.edu.foodfusion.shared.database.entity.contact.info.PhoneEntity;
import br.com.edu.foodfusion.shared.database.enums.PaymentMethodEnum;
import br.com.edu.foodfusion.shared.database.enums.SupplierCategoryEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "suppliers")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_name") // Equivalent to Razão Social
    private String companyName;

    @Column(name = "trade_name") // Equivalent to Nome Fantasia
    private String tradeName;

    @Column(name = "document", length = 14, nullable = false)
    private String document;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private PhoneEntity phone;

    @Column(name = "website")
    private String website;

    /**
     * Minimum Order Quantity (MOQ): The minimum quantity of a product that must be ordered from the supplier.
     */
    @Column(name = "moq")
    private int minimumOrderQuantity;

    /**
     * Performance Rating: An internal rating system to track the supplier's reliability, such as on-time delivery rate and product quality.
     */
    @Column(name = "performance_rating", precision = 10, scale = 2)
    private BigDecimal performanceRating;

    /**
     * Notes: A section for any additional notes or information about the supplier, such as special instructions for placing orders or contact details for specific departments.
     */
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "notes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "notes")
    private List<String> notes;

    @Enumerated(EnumType.STRING)
    @Convert(converter = SupplierCategoryConverter.class)
    private SupplierCategoryEnum category;

    @Enumerated(EnumType.STRING)
    @Convert(converter = PaymentMethodConverter.class)
    @Column(name = "preferred_payment_method")
    private PaymentMethodEnum preferredPaymentMethod;
}
