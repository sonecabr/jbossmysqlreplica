package com.obviobrasil.soneca.poc.mysqlreplica.beans.core.entity;

import javax.persistence.*;

/**
 * @author andre
 * @since 28/05/2016 12:00
 */
@Entity
@Table(name = "TEST")
public class TestEntity {

    @Column(name = "id", precision = 7, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "text", nullable = false, precision = 255)
    private String text;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for property 'text'.
     *
     * @return Value for property 'text'.
     */
    public String getText() {
        return text;
    }

    /**
     * Setter for property 'text'.
     *
     * @param text Value to set for property 'text'.
     */
    public void setText(String text) {
        this.text = text;
    }
}
