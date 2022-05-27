package dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomDTO {
    private String id ;
    private String name;
    private String address;

    private String code;
    private String description;
    private BigDecimal unitePrice;
    private int qtyOnHand;

    private String orderId;
    private LocalDate orderDate;
    private String customerId;

    public CustomDTO() {
    }

    public CustomDTO(String id, String code, BigDecimal unitePrice, int qtyOnHand, String orderId, LocalDate orderDate) {
        this.id = id;
        this.code = code;
        this.unitePrice = unitePrice;
        this.qtyOnHand = qtyOnHand;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public CustomDTO(String id, String name, String address, String code,
                     String description, BigDecimal unitePrice, int qtyOnHand,
                     String orderId, LocalDate orderDate, String customerId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.code = code;
        this.description = description;
        this.unitePrice = unitePrice;
        this.qtyOnHand = qtyOnHand;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(BigDecimal unitePrice) {
        this.unitePrice = unitePrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitePrice=" + unitePrice +
                ", qtyOnHand=" + qtyOnHand +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
