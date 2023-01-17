package com.kheffache.gestionDeStock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // à chaque interogation de la bd elle verifie cretedate et... pour mettre à jour
public class AbstractEntity implements Serializable {

   @Id
   @GeneratedValue()
   private Integer id;

   @CreatedDate
   @Column(name= "creationDate", nullable = false)
   @JsonIgnore
   private Date creationDate;

   @LastModifiedDate
   @Column(name= "lastUpdateDate")
   @JsonIgnore
   private Date lastUpdateDate;
}
