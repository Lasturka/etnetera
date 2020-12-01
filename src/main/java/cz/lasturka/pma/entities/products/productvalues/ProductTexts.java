package cz.lasturka.pma.entities.products.productvalues;

import cz.lasturka.pma.entities.generalvalues.AText;
import cz.lasturka.pma.entities.generalvalues.Language;

import javax.persistence.Entity;

@Entity
public class ProductTexts extends AText {

    String nameShort;

    String nameLong;

    String descriptionShort;

    String descriptionLong;

    public ProductTexts() {
        this(Language.CZECH);
    }

    public ProductTexts(Language language) {
        super();
        super.setLanguage(language);
    }

    public String getNameShort() { return nameShort; }
    public void setNameShort(String nameShort) { this.nameShort = nameShort; }

    public String getNameLong() { return nameLong; }
    public void setNameLong(String nameLong) { this.nameLong = nameLong; }

    public String getDescriptionShort() { return descriptionShort; }
    public void setDescriptionShort(String descriptionShort) { this.descriptionShort = descriptionShort; }

    public String getDescriptionLong() { return descriptionLong; }
    public void setDescriptionLong(String descriptionLong) { this.descriptionLong = descriptionLong; }

}