package com.immoc.dataObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {

        @Id
        private String productId;

        private String productName;

        private Integer productStock;

        private String productDescription;

        private String productIcon;

        private BigDecimal productPrice;

        private Integer productStatus;

        private Integer categoryType;

}
