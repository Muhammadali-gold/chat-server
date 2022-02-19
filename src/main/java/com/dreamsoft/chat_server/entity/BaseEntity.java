package com.dreamsoft.chat_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Map;

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    //Code omitted for brevity

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
    protected Long id;

    @CreationTimestamp
    @JsonIgnore
    protected Timestamp createdAt;
    @UpdateTimestamp
    @JsonIgnore
    protected Timestamp updatedAt;
    @JsonIgnore
    protected Long createdBy;
    @JsonIgnore
    protected Long updatedBy;
    @Column
    @JsonIgnore
    protected Integer state = 1;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @JsonIgnore
    private Map<String,String> attributes;

    public void addAttribute(String key,String value){
        attributes.put(key, value);
    }

    public String getAttribute(String key){
        return attributes.getOrDefault(key,"-");
    }
}

