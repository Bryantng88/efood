package com.efood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by fan.jin on 2016-11-03.
 */

@SuppressWarnings("serial")
@Entity
@Table(name="AUTHORITY")
public class Authority implements GrantedAuthority {

    @Override
	public String toString() {
		return "Authority [id=" + id + ", name=" + name + "]";
	}

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated( EnumType.STRING)
    @Column(name="name")
    EUserRoleName name;

    @Override
    public String getAuthority() {
        return name.name();
    }

    public void setName(EUserRoleName name) {
        this.name = name;
    }

    @JsonIgnore
    public EUserRoleName getName() {
        return name;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
