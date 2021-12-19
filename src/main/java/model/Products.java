package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {
    @XmlElement(name = "ProductModel")
    private List<ProductModel> productCollection;

    public List<ProductModel> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(List<ProductModel> productCollection) {
        this.productCollection = productCollection;
    }
}
