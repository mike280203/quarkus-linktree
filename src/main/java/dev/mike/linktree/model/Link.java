package dev.mike.linktree.model;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "links")
public class Link extends PanacheEntity {

    @Column(nullable = false, length = 120)
    public String title;

    @Column(nullable = false, length = 2048)
    public String url;

    @Column(length = 500)
    public String description;

    @Column(length = 100)
    public String icon;

    @Column(nullable = false)
    public Integer sortOrder = 0;

    @Column(nullable = false)
    public boolean active = true;


    public static List<Link> findActiveOrdered() {
        return find("active = true order by sortOrder asc, id asc").list();
    }
}
