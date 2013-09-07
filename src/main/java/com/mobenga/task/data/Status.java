package com.mobenga.task.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Status {
    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    @XmlAttribute(name = "Code")
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (code != null ? !code.equals(status.code) : status.code != null) return false;
        if (name != null ? !name.equals(status.name) : status.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
