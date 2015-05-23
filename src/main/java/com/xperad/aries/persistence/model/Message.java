package com.xperad.aries.persistence.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */

@Entity
@Table(name = "t_message")
public class Message extends BaseEntity {


    @NotNull(message = "{validator.message.title.null}")
    @NotEmpty(message = "{validator.message.title.empty}")
    @Column(name = "title")
    private String title;

    @NotNull(message = "{validator.message.message.null}")
    @NotEmpty(message = "{validator.message.message.empty}")
    @Column(name = "message")
    private String message;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Message message1 = (Message) o;

        if (getTitle() != null ? !getTitle().equals(message1.getTitle()) : message1.getTitle() != null) return false;
        return !(getMessage() != null ? !getMessage().equals(message1.getMessage()) : message1.getMessage() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        return result;
    }
}
