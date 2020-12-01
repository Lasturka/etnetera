package cz.lasturka.pma.entities.generalvalues;

import javax.persistence.*;

@MappedSuperclass
public abstract class AText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    Language language;

    String name;

    String description;

    protected AText() { }


    public Long getId() {
        return id;
    }

    public Language getLanguage() { return language; }
    public void setLanguage(Language language) { this.language = language; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
